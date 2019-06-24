package com.muyu.zhibo.fragment;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.muyu.zhibo.MyApp;
import com.muyu.zhibo.bean.liguiBean.DataBean;
import com.muyu.zhibo.bean.liguiBean.ListBean;
import com.muyu.zhibo.bean.liguiBean.ListBean2;
import com.muyu.zhibo.utils.HttpServices;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BasePicAndHdvFragment extends FasterFargment {
    @Override
    public void getList() {
        HttpServices httpServices = MyApp.myApp.retrofit.create(HttpServices.class);
        Map<String,String> map=new HashMap<>();
        map.put("cursor",cursor);
        map.put("size",size);
        map.put("type",type);
        map.put("token",MyApp.myApp.tokenId);
        if (!TextUtils.isEmpty(lid)){
            map.put("lid",lid);
        }
        Call<ListBean2> call = httpServices.getIndexImageOrHdvPager(map);
        call.enqueue(new Callback<ListBean2>() {
            @Override
            public void onResponse(Call<ListBean2> call, Response<ListBean2> response) {
                swip.setRefreshing(false);
                if (response.code()!=200){
                    onFailure(call,new Throwable("网络请求出错"));
                }
                try {
                    ListBean2 body = response.body();
                    List<DataBean> data = body.getData();
                    Collections.sort(data,Collections.reverseOrder());
                    picAndHdvList.addAll(data);
                    picAndHdvAdapter.notifyDataSetChanged();
                }catch (Exception e){
                    onFailure(call,new Throwable("抛异常了"));
                }

            }

            @Override
            public void onFailure(Call<ListBean2> call, Throwable t) {
                swip.setRefreshing(false);
                Log.e("tag",t.getMessage());
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
