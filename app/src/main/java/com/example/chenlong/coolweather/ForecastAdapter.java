package com.example.chenlong.coolweather;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenlong.coolweather.bean.WeatherBean;

import java.util.List;

/**
 * Created by ChenLong on 2017/1/31.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>
{
    List<WeatherBean.HeWeatherBean.DailyForecastBean> daily_forecast;

    public ForecastAdapter(List<WeatherBean.HeWeatherBean.DailyForecastBean> daily_forecast)
    {
        this.daily_forecast = daily_forecast;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, parent, false);
        return new ForecastViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position)
    {
        WeatherBean.HeWeatherBean.DailyForecastBean bean = daily_forecast.get(position);
        holder.mDate.setText(bean.getDate());
        holder.mInfo.setText(bean.getCond().getTxt_d());
        holder.mWind.setText(bean.getWind().getSc());
        holder.mTemp.setText(bean.getTmp().getMin() + "℃/" + bean.getTmp().getMax() + "℃");
    }

    @Override
    public int getItemCount()
    {
        return daily_forecast == null ? 0 : daily_forecast.size();
    }

    static class ForecastViewHolder extends RecyclerView.ViewHolder
    {
        TextView mDate;
        TextView mInfo;
        TextView mWind;
        TextView mTemp;

        public ForecastViewHolder(View itemView)
        {
            super(itemView);
            mDate = (TextView) itemView.findViewById(R.id.date_text);
            mInfo = (TextView) itemView.findViewById(R.id.info_text);
            mWind = (TextView) itemView.findViewById(R.id.max_text);
            mTemp = (TextView) itemView.findViewById(R.id.min_text);
        }
    }
}
