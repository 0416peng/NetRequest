package com.example.atest;

import java.util.List;


public class JsonData {



    private String requestId;

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

    private Boolean success;

    private String message;

    private Integer code;

    private DataDTO data;

    private Integer time;

    private Integer usage;



    public static class DataDTO {

        private String city;

        private String cityEn;

        private String province;

        private String provinceEn;

        private String cityId;

        private String date;

        private String updateTime;

        private String weather;

        private String weatherCode;

        private Double temp;

        private Integer minTemp;

        private Integer maxTemp;

        private String wind;

        private String windSpeed;

        private String windPower;

        private String rain;

        private String rain24h;

        private String humidity;

        private String visibility;

        private String pressure;

        private String tailNumber;

        private String air;

        private String airPm25;

        private String sunrise;

        private String sunset;

        private DataDTO.AqiDTO aqi;

        private List<IndexDTO> index;

        private List<?> alarm;

        private List<HourDTO> hour;



        public static class AqiDTO {

            private String air;

            private String airLevel;

            private String airTips;

            private String pm25;

            private String pm10;

            private String co;

            private String no2;

            private String so2;

            private String o3;
        }



        public static class IndexDTO {

            private String type;

            private String level;

            private String name;

            private String content;
        }



        public static class HourDTO {

            private String time;

            private Integer temp;

            private String wea;

            private String weaCode;

            private String wind;

            private String windLevel;
        }
    }
}
