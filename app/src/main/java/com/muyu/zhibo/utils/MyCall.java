package com.muyu.zhibo.utils;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.lxj.xpopup.core.BasePopupView;
import com.muyu.zhibo.MyApp;
import com.muyu.zhibo.bean.liguiBean.BaseBean;
import com.muyu.zhibo.ligui.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class MyCall<T extends BaseBean> implements Callback<T>{
    private BasePopupView popupView;
    public MyCall(BasePopupView popupView) {
        this.popupView=popupView;
    }
    public MyCall() {

    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (popupView!=null){
            popupView.dismiss();
        }
        if (response.code()!=200){
            onFailure(call,new Throwable("返回结果不是200"));
        }else {
            T body = response.body();
            if (body.isSuccess()){
                getResult(call,response);
            }
            else {
                Toast.makeText(MyApp.myApp,body.getMsg(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MyApp.myApp, LoginActivity.class);
                MyApp.myApp.startActivity(intent);
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (popupView!=null){
            popupView.dismiss();
        }
        Log.e("tag",t.getMessage());
    }

    public abstract void getResult(Call<T> call,Response<T> response);
}
