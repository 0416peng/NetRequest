package com.example.atest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

    private Handler mHandler;
    private Handler mHandler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvcity = findViewById(R.id.city);

        loadjson=findViewById(R.id.loadjson);
        mHandler =new MyHandler();
        mHandler2 =new MyHandler2();
        initClick();
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
        //获取搜索数据
        Intent intent2 = this.getIntent();
        city = intent2.getStringExtra("data_city");
        province = intent2.getStringExtra("data_province");

        //初始化控件
        recyclerView = findViewById(R.id.weatherlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //数据
        mWeatherlist.add(new Weather("a", "A", "02/02"));
        mWeatherlist.add(new Weather("b", "B", "02/02"));
        mWeatherlist.add(new Weather("b", "B", "02/02"));
        mWeatherlist.add(new Weather("b", "B", "02/02"));
        mWeatherlist.add(new Weather("b", "B", "02/02"));
        mWeatherlist.add(new Weather("b", "B", "02/02"));
        mWeatherlist.add(new Weather("b", "B", "02/02"));

        //初始化适配器
        mweatherAdapter = new WeatherAdapter(mWeatherlist);
        //设置适配器
        recyclerView.setAdapter(mweatherAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            return insets;

        });
    }
    //获取网络数据
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
    private void initClick(){
        loadjson.setOnClickListener(v -> {
            LinkedHashMap<String,String> params = new LinkedHashMap<>();
            params.put("token","fv5fkmgrg3rvjkoddbqeqqzqqkzl8y");
            params.put("province",province);
            params.put("city",city);
            sendPOSTRequest(mUrl,params);
            sendPOSTRequest2(nurl,params);
        });


    }
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

        }
    }
    private class MyHandler2 extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String result = (String) msg.obj;
            parseJsondataAndShow2(result);
        }



        public void parseJsondataAndShow2(String jsonStr) {
            Gson gson =new Gson();
            WeatherBean2 weatherBean2 =gson.fromJson(jsonStr,WeatherBean2.class);
        }
    }



}