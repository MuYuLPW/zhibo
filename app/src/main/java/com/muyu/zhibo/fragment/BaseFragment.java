package com.muyu.zhibo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    private View rootView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView==null){
            rootView=initView(inflater,container);
            initAdapter();
            initListener();
        }
        return rootView;
    }

    public void initListener() {

    }

    public void initAdapter() {

    }

    public abstract View initView(LayoutInflater inflater, ViewGroup container);
}
