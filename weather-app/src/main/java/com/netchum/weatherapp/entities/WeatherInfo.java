package com.netchum.weatherapp.entities;

public class WeatherInfo {
    private String time;

    private String windDirectionString;

    private double temperature;
    private double windSpeed;

    private double windDirectionDouble;

    public WeatherInfo() {

    }

    public WeatherInfo(String time, double temperature, double windSpeed, double windDirectionDouble) {
        this.time = time;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirectionDouble = windDirectionDouble;
        setWindDirectionString(windDirectionDouble);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDirectionDouble() {
        return windDirectionDouble;
    }

    public void setWindDirectionDouble(double windDirection) {
        this.windDirectionDouble = windDirection;
    }

    public String getWindDirectionString() {
        return windDirectionString;
    }

    public void setWindDirectionString(double windDirectionDoubleParam) {
        if(windDirectionDoubleParam >= 0.0 && windDirectionDoubleParam < 90.0) {
            this.windDirectionString = "North-East";
        }
        else if(windDirectionDoubleParam >= 90.0 && windDirectionDoubleParam < 180.0) {
            this.windDirectionString = "South-East";
        }
        else if(windDirectionDoubleParam >= 180.0 && windDirectionDoubleParam < 270.0) {
            this.windDirectionString = "South-West";
        }
        else if(windDirectionDoubleParam >= 270.0 && windDirectionDoubleParam < 360.0) {
            this.windDirectionString = "North-West";
        }
        else {
            this.windDirectionString = "UNKNOWN";
        }
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "time='" + time + '\'' +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                '}';
    }
}
