package com.muyu.zhibo.view;

import android.content.Context;
import android.support.annotation.NonNull;

import com.lxj.xpopup.core.BottomPopupView;
import com.muyu.zhibo.R;

/**
 * 模特详情
 */
public class ModelDetailsView extends BottomPopupView {
    private String id;
    private Context context;
    public ModelDetailsView(@NonNull Context context,String id) {
        super(context);
        this.id=id;
        this.context=context;
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.model_details_view;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
    }
}
