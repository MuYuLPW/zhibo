package com.muyu.zhibo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.muyu.zhibo.adapter.PingTaiAdapter;
import com.muyu.zhibo.bean.listBean;
import com.muyu.zhibo.utils.HttpServices;
import com.muyu.zhibo.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnItemClickListener {

    private android.support.v7.widget.RecyclerView recycler;
    private android.support.v4.widget.SwipeRefreshLayout swit;
    private List<listBean.PingtaiBean> list=new ArrayList<>();
    private PingTaiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.swit = (SwipeRefreshLayout) findViewById(R.id.swit);
        this.recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new GridLayoutManager(this,3));
        adapter = new PingTaiAdapter(R.layout.item_pingtai,list,this);
        recycler.setAdapter(adapter);
        swit.setRefreshing(true);
        initData();
        initListener();
    }

    private void initListener() {
        swit.setOnRefreshListener(this);
        adapter.setOnItemClickListener(this);
    }

    private void initData() {
        getList();
    }

    private void getList() {
        HttpServices httpServices = MyApp.myApp.retrofit.create(HttpServices.class);
        Call<listBean> call = httpServices.getPingTaiList(MyUtils.PINGTAI_LIST_URL);
        call.enqueue(new Callback<listBean>() {
            @Override
            public void onResponse(Call<listBean> call, Response<listBean> response) {
                swit.setRefreshing(false);
                if (response.code()==200){
                    listBean body = response.body();
                    List<listBean.PingtaiBean> pingtai = body.getPingtai();
                    list.addAll(pingtai);
                    adapter.notifyDataSetChanged();
                }else {
                    onFailure(call,new Throwable("请求错误"));
                }
            }

            @Override
            public void onFailure(Call<listBean> call, Throwable t) {
                swit.setRefreshing(false);
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onRefresh() {
        list.clear();
        getList();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        listBean.PingtaiBean pingtaiBean = list.get(position);
        Intent intent=new Intent(this,ListActivity.class);
        intent.putExtra("address",pingtaiBean.getAddress());
        intent.putExtra("title",pingtaiBean.getTitle());
        startActivity(intent);
    }
}
