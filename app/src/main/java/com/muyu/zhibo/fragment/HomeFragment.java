package com.muyu.zhibo.fragment;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.muyu.zhibo.R;
import com.muyu.zhibo.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment  implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {
    private ViewPager homeViewPager;
    private List<BaseFragment> list=new ArrayList<>();
    private BottomNavigationView bottom_navigate;
    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.fragment_home, null);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        bottom_navigate = inflate.findViewById(R.id.bottom_navigate);
        homeViewPager = inflate.findViewById(R.id.homeViewPager);
        list.add(new TuiJianFragment());
        list.add(new TuPianFragment());
        list.add(new ShiPinFragment());
        list.add(new JinPingFragment());
        ViewPagerAdapter adapter=new ViewPagerAdapter(getFragmentManager(),list);
        homeViewPager.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        bottom_navigate.setOnNavigationItemSelectedListener(this);
        homeViewPager.addOnPageChangeListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.tab_home:
                homeViewPager.setCurrentItem(0,false);
                return true;
            case R.id.tab_pic:
                homeViewPager.setCurrentItem(1,false);
                return true;
            case R.id.tab_hdv:
                homeViewPager.setCurrentItem(2,false);
                return true;
            case R.id.tab_star:
                homeViewPager.setCurrentItem(3,false);
                return true;
        }
        return false;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        Log.e("tag",i+"-----------------------------------");
        int id=0;
        switch (i){
            case 0:
                id=R.id.tab_home;
                break;
            case 1:
                id=R.id.tab_pic;
                break;
            case 2:
                id=R.id.tab_hdv;
                break;
            case 3:
                id=R.id.tab_star;
                break;
        }
        bottom_navigate.setSelectedItemId(id);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
