package com.graduate.SmallSpace.ui.login;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxz.baselibs.base.BaseMvpActivity;
import com.cxz.baselibs.utils.StatusBarUtil;
import com.cxz.baselibs.widget.LoadingDialog;
import com.cxz.baselibs.widget.MyTextWatch;
import com.graduate.SmallSpace.R;
import com.graduate.SmallSpace.activity.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.accountEt)
    EditText accountEt;
    @BindView(R.id.passEt)
    EditText passEt;
    @BindView(R.id.loginTv)
    TextView loginTv;
    @BindView(R.id.infoIv)
    ImageView infoIv;
    @BindView(R.id.showIv)
    ImageView showIv;
    @BindView(R.id.clearIv)
    ImageView clearIv;



    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        StatusBarUtil.setAndroidNativeLightStatusBar(this, true);


    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        mPresenter.addDispose(getRxPermissions().request(Manifest.permission.RECORD_AUDIO,Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {

                    }
                }));

        new LoadingDialog.Builder(this)
                .setCancelable(false)
                .setCancelOutside(false)
                .setMessage("加载中")
                .setIsShowMessage(true)
                .create().show();
    }

    @Override
    protected void initListener() {
        accountEt.addTextChangedListener(new MyTextWatch() {
            @Override
            public void onTextChanged(CharSequence s) {
               mPresenter.accountCheck(accountEt.getText().toString(),passEt.getText().toString(),true);
            }
        });

        passEt.addTextChangedListener(new MyTextWatch() {
            @Override
            public void onTextChanged(CharSequence s) {
                mPresenter.accountCheck(accountEt.getText().toString(),passEt.getText().toString(),false);
            }
        });
    }

    @OnClick({R.id.registerTv, R.id.clearIv, R.id.showIv, R.id.infoIv, R.id.loginTv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.registerTv:

                break;
            case R.id.clearIv:
                accountEt.setText("");
                break;
            case R.id.showIv:
                if (showIv.isSelected()) {
                    showIv.setBackgroundResource(R.mipmap.show_icon);
                    passEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    showIv.setBackgroundResource(R.mipmap.dismiss_icon);
                    passEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                passEt.setSelection(passEt.getText().toString().length());
                showIv.setSelected(!showIv.isSelected());
                break;
            case R.id.infoIv:
                infoIv.setSelected(!infoIv.isSelected());
                break;
            case R.id.loginTv:
                if (loginTv.isSelected()) {
                    if (infoIv.isSelected()) {
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    } else {
                        showMsg("请勾选用户协议");
                    }

                } else {
                    showMsg("请检查格式");
                }
                break;
        }
    }

    @Override
    public void accountCheckResult(boolean loginSelect, boolean clearVisibility) {
        loginTv.setSelected(loginSelect);
        clearIv.setVisibility(clearVisibility ? View.VISIBLE : View.GONE);
    }

    @Override
    public void loginCheckResult(boolean loginSelect) {
        loginTv.setSelected(loginSelect);
    }
}
