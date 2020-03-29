package com.graduate.SmallSpace.ui.login;


import com.cxz.baselibs.bean.BaseBean;
import com.cxz.baselibs.mvp.IModel;
import com.cxz.baselibs.mvp.IPresenter;
import com.cxz.baselibs.mvp.IView;

import io.reactivex.Observable;


public interface LoginContract {

    interface View extends IView {
        /**
         * 账号字符串检测
         *
         * @param loginSelect     登录
         * @param clearVisibility 清除
         */
        void accountCheckResult(boolean loginSelect, boolean clearVisibility);

        /**
         * 检测是否可以登录
         *
         * @param loginSelect     登录
         */
        void loginCheckResult(boolean loginSelect);
    }

    interface Presenter extends IPresenter<View> {

        /**
         * 测试
         */
        void getBaiDu();

        /**
         * 账号字符串检测
         *
         * @param accountStr     账号
         * @param passStr 密码
         */
        void accountCheck(String accountStr,String passStr,boolean isAccount);




    }

    interface Model extends IModel {

        Observable<BaseBean> getBaiDuInfo();

    }
}
