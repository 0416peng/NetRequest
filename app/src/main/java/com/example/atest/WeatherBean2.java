package com.example.atest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherBean2 {

    @SerializedName("request_id")
    private String requestId;
    @SerializedName("success")
    private Boolean success;
    @SerializedName("message")
    private String message;
    @SerializedName("code")
    private Integer code;
    @SerializedName("data")
    private List<DataDTO> data;
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

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
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
        @SerializedName("city_id")
        private String cityId;
        @SerializedName("city")
        private String city;
        @SerializedName("province")
        private String province;
        @SerializedName("leader")
        private String leader;
        @SerializedName("date")
        private String date;
        @SerializedName("temp_day")
        private String tempDay;
        @SerializedName("temp_night")
        private String tempNight;
        @SerializedName("wea_day")
        private String weaDay;
        @SerializedName("wea_day_code")
        private String weaDayCode;
        @SerializedName("wea_night")
        private String weaNight;
        @SerializedName("wea_night_code")
        private String weaNightCode;
        @SerializedName("wind_day")
        private String windDay;
        @SerializedName("wind_night")
        private String windNight;
        @SerializedName("wind_day_level")
        private String windDayLevel;
        @SerializedName("wind_night_level")
        private String windNightLevel;
        @SerializedName("air")
        private String air;
        @SerializedName("air_level")
        private String airLevel;
        @SerializedName("precipitation")
        private String precipitation;
        @SerializedName("sunrise")
        private String sunrise;
        @SerializedName("sunset")
        private String sunset;

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getLeader() {
            return leader;
        }

        public void setLeader(String leader) {
            this.leader = leader;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTempDay() {
            return tempDay;
        }

        public void setTempDay(String tempDay) {
            this.tempDay = tempDay;
        }

        public String getTempNight() {
            return tempNight;
        }

        public void setTempNight(String tempNight) {
            this.tempNight = tempNight;
        }

        public String getWeaDay() {
            return weaDay;
        }

        public void setWeaDay(String weaDay) {
            this.weaDay = weaDay;
        }

        public String getWeaDayCode() {
            return weaDayCode;
        }

        public void setWeaDayCode(String weaDayCode) {
            this.weaDayCode = weaDayCode;
        }

        public String getWeaNight() {
            return weaNight;
        }

        public void setWeaNight(String weaNight) {
            this.weaNight = weaNight;
        }

        public String getWeaNightCode() {
            return weaNightCode;
        }

        public void setWeaNightCode(String weaNightCode) {
            this.weaNightCode = weaNightCode;
        }

        public String getWindDay() {
            return windDay;
        }

        public void setWindDay(String windDay) {
            this.windDay = windDay;
        }

        public String getWindNight() {
            return windNight;
        }

        public void setWindNight(String windNight) {
            this.windNight = windNight;
        }

        public String getWindDayLevel() {
            return windDayLevel;
        }

        public void setWindDayLevel(String windDayLevel) {
            this.windDayLevel = windDayLevel;
        }

        public String getWindNightLevel() {
            return windNightLevel;
        }

        public void setWindNightLevel(String windNightLevel) {
            this.windNightLevel = windNightLevel;
        }

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

        public String getPrecipitation() {
            return precipitation;
        }

        public void setPrecipitation(String precipitation) {
            this.precipitation = precipitation;
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
    }
}
