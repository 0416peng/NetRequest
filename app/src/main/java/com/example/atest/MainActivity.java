


package com.example.atest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//定义
    private RecyclerView recyclerView;
    private WeatherAdapter mweatherAdapter;
    private  List<Weather> mWeatherlist=new ArrayList<>();
    private String mUrl = "https://v3.alapi.cn/api/tianqi";
    private String nurl ="https://v3.alapi.cn/api/tianqi/forty";
    private Button loadjson;
    private String token ="fv5fkmgrg3rvjkoddbqeqqzqqkzl8y" ;
    private String city ;
    private String province;
    private TextView tvcity;
    private TextView tvweather;
    private TextView tvtemp;

    private  TextView tvpm25;
    private  TextView tvpm10;
    private TextView tvso2;
    private  TextView tvco;
    private TextView tvair;
    private TextView tvair_level;
    private Button burain;
    private Button buhumidity;
    private Button bupressure;
    private Button buvisibility;
    private Button budiaoyu_index;
    private Button buganmao_index;
    private Button buxiche_index;
    private Button buguoming_index;
    private Button buyundong_index;
    private Button buziwaixian_index;

    private Handler mHandler;
    private Handler mHandler2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //绑定控件
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvcity = findViewById(R.id.city);
        //tvtips =findViewById(R.id.airtips);
        tvair=findViewById(R.id.air);
        tvair_level=findViewById(R.id.air_level);
        tvco=findViewById(R.id.co);
        tvpm10=findViewById(R.id.pm10);
        tvso2=findViewById(R.id.so2);
        tvpm25=findViewById(R.id.pm25);
        tvtemp=findViewById(R.id.temperature);
        tvweather=findViewById(R.id.weather);
        burain=findViewById(R.id.rain);
        buhumidity=findViewById(R.id.humidity);
        bupressure=findViewById(R.id.pressure);
        buvisibility=findViewById(R.id.visibility);
        budiaoyu_index=findViewById(R.id.diaoyu_index);
        buganmao_index=findViewById(R.id.ganmao_index);
        buguoming_index=findViewById(R.id.guoming_index);
        buxiche_index=findViewById(R.id.xiche_index);
        buyundong_index=findViewById(R.id.yundong_index);
        buziwaixian_index=findViewById(R.id.ziwaixian_index);
        loadjson=findViewById(R.id.loadjson);
        mHandler =new MyHandler();
        mHandler2 =new MyHandler2();
        initClick();
        initClick2();
        //转到搜索界面
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }

        });
        //获取搜索数据并进行一次搜索
        Intent intent2 = this.getIntent();
        city = intent2.getStringExtra("data_city");
        province = intent2.getStringExtra("data_province");
        if(city==null){
            SharedPreferences share = getSharedPreferences("myprefs", Context.MODE_PRIVATE);
            city= share.getString("city",null);
            province =share.getString("province",null);
        }
        //储存数据
        SharedPreferences share = getSharedPreferences("myprefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();
        edit.putString("city",city);
        edit.putString("province",province);
        edit.commit();
        LinkedHashMap<String,String> params = new LinkedHashMap<>();
        LinkedHashMap<String,String> params2 = new LinkedHashMap<>();
        params.put("token","fv5fkmgrg3rvjkoddbqeqqzqqkzl8y");
        params.put("province",province);
        params.put("city",city);
        params2.put("token","sin9hceufk7hniqc78lsi0t3fy5w11");
        params2.put("province",province);
        params2.put("city",city);
        sendPOSTRequest(mUrl,params);
        sendPOSTRequest2(nurl,params2);
        //初始化rv控件
        recyclerView = findViewById(R.id.weatherlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //初始化rv适配器
        mweatherAdapter = new WeatherAdapter(mWeatherlist);
        //设置rv适配器
        recyclerView.setAdapter(mweatherAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            return insets;

        });
    }
    //获取网络数据（一天）
    private void sendPOSTRequest(String mUrl,HashMap<String,String>params){

        new Thread(
                () -> {
                    try {
                        URL url = new URL(mUrl);
                        HttpURLConnection connection = (HttpURLConnection)
                                url.openConnection();
                        connection.setRequestMethod("POST");
                        connection.setConnectTimeout(8000);
                        connection.setReadTimeout(8000);
                        connection.connect();
                        StringBuilder dataToWrite = new StringBuilder();
                        for (String key : params.keySet()) {
                           dataToWrite.append(key).append("=").append(params.get(key)).append("&");
                        }
                        connection.connect();
                        OutputStream outputStream = connection.getOutputStream();
                        outputStream.write(dataToWrite.substring(0,dataToWrite.length() - 1).getBytes());
                        InputStream in = connection.getInputStream();
                        String responseData = StreamToString(in);
                        Message message =new Message();
                        message.obj =responseData;
                        mHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }
    private String StreamToString(InputStream in) {
        StringBuilder sb = new StringBuilder();
        String oneLine;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            while ((oneLine = reader.readLine()) != null) {
                sb.append(oneLine).append('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    //获取网络数据（40天）
    private void sendPOSTRequest2(String nUrl,HashMap<String,String>params){

        new Thread(
                () -> {
                    try {
                        URL url = new URL(nUrl);
                        HttpURLConnection connection = (HttpURLConnection)
                                url.openConnection();
                        connection.setRequestMethod("POST");
                        connection.setConnectTimeout(8000);
                        connection.setReadTimeout(8000);
                        connection.connect();
                        StringBuilder dataToWrite = new StringBuilder();
                        for (String key : params.keySet()) {
                            dataToWrite.append(key).append("=").append(params.get(key)).append("&");
                        }
                        connection.connect();
                        OutputStream outputStream = connection.getOutputStream();
                        outputStream.write(dataToWrite.substring(0,dataToWrite.length() - 1).getBytes());
                        InputStream in = connection.getInputStream();
                        String responseData = StreamToString2(in);
                        Log.d("lx","responseData"+responseData);
                        Message message =new Message();
                        message.obj =responseData;
                        mHandler2.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }
    private String StreamToString2(InputStream in) {
        StringBuilder sb = new StringBuilder();
        String oneLine;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            while ((oneLine = reader.readLine()) != null) {
                sb.append(oneLine).append('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    //点击事件，进行网络请求
    private void initClick(){
        loadjson.setOnClickListener(v -> {
            LinkedHashMap<String,String> params = new LinkedHashMap<>();
            params.put("token","fv5fkmgrg3rvjkoddbqeqqzqqkzl8y");
            params.put("province",province);
            params.put("city",city);
            sendPOSTRequest(mUrl,params);
        });


    }
    private void initClick2(){
        loadjson.setOnClickListener(v -> {
            LinkedHashMap<String,String> params = new LinkedHashMap<>();
            params.put("token","sin9hceufk7hniqc78lsi0t3fy5w11");
            params.put("province",province);
            params.put("city",city);
            sendPOSTRequest2(nurl,params);
        });


    }
    //将获取的json数据转化并显示出来
    private class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String result = (String) msg.obj;
            parseJsondataAndShow(result);
        }
        public void parseJsondataAndShow(String jsonStr) {
            Gson gson =new Gson();
            WeatherBean weatherBean =gson.fromJson(jsonStr,WeatherBean.class);
            String message = weatherBean.getMessage();
            if(weatherBean.getData()!=null){
            String city = weatherBean.getData().getCity();
                tvcity.setText(city);
                String weather = weatherBean.getData().getWeather();
                int mintemp = weatherBean.getData().getMinTemp();
                String min = String.valueOf(mintemp);
                int maxtemp = weatherBean.getData().getMaxTemp();
                String max = String.valueOf(maxtemp);
                tvweather.setText(weather + min + "℃" + "--" + max + "℃");
                Double temp = weatherBean.getData().getTemp();
                int temp1=(int)temp.doubleValue();
                String temp2;
                temp2 = String.valueOf(temp1);
                tvtemp.setText(temp2);
                String air = weatherBean.getData().getAir();
                tvair.setText(air);
                String co = weatherBean.getData().getAqi().getCo();
                tvco.setText(co);
                String so2 = weatherBean.getData().getAqi().getSo2();
                tvso2.setText(so2);
                String pm10 = weatherBean.getData().getAqi().getPm10();
                tvpm10.setText(pm10);
                String pm25 = weatherBean.getData().getAqi().getPm25();
                tvpm25.setText(pm25);
                String air_level = weatherBean.getData().getAqi().getAirLevel();
                tvair_level.setText(air_level);
                String rain = weatherBean.getData().getRain();
                burain.setText("降雨量\n" + rain);
                String humidity = weatherBean.getData().getHumidity();
                buhumidity.setText("湿度\n" + humidity);
                String pressure = weatherBean.getData().getPressure();
                bupressure.setText("气压\n" + pressure);
                String visibility = weatherBean.getData().getVisibility();
                buvisibility.setText("能见度\n" + visibility);
                List<WeatherBean.DataDTO.IndexDTO> Index = weatherBean.getData().getIndex();
                WeatherBean.DataDTO.IndexDTO indexDTO1 = Index.get(0);
                String name1 = indexDTO1.getName();
                String level1 = indexDTO1.getLevel();
                buganmao_index.setText(name1 + "\n" + level1);
                WeatherBean.DataDTO.IndexDTO indexDTO2 = Index.get(1);
                String name2 = indexDTO2.getName();
                String level2 = indexDTO2.getLevel();
                budiaoyu_index.setText(name2 + "\n" + level2);
                WeatherBean.DataDTO.IndexDTO indexDTO3 = Index.get(2);
                String name3 = indexDTO3.getName();
                String level3 = indexDTO3.getLevel();
                buguoming_index.setText(name3 + "\n" + level3);
                WeatherBean.DataDTO.IndexDTO indexDTO4 = Index.get(3);
                String name4 = indexDTO4.getName();
                String level4 = indexDTO4.getLevel();
                buxiche_index.setText(name4 + "\n" + level4);
                WeatherBean.DataDTO.IndexDTO indexDTO5 = Index.get(4);
                String name5 = indexDTO5.getName();
                String level5 = indexDTO5.getLevel();
                buyundong_index.setText(name5 + "\n" + level5);
                WeatherBean.DataDTO.IndexDTO indexDTO6 = Index.get(5);
                String name6 = indexDTO6.getName();
                String level6 = indexDTO6.getLevel();
                buziwaixian_index.setText(name6 + "\n" + level6);

    }
        else{
        tvcity.setText(message);
        }
        }
        }
    public class MyHandler2 extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String result = (String) msg.obj;
            ParseJsondata(result);
        }



        private void ParseJsondata(String jsonStr) {
            Gson gson = new Gson();
            WeatherBean2 weatherBean2 = gson.fromJson(jsonStr, WeatherBean2.class);
            String message = weatherBean2.getMessage();
            if (weatherBean2.getData()!=null) {
                List<WeatherBean2.DataDTO> data ;
                data=weatherBean2.getData();
                for(WeatherBean2.DataDTO dataDTO : data){
                    Weather weather =new Weather(dataDTO.getWeaDay(),dataDTO.getTempDay()+"℃",(dataDTO.getDate()).substring(5));
                    mWeatherlist.add(weather);
                }


                mweatherAdapter.notifyDataSetChanged();
            } else {
                mWeatherlist.add(new Weather("null","null","null"));
                mweatherAdapter.notifyDataSetChanged();
            }

        }



    }}



