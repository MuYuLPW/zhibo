package com.muyu.zhibo;

import android.app.Application;
import android.util.Log;

import com.muyu.zhibo.utils.MyUtils;
import com.muyu.zhibo.utils.SharedPreferencesHelper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MyApp extends Application {
    public static MyApp myApp;
    public Retrofit retrofit;
    public String tokenId;
    public String fileId;
    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;
        tokenId= SharedPreferencesHelper.getInstance(this).getString(MyUtils.TOKENID);
        Log.e("tag",tokenId);
        fileId=MyUtils.getFileId(this);
        OkHttpClient client=new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://web.ligui.com/web/")
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
