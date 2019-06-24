package com.muyu.zhibo.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.muyu.zhibo.R;
import com.muyu.zhibo.bean.listBean;

import java.util.List;

public class PingTaiAdapter extends BaseQuickAdapter<listBean.PingtaiBean,BaseViewHolder> {
    Context context;
    public PingTaiAdapter(int layoutResId, @Nullable List<listBean.PingtaiBean> data, Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, listBean.PingtaiBean item) {
        helper.setText(R.id.title,item.getTitle());
        helper.setText(R.id.number,item.getNumber());
        ImageView img = helper.getView(R.id.img);
        Glide.with(context).load(item.getXinimg()).into(img);
    }
}
