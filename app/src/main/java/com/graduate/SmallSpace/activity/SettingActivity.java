package com.graduate.SmallSpace.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.graduate.SmallSpace.R;
import com.graduate.SmallSpace.base.BaseActivity;
import com.graduate.SmallSpace.ui.login.LoginActivity;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        Button loginOutBtn=findViewById(R.id.loginOutBtn);
        loginOutBtn.setOnClickListener(this);
    }

    @Override
    protected int layout() {
        return R.layout.activity_setting;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginOutBtn:
                Intent intent=new Intent(this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
    }
}
