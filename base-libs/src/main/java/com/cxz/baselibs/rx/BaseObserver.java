package com.cxz.baselibs.rx;

import com.cxz.baselibs.app.BaseApp;
import com.cxz.baselibs.bean.BaseBean;
import com.cxz.baselibs.http.exception.ExceptionHandle;
import com.cxz.baselibs.mvp.IView;
import com.cxz.baselibs.utils.NetworkUtil;

import io.reactivex.observers.ResourceObserver;

import static com.cxz.baselibs.http.HttpStatus.SUCCESS;

/**
 * @author chenxz
 * @date 2018/9/1
 * @desc BaseObserver
 */
public abstract class BaseObserver<T extends BaseBean> extends ResourceObserver<T> {

    private IView mView;
    private String mErrorMsg = "";
    private boolean bShowLoading = true;

    public BaseObserver(IView view) {
        this.mView = view;
    }

    public BaseObserver(IView view, boolean bShowLoading) {
        this.mView = view;
        this.bShowLoading = bShowLoading;
    }

    /**
     * 成功的回调
     */
    protected abstract void onSuccess(T t);

    /**
     * 错误的回调
     */
    protected void onError(T t) {
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (bShowLoading) mView.showLoading();
        if (!NetworkUtil.isConnected(BaseApp.getInstance())) {
//            mView.showDefaultMsg("当前网络不可用，请检查网络设置");
            onComplete();
        }
    }

    @Override
    public void onNext(T t) {
        mView.hideLoading();
        if (t.getHttpCode() == SUCCESS) {
            onSuccess(t);
        }else{
            onError(t);
            mView.showErrorMsg(t.getHttpMessage());
        }
    }

    @Override
    public void onError(Throwable e) {
        mView.hideLoading();
        if (mView == null) {
            throw new RuntimeException("mView can not be null");
        }
        if (mErrorMsg.isEmpty()) {
            mErrorMsg = ExceptionHandle.handleException(e);
        }
        mView.showDefaultMsg(mErrorMsg);
    }

    @Override
    public void onComplete() {
        mView.hideLoading();
    }
}
