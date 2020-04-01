package com.graduate.SmallSpace.ui.login;

import com.cxz.baselibs.mvp.BaseModel;
import com.graduate.SmallSpace.bean.WeiXinBean;
import com.graduate.SmallSpace.retrofit.RetrofitHelper;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginModel extends BaseModel implements LoginContract.Model {
    @Override
    public Observable<WeiXinBean> getBaiDuInfo() {
        return RetrofitHelper.getRetrofitService().pingBaiDu()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
