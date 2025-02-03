package com.example.atest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyHolder> {
    private List<Weather> mWeather =new ArrayList<>();
    public WeatherAdapter(List<Weather> list){
        this.mWeather =list;
    }

    @NonNull
    @Override
    public WeatherAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.MyHolder holder, int position) {
        Weather weather=mWeather.get(position);
        holder.weather.setText( weather.getWeather());
        holder.time.setText(weather.getTime());
        holder.temperature.setText(weather.getTemperature());
    }

    @Override
    public int getItemCount() {
        return mWeather.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView weather;
        TextView time;
        TextView temperature;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            weather=itemView.findViewById(R.id.weather1);
            time=itemView.findViewById(R.id.time1);
            temperature=itemView.findViewById(R.id.temperature1);
        }
    }
}
