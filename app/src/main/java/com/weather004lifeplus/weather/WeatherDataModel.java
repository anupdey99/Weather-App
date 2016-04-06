package com.weather004lifeplus.weather;


/**
 * Created by Akbar on 4/2/2016.
 */
public class WeatherDataModel {


    //last time & date
    private String lastBuildDate;


    //location
    String cityName;
    String countryName;
    String regionName;



    // wind
    private int windChill;
    private int windDirection;
    private int windSpeed;


    //atmosphere
    private int atmosphereHumidity;
    private int atmospherePressure;
    private int atmosphereRising;
    private int atmosphereVisibility;


    // astronomy
    private String astronomySunrise;
    private String astronomySunset;


    //condition(today)
    private int conditionCode;
    private int conditionTemp;
    private int conditionMaxTemp;
    private int conditionMinTemp;
    private String conditionText;


    //forecast
    private String forecastDayName;
    private int forecastHighTemp;
    private int forecastLowTemp;
    private String forecastText;
    private int forecastCode ;

    //Constructor


    public WeatherDataModel( String forecastDayName, int forecastHighTemp, int forecastLowTemp, int forecastCode) {
        this.forecastDayName = forecastDayName;
        this.forecastHighTemp = forecastHighTemp;
        this.forecastLowTemp = forecastLowTemp;
        this.forecastCode = forecastCode;
    }

    public WeatherDataModel(String forecastDayName, int forecastHighTemp, int forecastLowTemp) {
        this.forecastDayName = forecastDayName;
        this.forecastHighTemp = forecastHighTemp;
        this.forecastLowTemp = forecastLowTemp;
    }

    public WeatherDataModel() {
    }


    //GetSet Method

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public int getWindChill() {
        return windChill;
    }

    public void setWindChill(int windChill) {
        this.windChill = windChill;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getAtmosphereHumidity() {
        return atmosphereHumidity;
    }

    public void setAtmosphereHumidity(int atmosphereHumidity) {
        this.atmosphereHumidity = atmosphereHumidity;
    }

    public int getAtmospherePressure() {
        return atmospherePressure;
    }

    public void setAtmospherePressure(int atmospherePressure) {
        this.atmospherePressure = atmospherePressure;
    }

    public int getAtmosphereRising() {
        return atmosphereRising;
    }

    public void setAtmosphereRising(int atmosphereRising) {
        this.atmosphereRising = atmosphereRising;
    }

    public int getAtmosphereVisibility() {
        return atmosphereVisibility;
    }

    public void setAtmosphereVisibility(int atmosphereVisibility) {
        this.atmosphereVisibility = atmosphereVisibility;
    }

    public String getAstronomySunrise() {
        return astronomySunrise;
    }

    public void setAstronomySunrise(String astronomySunrise) {
        this.astronomySunrise = astronomySunrise;
    }

    public String getAstronomySunset() {
        return astronomySunset;
    }

    public void setAstronomySunset(String astronomySunset) {
        this.astronomySunset = astronomySunset;
    }

    public int getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(int conditionCode) {
        this.conditionCode = conditionCode;
    }

    public int getConditionTemp() {
        return conditionTemp;
    }

    public void setConditionTemp(int conditionTemp) {
        this.conditionTemp = conditionTemp;
    }

    public String getConditionText() {
        return conditionText;
    }

    public void setConditionText(String conditionText) {
        this.conditionText = conditionText;
    }

    public int getConditionMaxTemp() {
        return conditionMaxTemp;
    }

    public void setConditionMaxTemp(int conditionMaxTemp) {
        this.conditionMaxTemp = conditionMaxTemp;
    }

    public int getConditionMinTemp() {
        return conditionMinTemp;
    }

    public void setConditionMinTemp(int conditionMinTemp) {
        this.conditionMinTemp = conditionMinTemp;
    }

    public int getForecastCode() {
        return forecastCode;
    }

    public void setForecastCode(int forecastCode) {
        this.forecastCode = forecastCode;
    }

    public String getForecastDayName() {
        return forecastDayName;
    }

    public void setForecastDayName(String forecastDayName) {
        this.forecastDayName = forecastDayName;
    }

    public int getForecastHighTemp() {
        return forecastHighTemp;
    }

    public void setForecastHighTemp(int forecastHighTemp) {
        this.forecastHighTemp = forecastHighTemp;
    }

    public int getForecastLowTemp() {
        return forecastLowTemp;
    }

    public void setForecastLowTemp(int forecastLowTemp) {
        this.forecastLowTemp = forecastLowTemp;
    }

    public String getForecastText() {
        return forecastText;
    }

    public void setForecastText(String forecastText) {
        this.forecastText = forecastText;
    }
}
