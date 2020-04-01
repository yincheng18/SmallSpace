package com.graduate.SmallSpace.ui.login;

import android.annotation.SuppressLint;

import com.cxz.baselibs.mvp.BasePresenter;
import com.cxz.baselibs.rx.BaseObserver;
import com.graduate.SmallSpace.bean.WeiXinBean;


public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View>
        implements LoginContract.Presenter {

    @Override
    protected LoginContract.Model createModel() {
        return new LoginModel();
    }

    @SuppressLint("CheckResult")
    @Override
    public void getBaiDu() {
        getModel().getBaiDuInfo()
                .compose(getView().<WeiXinBean>bindToLife())
                .subscribe(new BaseObserver<WeiXinBean>(getView()) {

                    @Override
                    protected void onSuccess(WeiXinBean baseBean) {
                        getView().showMsg(baseBean.getMessage());
                    }
                });
    }

    @Override
    public void accountCheck(String accountStr, String passStr, boolean isAccount) {

        boolean isLogin = false;
        if (isAccount) {
            boolean isClear = false;
            if (passStr.length() >= 6 && accountStr.length() >= 6) {
                isLogin = true;
            }

            if (!accountStr.equals("")) {
                isClear = true;
            }
            getView().accountCheckResult(isLogin, isClear);
        } else {
            if (passStr.length() >= 6 && accountStr.length() >= 6) {
                isLogin = true;
            }
            getView().loginCheckResult(isLogin);
        }
    }

}
