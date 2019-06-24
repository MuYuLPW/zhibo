package com.muyu.zhibo.fragment;

import android.util.Log;
import android.widget.Toast;

import com.muyu.zhibo.MyApp;
import com.muyu.zhibo.bean.liguiBean.DataBean;
import com.muyu.zhibo.bean.liguiBean.ListBean;
import com.muyu.zhibo.utils.HttpServices;
import com.muyu.zhibo.utils.MyCall;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TuiJianFragment extends BaseTuijianAndJinpingFragment {
    @Override
    public void setHasTab() {
        hasTab=false;
    }

    @Override
    public void setType() {

    }
}
