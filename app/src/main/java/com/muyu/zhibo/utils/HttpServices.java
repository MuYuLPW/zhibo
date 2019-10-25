package com.muyu.zhibo.utils;

import com.muyu.zhibo.bean.ZhuBoBean;
import com.muyu.zhibo.bean.liguiBean.ListBean;
import com.muyu.zhibo.bean.liguiBean.ListBean2;
import com.muyu.zhibo.bean.liguiBean.LoginBean;
import com.muyu.zhibo.bean.liguiBean.ModelBean;
import com.muyu.zhibo.bean.liguiBean.ModelListBean;
import com.muyu.zhibo.bean.liguiBean.TabBean;
import com.muyu.zhibo.bean.listBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface HttpServices  {
    @GET
    Call<listBean> getPingTaiList(@Url String url);

    @GET
    Call<ZhuBoBean> getZhubolist(@Url String url);

    @FormUrlEncoded
    @POST("web/user/login")
    Call<LoginBean> login(@FieldMap Map<String,String> map);

    /**
     * 获取table列表
     * @param token
     * @return
     */
    @FormUrlEncoded
    @POST("label/getAllLabelList")
    Call<TabBean> getLabelList(@Field("token") String token);

    /**
     * 获取推荐列表
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("content/getMostPopularPager")
    Call<ListBean> getIndexCommendOrGoodPager(@FieldMap Map<String,String> map);

    /**
     * 获取视频和图片列表
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("content/getIndexImageOrHdvPager")
    Call<ListBean2> getIndexImageOrHdvPager(@FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST("model/getModelsPager")
    Call<ModelBean> getModelList(@FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST("model/getModelDetailsInfo")
    Call<ModelListBean> getModelDetailsInfo(@FieldMap Map<String,String> map);
}
