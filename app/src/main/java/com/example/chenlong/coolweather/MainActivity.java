package com.example.chenlong.coolweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.example.chenlong.coolweather.http.api.CityApi;
import com.example.chenlong.coolweather.util.HttpUtil;
import com.example.chenlong.coolweather.widget.CurveTempView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CurveTempView ctv = (CurveTempView) findViewById(R.id.ctv);
        int[] temp = new int[]{5, 3, 4, -6, 2, 9, 3, 5, 2, 8, 7};
        String[] tempText = "01:00,02:00,03:00,04:00,05:00,06:00,07:00,08:00,09:00,10:00,11:00".split(",");
        ctv.setTemp(temp);
        ctv.setTempText(tempText);
        ctv.invalidate();

        Button home = (Button) findViewById(R.id.btn_home);
        home.setOnClickListener(v -> luancherWeacher());

        doRxJavaDemo();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://guolin.tech/api/")
                .addConverterFactory(ScalarsConverterFactory.create())  //返回字符串
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        CityApi cityApi = retrofit.create(CityApi.class);

        cityApi.getPic()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(System.out::println);
    }


    private void luancherWeacher()
    {
        String request = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(request, new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                String s = response.body().string();
                Log.d("MainActivity", s);
                finishTask(s);
            }
        });
    }

    private void finishTask(String s)
    {
        Intent intent = new Intent(this, WeatherActivity.class);
        intent.putExtra("pic", s);
        startActivity(intent);
        finish();
    }

    private void doRxJavaDemo()
    {
        /**
         * 创建一个Observable的初级写法
         */
        Observable<String> obs = Observable.create(new Observable.OnSubscribe<String>()
        {
            @Override
            public void call(Subscriber<? super String> subscriber)
            {
                subscriber.onNext("hello world");
            }
        });

        /**
         * 创建一个Subscriber的初级写法
         */
        Subscriber<String> sub = new Subscriber<String>()
        {
            @Override
            public void onCompleted()
            {

            }

            @Override
            public void onError(Throwable e)
            {

            }

            @Override
            public void onNext(String s)
            {

            }
        };

        /**
         * 关联发射者和订阅者
         */
        obs.subscribe(sub);

        /**
         * 以上是low写法 下面是真正的RXJava写法 一行响应式函数代码实现
         */
        Observable.just("hello world")
                .subscribe(s -> System.out.println(s));

        /**
         * map 操作符 实现中途转换 改变数据 最后接收的结果为Hello World by ChenLong
         */
        Observable.just("Hello World!")
                .map(s -> s + "by ChenLong")
                .subscribe(s -> System.out.println(s));
    }
}
