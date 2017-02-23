package com.example.chenlong.coolweather;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.chenlong.coolweather.bean.WeatherBean;
import com.example.chenlong.coolweather.http.RetrofitHelper;
import com.example.chenlong.coolweather.widget.CurveTempView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class WeatherActivity extends AppCompatActivity
{

    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.collapsing)
    CollapsingToolbarLayout mCollapsing;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    @BindView(R.id.recycler_temp)
    RecyclerView mTempRecycler;
    @BindView(R.id.api_text)
    TextView mApiText;
    @BindView(R.id.pm25_text)
    TextView mPm25Text;
    @BindView(R.id.comfort)
    TextView mComfort;
    @BindView(R.id.bing_image)
    ImageView mImageView;
    @BindView(R.id.swipe)
    SwipeRefreshLayout mSwipe;
    @BindView(R.id.ctv)
    CurveTempView mCtv;

    //CN101200101
    String cityid = "CN101200101";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);
        setSupportActionBar(mToolBar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_home);
        }

        String pic = getIntent().getStringExtra("pic");
        Glide.with(this).load(pic).centerCrop().into(mImageView);

        initSwipe();
        loadData();
    }

    private void initSwipe()
    {
        mSwipe.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.GRAY);
        mSwipe.setOnRefreshListener(() -> loadData());
    }

    private void loadData()
    {
        RetrofitHelper.getWeatherInfo()
                .getWeatherInfo(cityid, "77203a27e4ec48ff8fc441de8f45859a")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(weatherBean -> {
                    finishTask(weatherBean);
                    mSwipe.setRefreshing(false);
                }, throwable -> {
                    Log.d("WeatherActivity", throwable.toString());
                    Toast.makeText(this, "联网获取数据失败", Toast.LENGTH_SHORT).show();
                });
    }

    private void finishTask(WeatherBean weatherBean)
    {
        WeatherBean.HeWeatherBean heWeatherBean = weatherBean.getHeWeather().get(0);

        mCollapsing.setTitle(heWeatherBean.getBasic().getCity() + " " + heWeatherBean.getNow().getCond().getTxt() + " " + heWeatherBean.getNow().getTmp() + "℃");

        mApiText.setText(heWeatherBean.getAqi().getCity().getAqi());
        mPm25Text.setText(heWeatherBean.getAqi().getCity().getPm25());

        List<WeatherBean.HeWeatherBean.DailyForecastBean> daily_forecast = heWeatherBean.getDaily_forecast();
        ForecastAdapter adapter = new ForecastAdapter(daily_forecast);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(adapter);

        List<WeatherBean.HeWeatherBean.HourlyForecastBean> hourly_forecast = heWeatherBean.getHourly_forecast();
        HourlyAdapter hourlyAdapter = new HourlyAdapter(hourly_forecast);
        mTempRecycler.setLayoutManager(new LinearLayoutManager(this));
        mTempRecycler.setAdapter(hourlyAdapter);

        int[] temp = new int[hourly_forecast.size()];
        String[] tempText = new String[hourly_forecast.size()];
        for (int i = 0; i < hourly_forecast.size(); i++)
        {
            temp[i] = Integer.parseInt(hourly_forecast.get(i).getTmp());
            tempText[i] = hourly_forecast.get(i).getDate().split(" ")[1];
        }

        mCtv.setTemp(temp);
        mCtv.setTempText(tempText);
        mCtv.invalidate();

        WeatherBean.HeWeatherBean.SuggestionBean suggestion = heWeatherBean.getSuggestion();
        StringBuilder builder = new StringBuilder();
        builder.append(suggestion.getAir().getBrf())
                .append(":").append(suggestion.getAir().getTxt()).append("\n\n")
                .append(suggestion.getComf().getBrf())
                .append(":").append(suggestion.getComf().getTxt()).append("\n\n")
                .append(suggestion.getCw().getBrf())
                .append(":").append(suggestion.getCw().getTxt()).append("\n\n")
                .append(suggestion.getDrsg().getBrf())
                .append(":").append(suggestion.getDrsg().getTxt()).append("\n\n")
                .append(suggestion.getFlu().getBrf())
                .append(":").append(suggestion.getFlu().getTxt()).append("\n\n")
                .append(suggestion.getSport().getBrf())
                .append(":").append(suggestion.getSport().getTxt()).append("\n\n")
                .append(suggestion.getTrav().getBrf())
                .append(":").append(suggestion.getTrav().getTxt()).append("\n\n")
                .append(suggestion.getUv().getBrf())
                .append(":").append(suggestion.getUv().getTxt()).append("\n\n");
        mComfort.setText(builder.toString());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
//                Toast.makeText(this, "我点了", Toast.LENGTH_SHORT).show();
                showPopWindow();
                break;
        }
        return true;
    }

    private void showPopWindow()
    {
        TagFlowLayout mLayout;
        View view = LayoutInflater.from(WeatherActivity.this).inflate(R.layout.pop_city, null);
        mLayout = (TagFlowLayout) view.findViewById(R.id.id_flowlayout);

        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int heightPixels = getResources().getDisplayMetrics().heightPixels;

        PopupWindow pw = new PopupWindow(view, widthPixels, heightPixels / 2);
        pw.setFocusable(true);
        pw.setAnimationStyle(R.style.MyPopWindow);
//        pw.showAtLocation(WeatherActivity.this.getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
        pw.showAtLocation(getLayoutInflater().inflate(R.layout.activity_weather, null), Gravity.TOP, 0, 0);

        String[] data = "武汉,杭州,上海,深圳,北京".split(",");
        mLayout.setAdapter(new TagAdapter<String>(data)
        {
            @Override
            public View getView(FlowLayout parent, int position, String s)
            {
                TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.tv,
                        parent, false);
                tv.setText(s);
                return tv;
            }
        });

        mLayout.setOnTagClickListener((view1, position, parent) -> {
            switch (position)
            {
                case 0:
                    cityid = "CN101200101";
                    break;
                case 1:
                    cityid = "CN101210101";
                    break;
                case 2:
                    cityid = "CN101020100";
                    break;
                case 3:
                    cityid = "CN101280601";
                    break;
                case 4:
                    cityid = "CN101010100";
                    break;
            }
            loadData();
            pw.dismiss();
            return true;
        });
    }
}
