package com.graduate.SmallSpace.ui.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.graduate.SmallSpace.R;
import com.graduate.SmallSpace.base.BaseFragment;
import com.graduate.SmallSpace.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private ListView listView;

    private FloatingActionButton floatingBtn;

    @Override
    protected void initView() {
        listView = view.findViewById(R.id.listView);
        floatingBtn=view.findViewById(R.id.floatingBtn);
        floatingBtn.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        initListView();
    }

    //初始化listview
    private void initListView() {
        final List<String> list = new ArrayList();
        list.add("Android开发简单语法");
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ToastUtil.showShortToast(list.get(i));
            }
        });
    }

    @Override
    protected int layout() {
        return R.layout.fragment_home;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.floatingBtn:
                ToastUtil.showShortToast("点击了添加");
                break;
        }
    }
}