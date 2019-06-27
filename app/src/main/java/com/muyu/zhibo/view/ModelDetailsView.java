package com.muyu.zhibo.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lxj.xpopup.core.BottomPopupView;
import com.muyu.zhibo.MyApp;
import com.muyu.zhibo.R;
import com.muyu.zhibo.adapter.ModelLiseAdapter;
import com.muyu.zhibo.bean.liguiBean.ModelListBean;
import com.muyu.zhibo.ligui.ImageActivity;
import com.muyu.zhibo.ligui.LiGuiPlayActivity;
import com.muyu.zhibo.utils.HttpServices;
import com.muyu.zhibo.utils.MyCall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * 模特详情
 */
public class ModelDetailsView extends BottomPopupView {
    private String id;
    private Context context;
    private RecyclerView recyclerView;
    private List<ModelListBean.DataBean.ContentArrayBean> list=new ArrayList<>();
    private ModelLiseAdapter adapter;
    private CircleImageView logo;
    private TextView model_name;
    private View view;

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
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.model_headerview, recyclerView, false);
        logo = view.findViewById(R.id.logo);
        model_name = view.findViewById(R.id.model_name);
        initAdapter();
        initData();
        initListener();

    }

    private void initListener() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ModelListBean.DataBean.ContentArrayBean dataBean = list.get(position);
                if (dataBean.getType()==1){
                    Intent intent=new Intent(getContext(), LiGuiPlayActivity.class);
                    intent.putExtra("title",dataBean.getName());
                    intent.putExtra("url",dataBean.getUrl()+MyApp.myApp.fileId);
                    intent.putExtra("img",dataBean.getCover()+MyApp.myApp.fileId);
                    context.startActivity(intent);
                    //todo 华为问题
//                    Uri uri=Uri.parse(dataBean.getUrl()+MyApp.myApp.fileId);
//                    Intent intent=new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
                }else {
                    Intent intent=new Intent(getContext(), ImageActivity.class);
                    intent.putExtra("title",dataBean.getName());
                    intent.putExtra("url",dataBean.getUrl());
                    context.startActivity(intent);
                }
            }
        });
    }

    private void initAdapter() {
        adapter = new ModelLiseAdapter(R.layout.item_pichdv,list,context);
        recyclerView.setAdapter(adapter);
        adapter.addHeaderView(view);
    }

    private void initData() {
        HttpServices httpServices = MyApp.myApp.retrofit.create(HttpServices.class);
        Map<String,String> map=new HashMap<>();
        map.put("id",id);
        map.put("token",MyApp.myApp.tokenId);
        Call<ModelListBean> call = httpServices.getModelDetailsInfo(map);
        call.enqueue(new MyCall<ModelListBean>() {
            @Override
            public void getResult(Call<ModelListBean> call, Response<ModelListBean> response) {
                ModelListBean body = response.body();
                Glide.with(context).load(body.getData().getCover()+MyApp.myApp.fileId).into(logo);
                model_name.setText(body.getData().getName());
                List<List<ModelListBean.DataBean.ContentArrayBean>> contentArray = body.getData().getContentArray();
                List<ModelListBean.DataBean.ContentArrayBean> list1 = contentArray.get(0);
                List<ModelListBean.DataBean.ContentArrayBean> list2 = contentArray.get(1);
                list1.addAll(list2);
                Collections.sort(list1,Collections.reverseOrder());
                list.addAll(list1);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
