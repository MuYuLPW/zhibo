package com.muyu.zhibo;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.muyu.zhibo.adapter.ZhuBoAdapter;
import com.muyu.zhibo.bean.ZhuBoBean;
import com.muyu.zhibo.bean.listBean;
import com.muyu.zhibo.utils.HttpServices;
import com.muyu.zhibo.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnItemClickListener {

    private SwipeRefreshLayout swip;
    private RecyclerView recyclerView;
    private String address;
    private List<ZhuBoBean.ZhuboBean> list = new ArrayList<>();
    private ZhuBoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        swip = findViewById(R.id.swip);
        recyclerView = findViewById(R.id.recycler);
        swip.setRefreshing(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        Intent intent = getIntent();
        address = intent.getStringExtra("address");
        String title = intent.getStringExtra("title");
        getSupportActionBar().setTitle(title);
        adapter = new ZhuBoAdapter(R.layout.item_list, list, this);
        recyclerView.setAdapter(adapter);
        initData();
        initListener();

    }

    private void initListener() {
        swip.setOnRefreshListener(this);
        adapter.setOnItemClickListener(this);
    }

    private void initData() {
        getList();
    }

    private void getList() {
        HttpServices httpServices = MyApp.myApp.retrofit.create(HttpServices.class);
        Call<ZhuBoBean> call = httpServices.getZhubolist(MyUtils.BASE_URL + address);
        call.enqueue(new Callback<ZhuBoBean>() {
            @Override
            public void onResponse(Call<ZhuBoBean> call, Response<ZhuBoBean> response) {
                swip.setRefreshing(false);
                if (response.code()==200){
                    ZhuBoBean body = response.body();
                    List<ZhuBoBean.ZhuboBean> zhubo = body.getZhubo();
                    list.addAll(zhubo);
                    adapter.notifyDataSetChanged();
                }else {
                    onFailure(call,new Throwable("网络出错"));
                }
            }

            @Override
            public void onFailure(Call<ZhuBoBean> call, Throwable t) {
                swip.setRefreshing(false);
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
        ZhuBoBean.ZhuboBean zhuboBean = list.get(position);
        Intent intent=new Intent(this,PlayActivity.class);
        intent.putExtra("url",zhuboBean.getAddress());
        intent.putExtra("img",zhuboBean.getImg());
        startActivity(intent);
    }
}
