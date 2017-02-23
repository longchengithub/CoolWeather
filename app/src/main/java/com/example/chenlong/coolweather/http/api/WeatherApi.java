package com.example.chenlong.coolweather.http.api;

import com.example.chenlong.coolweather.bean.WeatherBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ChenLong on 2017/1/30.
 */

public interface WeatherApi
{
    String baseUrl = "http://guolin.tech/api/";

    //CN101200101 77203a27e4ec48ff8fc441de8f45859a
    @GET("weather")
    Observable<WeatherBean> getWeatherInfo(@Query("cityid")String cityid,@Query("key")String key);
}
