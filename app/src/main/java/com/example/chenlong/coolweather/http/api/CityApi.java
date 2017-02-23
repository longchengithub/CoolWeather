package com.example.chenlong.coolweather.http.api;

import com.example.chenlong.coolweather.bean.CityBean;
import com.example.chenlong.coolweather.bean.CountyBean;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;


/**
 * Created by ChenLong on 2017/1/30.
 */

public interface CityApi
{
    String baseUrl = "http://guolin.tech/api/";

    @GET("china")
    Observable<String> getProvince();

    @GET
    Observable<CityBean> getCity(@Url String cityId);

    @GET
    Observable<CountyBean> getCounty(@Url String countyUrl);

    @GET("bing_pic")
    Observable<String> getPic();
}
