package com.example.chenlong.coolweather.util;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by ChenLong on 2017/1/31.
 */

public class HttpUtil
{
    public static void sendOkHttpRequest(String address, Callback callback)
    {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
