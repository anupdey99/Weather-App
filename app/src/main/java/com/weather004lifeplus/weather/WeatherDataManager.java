package com.weather004lifeplus.weather;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by Akbar on 4/2/2016.
 */
public class WeatherDataManager  extends WeatherDataModel {

    String getMethodUrl = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20%28select%20woeid%20from%20geo.places%281%29%20where%20text%3D%22dhaka%2C%20ak%22%29&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
    Context context;
    ArrayList<WeatherDataModel> forecastList;
    WeatherDataModel dataModel;
    WeatherDataModel dataModelForForecast;

    int bitForConvert=1;



    public WeatherDataManager(Context context) {
        this.context=context;
        dataModel=new WeatherDataModel();
    }


    public ArrayList<WeatherDataModel>   getForecastData() {

        forecastList= new ArrayList<WeatherDataModel>();


        final JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, getMethodUrl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    //last time
                   String lastBuildDate = response.getJSONObject("query").getJSONObject("results").getJSONObject("channel").getString("lastBuildDate");
                    String sub= lastBuildDate.substring(16);
                    dataModel.setLastBuildDate(sub);


                    //location
                    JSONObject location = response.getJSONObject("query").getJSONObject("results").getJSONObject("channel").optJSONObject("location");
                    String cityName = location.getString("city");
                    String countryName = location.getString("country");
                    String regionName = location.getString("region");
                    dataModel.setCityName(cityName);
                    dataModel.setCountryName(countryName);
                    dataModel.setRegionName(regionName);


                    // wind
                    JSONObject wind = response.getJSONObject("query").getJSONObject("results").getJSONObject("channel").optJSONObject("wind");
                    int windChill = wind.getInt("chill");
                    int windDirection = wind.getInt("direction");
                    int windSpeed = wind.getInt("speed");
                    dataModel.setWindChill(windChill);
                    dataModel.setWindDirection(windDirection);
                    dataModel.setWindSpeed(windSpeed);



                    //atmosphere
                    JSONObject atmosphere = response.getJSONObject("query").getJSONObject("results").getJSONObject("channel").optJSONObject("atmosphere");
                    int atmosphereHumidity = atmosphere.getInt("humidity");
                    int atmospherePressure= atmosphere.getInt("pressure");
                    int atmosphereRising= atmosphere.getInt("rising");
                    int atmosphereVisibility= atmosphere.getInt("visibility");
                    dataModel.setAtmosphereHumidity(atmosphereHumidity);
                    dataModel.setAtmospherePressure(atmospherePressure);
                    dataModel.setAtmosphereRising(atmosphereRising);
                    dataModel.setAtmosphereVisibility(atmosphereVisibility);



                    //astronomy
                    JSONObject astronomy = response.getJSONObject("query").getJSONObject("results").getJSONObject("channel").optJSONObject("astronomy");
                    String astronomySunrise = astronomy.getString("sunrise");
                    String astronomySunset = astronomy.getString("sunset");
                    dataModel.setAstronomySunrise(astronomySunrise);
                    dataModel.setAstronomySunset(astronomySunset);






                    //forecast
                    JSONArray array = response.getJSONObject("query").getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast");
                    for (int i=0;i<7;i++){                            // for full forecast use - array.length() or 10
                        JSONObject object=array.getJSONObject(i) ;
                        String dayName = object.getString("day");
                        int maxTemp=object.getInt("high");
                        int minTemp = object.getInt("low");
                        String imageIcon = object.getString("text");

                        int forecastCode;

                        if (bitForConvert==1){
                            maxTemp = 5*(maxTemp-32)/9;
                            minTemp = 5*(minTemp -32)/9;
                        }

                        if (imageIcon.equals("Cloudy")){
                            forecastCode=R.drawable.weather_cloudy;
                        }else  if (imageIcon.equals("Partly Cloudy")){
                            forecastCode=R.drawable.weather_partly_cloudy;
                        }else  if (imageIcon.equals("Mostly Cloudy")){
                            forecastCode=R.drawable.weather_mostly_cloudy;
                        }else  if (imageIcon.equals("Sunny")){
                            forecastCode=R.drawable.weather_sunny;
                        }else  if (imageIcon.equals("Mostly Sunny")){
                            forecastCode=R.drawable.weather_mostly_sunny;
                        }else  if (imageIcon.equals("Rain And Snow")){
                            forecastCode=R.drawable.weather_rain_snow;
                        }else  if (imageIcon.equals("Snow Showers")){
                            forecastCode=R.drawable.weather_snow_showers;
                        } else  if (imageIcon.equals("Thunderstorms")){
                            forecastCode=R.drawable.weather_thunderstorms;
                        } else {
                            forecastCode=R.drawable.weather_cloudy;
                        }

                        if (i==0){
                            int todayCode=forecastCode;
                            dataModel.setConditionCode(todayCode);
                        }

                        dataModelForForecast = new WeatherDataModel(dayName,maxTemp,minTemp,forecastCode);
                        forecastList.add(dataModelForForecast);
                    }



                    //condition (today)
                    JSONObject condition = response.getJSONObject("query").getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONObject("condition");
                    int conditionCode = condition.getInt("code");
                    int conditionTemp = condition.getInt("temp");
                    String conditionText = condition.getString("text");

                    JSONObject object=array.getJSONObject(0) ;
                    int conditionMaxTemp=object.getInt("high");
                    int conditionMinTemp=object.getInt("low");

                    if (bitForConvert==1){
                        conditionTemp = 5*(conditionTemp-32)/9;
                        conditionMaxTemp = 5*(conditionMaxTemp-32)/9;
                        conditionMinTemp = 5*(conditionMinTemp-32)/9;
                    }
                   // dataModel.setConditionCode(conditionCode);
                    dataModel.setConditionTemp(conditionTemp);
                    dataModel.setConditionText(conditionText);
                    dataModel.setConditionMaxTemp(conditionMaxTemp);
                    dataModel.setConditionMinTemp(conditionMinTemp);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Server Down", Toast.LENGTH_SHORT).show();
                if (error instanceof NoConnectionError){
                     Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();

                }

            }
        });
        AppController.getInstance().addToRequestQueue(request);

        return forecastList;
    }


}

