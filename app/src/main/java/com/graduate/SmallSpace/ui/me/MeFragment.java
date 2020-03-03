package com.graduate.SmallSpace.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.graduate.SmallSpace.R;
import com.graduate.SmallSpace.activity.SettingActivity;
import com.graduate.SmallSpace.base.BaseFragment;

public class MeFragment extends BaseFragment implements View.OnClickListener {

    private LinearLayout settingLL;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected void initView() {
        settingLL = view.findViewById(R.id.settingLL);
        settingLL.setOnClickListener(this);
    }

    @Override
    protected int layout() {
        return R.layout.fragment_me;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.settingLL:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
        }
    }
}