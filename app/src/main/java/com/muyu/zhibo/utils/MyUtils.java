package com.muyu.zhibo.utils;

import android.content.Context;
import android.text.TextUtils;

public class MyUtils {
    public static final String TOKENID="tokenId";
    public static final String FILEID="fileId";
    public static final String ISBEIYONG="isBeiyong";

    public static final String BASE_URL="http://api.hclyz.com:81/mf/";
    public static final String BEIYONG_BASE_URL="http://api.vipmisss.com:81/xcdsw/";


    public static String getPingTaiUrl(String baseUrl){
        return baseUrl+"json.txt";
    }

    public static String getBaseUrl(boolean isBeiyong){
        if (isBeiyong)return BEIYONG_BASE_URL;
        return BASE_URL;
    }


    public static String getFileId(Context context){
        String fileid = SharedPreferencesHelper.getInstance(context).getString(FILEID);
        if (!TextUtils.isEmpty(fileid)){
            return fileid;
        }else {
            fileid=JSUtils.getFileKey(context);
            return fileid;
        }
    }

}
