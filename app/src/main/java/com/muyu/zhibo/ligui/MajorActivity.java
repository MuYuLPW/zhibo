package com.muyu.zhibo.ligui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.muyu.zhibo.MyApp;
import com.muyu.zhibo.R;
import com.muyu.zhibo.adapter.ViewPagerAdapter;
import com.muyu.zhibo.fragment.BaseFragment;
import com.muyu.zhibo.fragment.FasterFargment;
import com.muyu.zhibo.fragment.HomeFragment;
import com.muyu.zhibo.fragment.JinPingFragment;
import com.muyu.zhibo.fragment.ModelFragment;
import com.muyu.zhibo.fragment.SearchFragment;
import com.muyu.zhibo.fragment.ShiPinFragment;
import com.muyu.zhibo.fragment.TuPianFragment;
import com.muyu.zhibo.fragment.TuiJianFragment;
import com.muyu.zhibo.utils.JSUtils;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.Jzvd;

public class MajorActivity extends AppCompatActivity{

    private android.support.design.widget.NavigationView menuView;
    private android.support.v4.widget.DrawerLayout drawerLayout;
    private MyDrawerListener drawerListener;
    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private ModelFragment modelFragment;


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
        menuView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setCheckable(true);//设置选项可选
                menuItem.setChecked(true);//设置选型被选中
                switch (menuItem.getItemId()){
                    case R.id.left_home:
                        if (homeFragment==null){
                            homeFragment=new HomeFragment();
                        }
                        addFragment(homeFragment,"home");
                        break;
                    case R.id.left_search:
                        if (searchFragment==null){
                            searchFragment=new SearchFragment();
                        }
                        addFragment(searchFragment,"search");
                        break;
                    case R.id.left_model:
                        if (modelFragment==null){
                            modelFragment=new ModelFragment();
                        }
                        addFragment(modelFragment,"search");
                        break;
                }
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            }
        });

    }

    private void initView() {
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        this.menuView = (NavigationView) findViewById(R.id.menuView);
        menuView.setCheckedItem(R.id.left_home);
        if (homeFragment==null){
            homeFragment=new HomeFragment();
        }
        addFragment(homeFragment,"home");
    }

    private void addFragment(BaseFragment fragment,String name){
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragment,fragment,name).commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        drawerLayout.removeDrawerListener(drawerListener);
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
