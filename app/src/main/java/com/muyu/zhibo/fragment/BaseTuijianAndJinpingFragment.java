package com.muyu.zhibo.fragment;

import android.widget.Toast;

import com.muyu.zhibo.MyApp;
import com.muyu.zhibo.bean.liguiBean.DataBean;
import com.muyu.zhibo.bean.liguiBean.ListBean;
import com.muyu.zhibo.utils.HttpServices;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseTuijianAndJinpingFragment extends FasterFargment {
    @Override
    public void getList() {
        HttpServices httpServices = MyApp.myApp.retrofit.create(HttpServices.class);
        Map<String,String> map=new HashMap<>();
        map.put("cursor",cursor);
        map.put("size",size);
        map.put("type",type);
        map.put("token",MyApp.myApp.tokenId);
        Call<ListBean> call = httpServices.getIndexCommendOrGoodPager(map);
        call.enqueue(new Callback<ListBean>() {
            @Override
            public void onResponse(Call<ListBean> call, Response<ListBean> response) {
                swip.setRefreshing(false);
                if (response.code()!=200){
                    onFailure(call,new Throwable("网络请求出错"));
                }
                try {
                    ListBean body = response.body();
                    List<DataBean> dataBeans1 = body.getData().get(0);
                    List<DataBean> dataBeans2 = body.getData().get(1);
                    dataBeans1.addAll(dataBeans2);
                    Collections.sort(dataBeans1,Collections.reverseOrder());
                    picAndHdvList.addAll(dataBeans1);
                    picAndHdvAdapter.notifyDataSetChanged();
                }catch (Exception e){
                    onFailure(call,new Throwable("抛异常了"));
                }
            }

            @Override
            public void onFailure(Call<ListBean> call, Throwable t) {
                swip.setRefreshing(false);
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

}
