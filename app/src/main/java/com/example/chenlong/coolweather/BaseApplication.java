package com.example.chenlong.coolweather;

import android.app.Application;
import android.content.Context;

/**
 * Created by ChenLong on 2017/1/30.
 */

public class BaseApplication extends Application
{
    private static Context mContext;

    @Override
    public void onCreate()
    {
        super.onCreate();
        mContext = this;
    }

    public static Context getMyContext()
    {
        return mContext;
    }
}
