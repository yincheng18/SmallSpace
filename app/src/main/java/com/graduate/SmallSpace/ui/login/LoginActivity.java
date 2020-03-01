package com.graduate.SmallSpace.ui.login;

import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.graduate.SmallSpace.activity.MainActivity;
import com.graduate.SmallSpace.R;
import com.graduate.SmallSpace.base.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private ImageView infoIv, clearIv, showIv;

    private EditText accountEt, passEt;

    private TextView loginTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    @Override
    protected void initView() {
        infoIv = findViewById(R.id.infoIv);
        infoIv.setSelected(true);
        infoIv.setOnClickListener(this);

        loginTv = findViewById(R.id.loginTv);
        loginTv.setOnClickListener(this);

        clearIv = findViewById(R.id.clearIv);
        clearIv.setOnClickListener(this);

        showIv = findViewById(R.id.showIv);
        showIv.setOnClickListener(this);
        showIv.setSelected(true);

        accountEt = findViewById(R.id.accountEt);
        accountEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (passEt.getText().toString().length() >= 6 && accountEt.getText().toString().length() >= 6) {
                    loginTv.setSelected(true);
                } else {
                    loginTv.setSelected(false);
                }

                if (!accountEt.getText().toString().equals("")) {
                    clearIv.setVisibility(View.VISIBLE);
                } else {
                    clearIv.setVisibility(View.GONE);
                }
            }
        });
        passEt = findViewById(R.id.passEt);
        passEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (passEt.getText().toString().length() >= 6 && accountEt.getText().toString().length() >= 6) {
                    loginTv.setSelected(true);
                } else {
                    loginTv.setSelected(false);
                }
            }
        });
    }

    @Override
    protected int layout() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginTv:
                if (loginTv.isSelected()) {
                    if (infoIv.isSelected()) {
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(this, "请勾选用户协议", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "请检查格式", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.infoIv:
                infoIv.setSelected(!infoIv.isSelected());
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
        }
    }
}
