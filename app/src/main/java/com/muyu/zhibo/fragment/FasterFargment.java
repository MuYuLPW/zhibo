package com.muyu.zhibo.fragment;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lxj.xpopup.impl.LoadingPopupView;
import com.muyu.zhibo.MyApp;
import com.muyu.zhibo.PlayActivity;
import com.muyu.zhibo.R;
import com.muyu.zhibo.adapter.PicAndHdvAdapter;
import com.muyu.zhibo.adapter.Tab_Adapter;
import com.muyu.zhibo.bean.liguiBean.DataBean;
import com.muyu.zhibo.bean.liguiBean.ListBean;
import com.muyu.zhibo.bean.liguiBean.TabBean;
import com.muyu.zhibo.ligui.ImageActivity;
import com.muyu.zhibo.ligui.LiGuiPlayActivity;
import com.muyu.zhibo.utils.HttpServices;
import com.muyu.zhibo.utils.MyCall;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public abstract class FasterFargment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    private RecyclerView recycler;
    private RecyclerView tab_recycler;
    private List<TabBean.DataBean> tabList=new ArrayList<>();
    protected List<DataBean> picAndHdvList=new ArrayList<>();
    private Tab_Adapter tab_adapter;
    protected SwipeRefreshLayout swip;
    protected boolean hasTab=true;
    protected String type="1";
    protected String size="20";//每页请求的数据
    protected String cursor="0";//请求的游标
    protected String lid="";//请求的label
    protected PicAndHdvAdapter picAndHdvAdapter;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.faster_fragment, null);
        setType();//设置种类
        setHasTab();
        swip = inflate.findViewById(R.id.swip);
        swip.setRefreshing(true);
        recycler = inflate.findViewById(R.id.recycler);
        tab_recycler = inflate.findViewById(R.id.tab_recycler);
        recycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        tab_recycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        initData();
        return inflate;
    }

    public abstract void setHasTab();
    public abstract void setType();

    private void initData() {
        if (hasTab){
            getTabList();
            tab_recycler.setVisibility(View.VISIBLE);
        }
        getList();
    }

    @Override
    public void initListener() {
        picAndHdvAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                DataBean dataBean = picAndHdvList.get(position);
                if (dataBean.getType()==1){
                    Intent intent=new Intent(getContext(), LiGuiPlayActivity.class);
                    intent.putExtra("title",dataBean.getName());
                    intent.putExtra("url",dataBean.getUrl()+MyApp.myApp.fileId);
                    intent.putExtra("img",dataBean.getCover()+MyApp.myApp.fileId);
                    startActivity(intent);
                    //todo 华为问题
//                    Uri uri=Uri.parse(dataBean.getUrl()+MyApp.myApp.fileId);
//                    Intent intent=new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
                }else {
                    Intent intent=new Intent(getContext(), ImageActivity.class);
                    intent.putExtra("title",dataBean.getName());
                    intent.putExtra("url",dataBean.getUrl());
                    startActivity(intent);
                }
            }
        });
        swip.setOnRefreshListener(this);
        picAndHdvAdapter.setOnLoadMoreListener(this,recycler);
        tab_adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                for (int i = 0; i < tabList.size(); i++) {
                    tabList.get(i).setChecked(false);
                }
                TabBean.DataBean dataBean = tabList.get(position);
                dataBean.setChecked(true);
                lid=dataBean.getId();
                cursor="0";
                recycler.scrollToPosition(0);
                picAndHdvList.clear();
                swip.setRefreshing(true);
                tab_adapter.notifyDataSetChanged();
                getList();
            }
        });
    }

    @Override
    public void initAdapter() {
        tab_adapter = new Tab_Adapter(R.layout.item_tab,tabList,getContext());
        tab_recycler.setAdapter(tab_adapter);
        picAndHdvAdapter = new PicAndHdvAdapter(R.layout.item_pichdv,picAndHdvList,getContext());
        recycler.setAdapter(picAndHdvAdapter);
    }

    private void getTabList() {
        tabList.clear();
        HttpServices httpServices = MyApp.myApp.retrofit.create(HttpServices.class);
        Call<TabBean> labelList = httpServices.getLabelList(MyApp.myApp.tokenId);
        labelList.enqueue(new MyCall<TabBean>() {
            @Override
            public void getResult(Call<TabBean> call, Response<TabBean> response) {
                TabBean body = response.body();
                tabList.addAll(body.getData());
                TabBean.DataBean bean = new TabBean.DataBean();
                bean.setChecked(true);
                bean.setName("全部");
                tabList.add(0,bean);
                tab_adapter.notifyDataSetChanged();
            }
        });
    }
    public abstract void getList();

    @Override
    public void onRefresh() {
        cursor="0";
        swip.setRefreshing(true);
        picAndHdvList.clear();
        getList();
    }

    @Override
    public void onLoadMoreRequested() {
        swip.setEnabled(false);
        getList();
    }
}
