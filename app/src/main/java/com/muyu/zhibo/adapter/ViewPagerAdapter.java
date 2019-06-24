package com.muyu.zhibo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.muyu.zhibo.fragment.BaseFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<? extends BaseFragment> list;
    public ViewPagerAdapter(FragmentManager fm, List<? extends BaseFragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
