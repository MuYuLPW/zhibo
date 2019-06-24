package com.muyu.zhibo.ligui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.muyu.zhibo.MyApp;
import com.muyu.zhibo.R;
import com.muyu.zhibo.adapter.ViewPagerAdapter;
import com.muyu.zhibo.fragment.BaseFragment;
import com.muyu.zhibo.fragment.FasterFargment;
import com.muyu.zhibo.fragment.JinPingFragment;
import com.muyu.zhibo.fragment.ShiPinFragment;
import com.muyu.zhibo.fragment.TuPianFragment;
import com.muyu.zhibo.fragment.TuiJianFragment;
import com.muyu.zhibo.utils.JSUtils;

import java.util.ArrayList;
import java.util.List;

public class MajorActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    private android.widget.LinearLayout mainView;
    private android.support.design.widget.NavigationView menuView;
    private android.support.v4.widget.DrawerLayout drawerLayout;
    private MyDrawerListener drawerListener;
    private ViewPager homeViewPager;
    private List<BaseFragment> list=new ArrayList<>();
    private BottomNavigationView bottom_navigate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (TextUtils.isEmpty(MyApp.myApp.tokenId)){
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_major);
        initView();
        initListener();
    }

    private void initListener() {
        drawerListener = new MyDrawerListener();
        drawerLayout.addDrawerListener(drawerListener);
        bottom_navigate.setOnNavigationItemSelectedListener(this);
        homeViewPager.addOnPageChangeListener(this);
    }

    private void initView() {
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        this.menuView = (NavigationView) findViewById(R.id.menuView);
        this.mainView = (LinearLayout) findViewById(R.id.mainView);
        bottom_navigate = findViewById(R.id.bottom_navigate);
        homeViewPager = findViewById(R.id.homeViewPager);
        list.add(new TuiJianFragment());
        list.add(new TuPianFragment());
        list.add(new ShiPinFragment());
        list.add(new JinPingFragment());
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager(),list);
        homeViewPager.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        drawerLayout.removeDrawerListener(drawerListener);
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

    class MyDrawerListener implements DrawerLayout.DrawerListener{

        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
            //drawerView 为菜单view
            //可以重新侧滑方法,该方法实现侧滑动画,整个布局移动效果
            //获取mDrawerLayout中的第一个子布局，也就是布局中的RelativeLayout
            //获取抽屉的view
            View mContent = ((ViewGroup)drawerView.getParent()).getChildAt(0);
            float scale = 1 - slideOffset;
            float endScale = 0.8f + scale * 0.2f;
            float startScale = 1 - 0.3f * scale;

            //设置左边菜单滑动后的占据屏幕大小
            drawerView.setScaleX(startScale);
            drawerView.setScaleY(startScale);
            //设置菜单透明度
            drawerView.setAlpha(0.6f + 0.4f * (1 - scale));

            //设置内容界面水平和垂直方向偏转量
            //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
            mContent.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));
            //设置内容界面操作无效（比如有button就会点击无效）
            mContent.invalidate();
            //设置右边菜单滑动后的占据屏幕大小
            mContent.setScaleX(endScale);
            mContent.setScaleY(endScale);
        }

        @Override
        public void onDrawerOpened(@NonNull View view) {

        }

        @Override
        public void onDrawerClosed(@NonNull View view) {

        }

        @Override
        public void onDrawerStateChanged(int i) {

        }
    }
}
