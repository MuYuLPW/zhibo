package com.muyu.zhibo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.muyu.zhibo.R;
import com.muyu.zhibo.bean.liguiBean.TabBean;

import java.util.List;

public class Tab_Adapter extends BaseQuickAdapter<TabBean.DataBean,BaseViewHolder> {
    private Context context;
    public Tab_Adapter(int layoutResId, @Nullable List<TabBean.DataBean> data, Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, TabBean.DataBean item) {
        TextView textView=helper.getView(R.id.tv);
        textView.setText(item.getName());
        if (item.isChecked()){
            textView.setTextColor(context.getResources().getColor(R.color.colorAccent));
        }else {
            textView.setTextColor(Color.parseColor("#666666"));
        }

    }
}
