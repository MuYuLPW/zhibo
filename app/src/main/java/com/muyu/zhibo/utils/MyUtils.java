package com.muyu.zhibo.utils;

import android.content.Context;
import android.text.TextUtils;

public class MyUtils {
    public static final String TOKENID="tokenId";
    public static final String FILEID="fileId";

    public static final String BASE_URL="http://api.hclyz.com:81/mf/";
    public static final String PINGTAI_LIST_URL="http://api.hclyz.com:81/mf/json.txt";

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
