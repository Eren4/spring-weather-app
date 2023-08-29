package com.netchum.weatherapp.entities;

public class WeatherInfo {
    private String time;
    private double temperature;
    private double windSpeed;
    private double windDirection;

    public WeatherInfo() {

    }

    public WeatherInfo(String time, double temperature, double windSpeed, double windDirection) {
        this.time = time;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
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

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
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
