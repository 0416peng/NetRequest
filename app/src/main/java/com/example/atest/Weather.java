package com.example.atest;

public class Weather{
    public String weather;
    public String temperature;
    public  String time;

    public Weather(String weather, String temperature, String time) {
        this.weather = weather;
        this.temperature = temperature;
        this.time = time;
    }


    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }




}