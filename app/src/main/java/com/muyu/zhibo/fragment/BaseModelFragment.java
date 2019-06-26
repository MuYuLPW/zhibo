package com.muyu.zhibo.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lxj.xpopup.XPopup;
import com.muyu.zhibo.MyApp;
import com.muyu.zhibo.R;
import com.muyu.zhibo.adapter.ModelAdapter;
import com.muyu.zhibo.bean.liguiBean.ModelBean;
import com.muyu.zhibo.utils.HttpServices;
import com.muyu.zhibo.utils.MyCall;
import com.muyu.zhibo.view.ModelDetailsView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseModelFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    private SwipeRefreshLayout swip;
    private RecyclerView recyclerView;
    private List<ModelBean.DataBean> list=new ArrayList<>();
    private ModelAdapter adapter;
    private String cursor="0";
    private String size="20";
    protected String type="0";

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.base_fragment_model, null);
        swip = view.findViewById(R.id.swip);
        swip.setRefreshing(true);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        setType();
        initData();
        return view;
    }
    public abstract void setType();

    @Override
    public void initListener() {
        swip.setOnRefreshListener(this);
        adapter.setOnLoadMoreListener(this,recyclerView);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ModelBean.DataBean dataBean = list.get(position);
                new XPopup.Builder(getContext())
                        .moveUpToKeyboard(false) //如果不加这个，评论弹窗会移动到软键盘上面
                        .asCustom(new ModelDetailsView(getContext(),dataBean.getId()+""))
                        .show();
            }
        });
    }

    private void initData() {
        HttpServices httpServices = MyApp.myApp.retrofit.create(HttpServices.class);
        Map<String,String> map=new HashMap<>();
        map.put("cursor",cursor);
        map.put("size",size);
        map.put("type",type);
        map.put("token",MyApp.myApp.tokenId);
        Call<ModelBean> modelList = httpServices.getModelList(map);
        modelList.enqueue(new MyCall<ModelBean>() {
            @Override
            public void getResult(Call<ModelBean> call, Response<ModelBean> response) {
                swip.setRefreshing(false);
                swip.setEnabled(true);
                ModelBean body = response.body();
                List<ModelBean.DataBean> data = body.getData();
                list.addAll(data);
                if (body.isHasnext()){
                    adapter.loadMoreComplete();
                    cursor = body.getNextCursor();
                }else {
                    adapter.loadMoreEnd();
                }
            }

            @Override
            public void onFailure(Call<ModelBean> call, Throwable t) {
                super.onFailure(call, t);
                swip.setRefreshing(false);
                swip.setEnabled(true);
            }
        });
    }

    @Override
    public void initAdapter() {
        adapter = new ModelAdapter(R.layout.item_list,list,getContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        swip.setRefreshing(true);
        cursor="0";
        list.clear();
        initData();
    }

    @Override
    public void onLoadMoreRequested() {
        swip.setEnabled(false);
        initData();
    }
}
