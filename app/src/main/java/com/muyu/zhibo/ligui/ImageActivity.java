package com.muyu.zhibo.ligui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.interfaces.OnSrcViewUpdateListener;
import com.lxj.xpopup.interfaces.XPopupImageLoader;
import com.muyu.zhibo.MyApp;
import com.muyu.zhibo.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageActivity extends AppCompatActivity implements BaseQuickAdapter.OnItemClickListener {

    private android.support.v7.widget.RecyclerView recycler;
    private List<Object> list;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        this.recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new GridLayoutManager(this,3));
        initData();
        initListener();
    }

    private void initListener() {
        adapter.setOnItemClickListener(this);
    }

    private void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String url = intent.getStringExtra("url");
        getSupportActionBar().setTitle(title);
        String[] split = url.split(",");
        for (int i = 0; i < split.length; i++) {
            split[i]=split[i]+MyApp.myApp.fileId;
        }
        list = Arrays.asList(split);
        adapter = new ImageAdapter(R.layout.item_image,list,this);
        recycler.setAdapter(adapter);

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        ImageView iv=  view.findViewById(R.id.img);
        new XPopup.Builder(this)
                .asImageViewer(iv, position, list, true, -1, -1, -1, false, new OnSrcViewUpdateListener() {
                    @Override
                    public void onSrcViewUpdate(final ImageViewerPopupView popupView, final int position) {
                        //1.pager更新当前显示的图片
//                        pager.setCurrentItem(position, false);
//                        //2.更新弹窗的srcView，注意这里的position是list中的position，上面ViewPager设置了pageLimit数量，
//                        //保证能拿到child，如果不设置pageLimit，ViewPager默认最多维护3个page，会导致拿不到child
//                        popupView.updateSrcView((ImageView) pager.getChildAt(position));
                    }
                }, new ImageLoader())
                .show();
    }

    class ImageAdapter extends BaseQuickAdapter<Object,BaseViewHolder>{
        Context context;
        public ImageAdapter(int layoutResId, @Nullable List<Object> data,Context context) {
            super(layoutResId, data);
            this.context=context;
        }

        @Override
        protected void convert(BaseViewHolder helper, Object item) {
            ImageView view = helper.getView(R.id.img);
            Glide.with(context).load(item).into(view);
        }
    }

    public static class ImageLoader implements XPopupImageLoader {
        @Override
        public void loadImage(int position, @NonNull Object url, @NonNull ImageView imageView) {
            //必须指定Target.SIZE_ORIGINAL，否则无法拿到原图，就无法享用天衣无缝的动画
            Glide.with(imageView).load(url).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher_round)).into(imageView);
        }

        @Override
        public File getImageFile(@NonNull Context context, @NonNull Object uri) {
            try {
                return Glide.with(context).downloadOnly().load(uri).submit().get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
