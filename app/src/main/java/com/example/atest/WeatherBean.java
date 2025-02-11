package com.example.atest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherBean {

    @SerializedName("request_id")
    private String requestId;
    @SerializedName("success")
    private Boolean success;
    @SerializedName("message")
    private String message;
    @SerializedName("code")
    private Integer code;
    @SerializedName("data")
    private DataDTO data;
    @SerializedName("time")
    private Integer time;
    @SerializedName("usage")
    private Integer usage;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getUsage() {
        return usage;
    }

    public void setUsage(Integer usage) {
        this.usage = usage;
    }

    public static class DataDTO {
        @SerializedName("city")
        private String city;
        @SerializedName("city_en")
        private String cityEn;
        @SerializedName("province")
        private String province;
        @SerializedName("province_en")
        private String provinceEn;
        @SerializedName("city_id")
        private String cityId;
        @SerializedName("date")
        private String date;
        @SerializedName("update_time")
        private String updateTime;
        @SerializedName("weather")
        private String weather;
        @SerializedName("weather_code")
        private String weatherCode;
        @SerializedName("temp")
        private Double temp;
        @SerializedName("min_temp")
        private Integer minTemp;
        @SerializedName("max_temp")
        private Integer maxTemp;
        @SerializedName("wind")
        private String wind;
        @SerializedName("wind_speed")
        private String windSpeed;
        @SerializedName("wind_power")
        private String windPower;
        @SerializedName("rain")
        private String rain;
        @SerializedName("rain_24h")
        private String rain24h;
        @SerializedName("humidity")
        private String humidity;
        @SerializedName("visibility")
        private String visibility;
        @SerializedName("pressure")
        private String pressure;
        @SerializedName("tail_number")
        private String tailNumber;
        @SerializedName("air")
        private String air;
        @SerializedName("air_pm25")
        private String airPm25;
        @SerializedName("sunrise")
        private String sunrise;
        @SerializedName("sunset")
        private String sunset;
        @SerializedName("aqi")
        private AqiDTO aqi;
        @SerializedName("index")
        private List<IndexDTO> index;
        @SerializedName("alarm")
        private List<?> alarm;
        @SerializedName("hour")
        private List<HourDTO> hour;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityEn() {
            return cityEn;
        }

        public void setCityEn(String cityEn) {
            this.cityEn = cityEn;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getProvinceEn() {
            return provinceEn;
        }

        public void setProvinceEn(String provinceEn) {
            this.provinceEn = provinceEn;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getWeatherCode() {
            return weatherCode;
        }

        public void setWeatherCode(String weatherCode) {
            this.weatherCode = weatherCode;
        }

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Integer getMinTemp() {
            return minTemp;
        }

        public void setMinTemp(Integer minTemp) {
            this.minTemp = minTemp;
        }

        public Integer getMaxTemp() {
            return maxTemp;
        }

        public void setMaxTemp(Integer maxTemp) {
            this.maxTemp = maxTemp;
        }

        public String getWind() {
            return wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }

        public String getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(String windSpeed) {
            this.windSpeed = windSpeed;
        }

        public String getWindPower() {
            return windPower;
        }

        public void setWindPower(String windPower) {
            this.windPower = windPower;
        }

        public String getRain() {
            return rain;
        }

        public void setRain(String rain) {
            this.rain = rain;
        }

        public String getRain24h() {
            return rain24h;
        }

        public void setRain24h(String rain24h) {
            this.rain24h = rain24h;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getVisibility() {
            return visibility;
        }

        public void setVisibility(String visibility) {
            this.visibility = visibility;
        }

        public String getPressure() {
            return pressure;
        }

        public void setPressure(String pressure) {
            this.pressure = pressure;
        }

        public String getTailNumber() {
            return tailNumber;
        }

        public void setTailNumber(String tailNumber) {
            this.tailNumber = tailNumber;
        }

        public String getAir() {
            return air;
        }

        public void setAir(String air) {
            this.air = air;
        }

        public String getAirPm25() {
            return airPm25;
        }

        public void setAirPm25(String airPm25) {
            this.airPm25 = airPm25;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public AqiDTO getAqi() {
            return aqi;
        }

        public void setAqi(AqiDTO aqi) {
            this.aqi = aqi;
        }

        public List<IndexDTO> getIndex() {
            return index;
        }

        public void setIndex(List<IndexDTO> index) {
            this.index = index;
        }

        public List<?> getAlarm() {
            return alarm;
        }

        public void setAlarm(List<?> alarm) {
            this.alarm = alarm;
        }

        public List<HourDTO> getHour() {
            return hour;
        }

        public void setHour(List<HourDTO> hour) {
            this.hour = hour;
        }

        public static class AqiDTO {
            @SerializedName("air")
            private String air;
            @SerializedName("air_level")
            private String airLevel;
            @SerializedName("air_tips")
            private String airTips;
            @SerializedName("pm25")
            private String pm25;
            @SerializedName("pm10")
            private String pm10;
            @SerializedName("co")
            private String co;
            @SerializedName("no2")
            private String no2;
            @SerializedName("so2")
            private String so2;
            @SerializedName("o3")
            private String o3;

            public String getAir() {
                return air;
            }

            public void setAir(String air) {
                this.air = air;
            }

            public String getAirLevel() {
                return airLevel;
            }

            public void setAirLevel(String airLevel) {
                this.airLevel = airLevel;
            }

            public String getAirTips() {
                return airTips;
            }

            public void setAirTips(String airTips) {
                this.airTips = airTips;
            }

            public String getPm25() {
                return pm25;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public String getPm10() {
                return pm10;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public String getCo() {
                return co;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public String getNo2() {
                return no2;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public String getSo2() {
                return so2;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }

            public String getO3() {
                return o3;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }
        }

        public static class IndexDTO {
            @SerializedName("type")
            private String type;
            @SerializedName("level")
            private String level;
            @SerializedName("name")
            private String name;
            @SerializedName("content")
            private String content;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        public static class HourDTO {
            @SerializedName("time")
            private String time;
            @SerializedName("temp")
            private Integer temp;
            @SerializedName("wea")
            private String wea;
            @SerializedName("wea_code")
            private String weaCode;
            @SerializedName("wind")
            private String wind;
            @SerializedName("wind_level")
            private String windLevel;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public Integer getTemp() {
                return temp;
            }

            public void setTemp(Integer temp) {
                this.temp = temp;
            }

            public String getWea() {
                return wea;
            }

            public void setWea(String wea) {
                this.wea = wea;
            }

            public String getWeaCode() {
                return weaCode;
            }

            public void setWeaCode(String weaCode) {
                this.weaCode = weaCode;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getWindLevel() {
                return windLevel;
            }

            public void setWindLevel(String windLevel) {
                this.windLevel = windLevel;
            }
        }
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "requestId='" + requestId + '\'' +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                ", time=" + time +
                ", usage=" + usage +
                '}';
    }
}
