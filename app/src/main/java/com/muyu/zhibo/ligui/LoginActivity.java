package com.muyu.zhibo.ligui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.enums.PopupAnimation;
import com.lxj.xpopup.impl.LoadingPopupView;
import com.muyu.zhibo.MyApp;
import com.muyu.zhibo.R;
import com.muyu.zhibo.bean.liguiBean.LoginBean;
import com.muyu.zhibo.utils.HttpServices;
import com.muyu.zhibo.utils.JSUtils;
import com.muyu.zhibo.utils.MyCall;
import com.muyu.zhibo.utils.MyUtils;
import com.muyu.zhibo.utils.SharedPreferencesHelper;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.EditText phone;
    private android.widget.EditText pass;
    private android.widget.Button login;
    private LoadingPopupView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.login = (Button) findViewById(R.id.login);
        this.pass = (EditText) findViewById(R.id.pass);
        this.phone = (EditText) findViewById(R.id.phone);
        getSupportActionBar().setTitle("登录账号");

        initListener();
        loading = new XPopup.Builder(this)
                .dismissOnBackPressed(false)
                .dismissOnTouchOutside(false)
                .popupAnimation(PopupAnimation.ScaleAlphaFromCenter)
                .asLoading("正在加载中");
    }

    private void initListener() {
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.login){
            logIn();
        }
    }

    private void logIn() {
        loading.show();
        String phongNum = phone.getText().toString();
        String passNum = pass.getText().toString();
        String md5Pass = JSUtils.getMd5Pass(passNum, this);
        HttpServices httpServices = MyApp.myApp.retrofit.create(HttpServices.class);
        Map<String,String> map=new HashMap<>();
        map.put("phone",phongNum);
        map.put("password",md5Pass);
        map.put("userType","0");
        Call<LoginBean> call = httpServices.login(map);
        call.enqueue(new MyCall<LoginBean>(loading) {
            @Override
            public void getResult(Call<LoginBean> call, Response<LoginBean> response) {
                LoginBean body = response.body();
                if (body.isSuccess()){
                    String token = body.getData().getToken();
                    Log.e("tag",token);
                    MyApp.myApp.tokenId=token;
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                    SharedPreferencesHelper.getInstance(LoginActivity.this).putString(MyUtils.TOKENID,token);
                    Intent intent=new Intent(LoginActivity.this,MajorActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


    }
}
