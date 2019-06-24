package com.muyu.zhibo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.muyu.zhibo.utils.JZMediaIjk;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class PlayActivity extends AppCompatActivity {


    private JzvdStd jzvdStd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        String url = getIntent().getStringExtra("url");
        String imgUrl=getIntent().getStringExtra("img");
        Log.e("tag",url);
        jzvdStd = (JzvdStd) findViewById(R.id.videoplayer);
        jzvdStd.setUp(url, "", Jzvd.SCREEN_NORMAL, JZMediaIjk.class);
        Glide.with(this).load(imgUrl).into(jzvdStd.thumbImageView);
        jzvdStd.fullscreenButton.setVisibility(View.GONE);
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
