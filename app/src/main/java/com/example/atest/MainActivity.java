package com.example.atest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private WeatherAdapter mweatherAdapter;
    private  List<Weather> mWeatherlist=new ArrayList<>();
     private String mUrl = "https://v3.alapi.cn/api/tianqi";
     private Button loadjson;
     private String token ="fv5fkmgrg3rvjkoddbqeqqzqqkzl8y" ;
     private String city ;
     private String province;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        loadjson=findViewById(R.id.loadjson);
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
        //lambda表达式，相当于其中new Runnable并且重写⽅法
        new Thread(
                () -> {
                    try {
                        URL url = new URL(mUrl);
                        HttpURLConnection connection = (HttpURLConnection)
                                url.openConnection();
                        connection.setRequestMethod("POST");//设置请求⽅式为POST
                        connection.setConnectTimeout(8000);//设置最⼤连接时间，单位为ms
                        connection.setReadTimeout(8000);//设置最⼤的读取时间，单位为ms
                        connection.setRequestProperty("Accept-Language",
                                "zh-CN,zh;q=0.9");
                        connection.setRequestProperty("Accept-Encoding",
                                "gzip,deflate");
                        connection.connect();//正式连接
                        StringBuilder dataToWrite = new StringBuilder("{");
                        boolean first =true;
                        for (String key : params.keySet()) {
                            if (!first) {
                                dataToWrite.append(",");
                            }
                            dataToWrite.append("\"").append(key).append("\":\"").append(params.get(key)).append("\"");
                            first = false;
                        }
                        dataToWrite.append("}");

                        connection.connect();
                        OutputStream outputStream = connection.getOutputStream();
                        outputStream.write(dataToWrite.substring(0, dataToWrite.length() ).getBytes());//输出
                        InputStream in = connection.getInputStream();//从接⼝处获取
                        String responseData = StreamToString(in);//这⾥就是服务器返回的数据
                        Log.d("lx", "sendPOSTNetRequest: "+responseData);
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
    private void initClick(){
        loadjson.setOnClickListener(v -> {
            HashMap<String,String> params = new HashMap<>();
            params.put("token",token);
            params.put("city",city);
            params.put("province",province);
            sendPOSTRequest(mUrl,params);
        });

            }}