package com.cxz.baselibs.base;

import android.content.Intent;
import android.os.Bundle;

import com.cxz.baselibs.mvp.BasePresenter;
import com.cxz.baselibs.mvp.IView;
import com.cxz.baselibs.widget.CustomToast;
import com.cxz.baselibs.widget.LoadingDialog;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;


/**
 * @author chenxz
 * @date 2018/8/20
 * @desc BaseMvpActivity
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements IView {

    protected P mPresenter;

    protected abstract P createPresenter();

    private LoadingDialog loadingDialog;

    @Override
    protected void initView(Bundle savedInstanceState) {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }

        loadingDialog=new LoadingDialog.Builder(this)
                .setCancelable(false)
                .setCancelOutside(false)
                .setMessage("加载中")
                .setIsShowMessage(true)
                .create();
    }

    @Override
    public void tokenTerminate() {
        Intent intent_login = new Intent();
        intent_login.setAction("android.intent.action.MAIN");
        intent_login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //关键的一句，将新的activity置为栈顶
        startActivity(intent_login);
        finish();
    }

    @Override
    public void showLoading() {
        loadingDialog.show();
    }

    @Override
    protected boolean useEventBus() {
        return true;
    }

    @Override
    public void hideLoading() {
        loadingDialog.hide();
    }

    @Override
    public void showDefaultMsg(String msg) {
        new CustomToast(this, msg).show();
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        showDefaultMsg(errorMsg);
    }

    @Override
    public void showMsg(String msg) {
        showDefaultMsg(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        this.mPresenter = null;
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return bindUntilEvent(ActivityEvent.DESTROY);
    }

}
