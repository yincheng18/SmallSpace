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

public class MeFragment extends Fragment implements View.OnClickListener {

    private MeViewModel meViewModel;

    private LinearLayout settingLL;

    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        meViewModel =
                ViewModelProviders.of(this).get(MeViewModel.class);
        root = inflater.inflate(R.layout.fragment_me, container, false);
        meViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        initView();
    }

    private void initView() {
        settingLL = root.findViewById(R.id.settingLL);
        settingLL.setOnClickListener(this);
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