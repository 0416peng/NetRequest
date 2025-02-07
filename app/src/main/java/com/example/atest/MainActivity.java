package com.example.atest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity";
    private RecyclerView recyclerView;
    private WeatherAdapter mweatherAdapter;
    private  List<Weather> mWeatherlist=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //获取网络数据


        //转到搜索界面
        Button button =findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                finish();
            }

        });
        //获取搜索数据
         Intent intent2=this.getIntent();
        String city=intent2.getStringExtra("data_city");
        String province=intent2.getStringExtra("data_province");
        //初始化控件
        recyclerView=findViewById(R.id.weatherlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //数据
        mWeatherlist.add(new Weather("a","A","02/02"));
        mWeatherlist.add(new Weather("b","B","02/02"));
        mWeatherlist.add(new Weather("b","B","02/02"));
        mWeatherlist.add(new Weather("b","B","02/02"));
        mWeatherlist.add(new Weather("b","B","02/02"));
        mWeatherlist.add(new Weather("b","B","02/02"));
        mWeatherlist.add(new Weather("b","B","02/02"));

        //初始化适配器
        mweatherAdapter =new WeatherAdapter(mWeatherlist);
        //设置适配器
        recyclerView.setAdapter(mweatherAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            return insets;

        });
    }
}