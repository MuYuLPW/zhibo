package com.muyu.zhibo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muyu.zhibo.R;

public class SearchFragment extends BaseFragment {
    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.fragment_search, null);
        return inflate;
    }
}
