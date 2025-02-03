package com.example.atest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
    private RecyclerView recyclerView;
    private WeatherAdapter mweatherAdapter;
    private  List<Weather> mWeatherlist=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
      //  Button button =findViewById(R.id.button);
        //Intent intent=new Intent(this,MainActivity2.class);
        //button.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
              //  startActivity(intent);
            //}
        //});
        super.onCreate(savedInstanceState);EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
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