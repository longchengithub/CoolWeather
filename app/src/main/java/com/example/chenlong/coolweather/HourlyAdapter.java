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

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder>
{
    List<WeatherBean.HeWeatherBean.HourlyForecastBean> hourly_forecast;

    public HourlyAdapter(List<WeatherBean.HeWeatherBean.HourlyForecastBean> hourly_forecast)
    {
        this.hourly_forecast = hourly_forecast;
    }

    @Override
    public HourlyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, parent, false);
        return new HourlyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(HourlyViewHolder holder, int position)
    {
        WeatherBean.HeWeatherBean.HourlyForecastBean bean = hourly_forecast.get(position);
        holder.mDate.setText(bean.getDate().split(" ")[1]);
        holder.mInfo.setText(bean.getCond().getTxt());
        holder.mWind.setText(bean.getWind().getDir());
        holder.mTemp.setText(bean.getTmp() + "℃");
    }

    @Override
    public int getItemCount()
    {
        return hourly_forecast == null ? 0 : hourly_forecast.size();
    }

    static class HourlyViewHolder extends RecyclerView.ViewHolder
    {
        TextView mDate;
        TextView mInfo;
        TextView mWind;
        TextView mTemp;

        public HourlyViewHolder(View itemView)
        {
            super(itemView);
            mDate = (TextView) itemView.findViewById(R.id.date_text);
            mInfo = (TextView) itemView.findViewById(R.id.info_text);
            mWind = (TextView) itemView.findViewById(R.id.max_text);
            mTemp = (TextView) itemView.findViewById(R.id.min_text);
        }
    }
}
