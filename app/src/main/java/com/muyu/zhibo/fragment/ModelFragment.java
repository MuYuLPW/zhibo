package com.muyu.zhibo.fragment;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.muyu.zhibo.R;
import com.muyu.zhibo.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ModelFragment extends BaseFragment implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager viewPager;
    private RadioButton rb_redu;
    private RadioButton rb_xinren;
    private List<BaseFragment> list=new ArrayList<>();

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.fragment_model, null);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        viewPager = inflate.findViewById(R.id.model_viewpager);
        rb_redu = inflate.findViewById(R.id.rb_redu);
        rb_xinren = inflate.findViewById(R.id.rb_xinren);
    }

    @Override
    public void initAdapter() {
        list.add(new ReDuModelFragment());
        list.add(new XinRenModelFragment());
        ViewPagerAdapter adapter=new ViewPagerAdapter(getFragmentManager(),list);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        viewPager.addOnPageChangeListener(this);
        rb_redu.setOnClickListener(this);
        rb_xinren.setOnClickListener(this);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        if (i==0){
            rb_redu.setChecked(true);
        }else {
            rb_xinren.setChecked(true);
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rb_redu:
                viewPager.setCurrentItem(0);
                break;
            case R.id.rb_xinren:
                viewPager.setCurrentItem(1);
                break;
        }
    }
}
