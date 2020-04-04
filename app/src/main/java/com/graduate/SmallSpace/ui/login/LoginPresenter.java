package com.graduate.SmallSpace.ui.login;

import com.cxz.baselibs.mvp.BasePresenter;


public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View>
        implements LoginContract.Presenter {

    @Override
    protected LoginContract.Model createModel() {
        return new LoginModel();
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
