package com.weather004lifeplus.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Akbar on 4/3/2016.
 */
public class AdapterForWeatherForecast extends ArrayAdapter {

    private ArrayList<WeatherDataModel> forecastList;
    private Context context;


    public AdapterForWeatherForecast(Context context, ArrayList<WeatherDataModel> forecastList) {
        super(context, R.layout.content_custom_layout_for_forecast, forecastList);
        this.context = context;
        this.forecastList = forecastList;
    }

    static class ViewHolder {
        TextView dayNameForForecastTv;
        TextView maximumTemperatureForForecastTv;
        TextView minimumTemperatureForForecastTv;
        ImageView weatherImageForForecastIv;




    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.content_custom_layout_for_forecast,null);

            viewHolder = new ViewHolder();
            viewHolder.weatherImageForForecastIv =(ImageView)convertView.findViewById(R.id.weatherImageForForecastIv);

            viewHolder.dayNameForForecastTv = (TextView) convertView.findViewById(R.id.dayNameForForecastTv);
            viewHolder.maximumTemperatureForForecastTv = (TextView) convertView.findViewById(R.id.maximumTemperatureForForecastTv);
            viewHolder.minimumTemperatureForForecastTv = (TextView) convertView.findViewById(R.id.minimumTemperatureForForecastTv);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.dayNameForForecastTv.setText(forecastList.get(position).getForecastDayName());
        viewHolder.maximumTemperatureForForecastTv.setText(forecastList.get(position).getForecastHighTemp()+"°");
        viewHolder.minimumTemperatureForForecastTv.setText(forecastList.get(position).getForecastLowTemp() + "°");

        viewHolder.weatherImageForForecastIv.setImageResource(forecastList.get(position).getForecastCode());


        return convertView;
    }






}
