package com.example.dagger2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Watch mWatch;
    @Inject
    Gson mGson;
    @Inject
    Car mCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainActivityComponent.create().inject(this);


//        mWatch.work();
//        String json = "{'name':'ayu','age':29}";
//        Man man = mGson.fromJson(json,Man.class);
        String car = mCar.run();
        Log.d("zyzyzy", "onCreate: " + car);
    }
}