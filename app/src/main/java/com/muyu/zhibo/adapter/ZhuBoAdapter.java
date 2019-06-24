package com.muyu.zhibo.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.muyu.zhibo.R;
import com.muyu.zhibo.bean.ZhuBoBean;

import java.util.List;

public class ZhuBoAdapter extends BaseQuickAdapter<ZhuBoBean.ZhuboBean,BaseViewHolder> {
    Context context;
    public ZhuBoAdapter(int layoutResId, @Nullable List<ZhuBoBean.ZhuboBean> data, Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhuBoBean.ZhuboBean item) {
        helper.setText(R.id.title,item.getTitle());
        ImageView view = helper.getView(R.id.img);
        Glide.with(context).load(item.getImg()).into(view);
    }
}
