package com.muyu.zhibo.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.muyu.zhibo.MyApp;
import com.muyu.zhibo.R;
import com.muyu.zhibo.bean.liguiBean.ModelListBean;

import java.util.List;

public class ModelLiseAdapter extends BaseQuickAdapter<ModelListBean.DataBean.ContentArrayBean,BaseViewHolder> {
    private Context context;
    public ModelLiseAdapter(int layoutResId, @Nullable List<ModelListBean.DataBean.ContentArrayBean> data ,Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ModelListBean.DataBean.ContentArrayBean item) {
        helper.setText(R.id.title,item.getName());
//        helper.setText(R.id.model_name,item.getModelName());
        helper.setVisible(R.id.model_name,false);
        helper.setText(R.id.playNum,item.getPlayCount()+"");
        ImageView play=helper.getView(R.id.play);
        TextView pics=helper.getView(R.id.picNum);
        ImageView img=helper.getView(R.id.img);
        if (item.getType()==0){//图片
            play.setVisibility(View.GONE);
            pics.setVisibility(View.VISIBLE);
            pics.setText(item.getLength()+"P");
        }else {
            play.setVisibility(View.VISIBLE);
            pics.setVisibility(View.GONE);
        }
        Glide.with(context).load(item.getCover()+ MyApp.myApp.fileId).into(img);
    }
}
