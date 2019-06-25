package com.muyu.zhibo.ligui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.muyu.zhibo.R;
import com.muyu.zhibo.utils.JZMediaIjk;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class LiGuiPlayActivity extends AppCompatActivity {
    private JzvdStd jzvdStd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_li_gui_play);
        String url = getIntent().getStringExtra("url");
        String imgUrl=getIntent().getStringExtra("img");
        String title=getIntent().getStringExtra("title");
        Log.e("tag",url);
        jzvdStd = (JzvdStd) findViewById(R.id.videoplayer);
        jzvdStd.setUp(url, title, Jzvd.SCREEN_NORMAL);
        Glide.with(this).load(imgUrl).into(jzvdStd.thumbImageView);
        jzvdStd.startVideo();
//        jzvdStd.setScreenFullscreen();
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.resetAllVideos();
    }
}
