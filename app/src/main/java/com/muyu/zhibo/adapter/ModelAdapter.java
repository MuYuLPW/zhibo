package com.muyu.zhibo.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.muyu.zhibo.MyApp;
import com.muyu.zhibo.R;
import com.muyu.zhibo.bean.liguiBean.ModelBean;

import java.util.List;

public class ModelAdapter extends BaseQuickAdapter<ModelBean.DataBean,BaseViewHolder> {
    Context context;
    public ModelAdapter(int layoutResId, @Nullable List<ModelBean.DataBean> data, Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ModelBean.DataBean item) {
        helper.setText(R.id.title,item.getName());
        ImageView view = helper.getView(R.id.img);
        Glide.with(context).load(item.getCover()+ MyApp.myApp.fileId).into(view);
    }
}
