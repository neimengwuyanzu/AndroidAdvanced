package com.example.dagger2demo;

import android.util.Log;

import javax.inject.Inject;

/**
 * @ProjectName AndroidAdvanced
 * @Author ayu
 * @Date 2023/4/10
 */
public class Watch {
    @Inject
    public Watch(){

    }

    public void work(){
        Log.d("zyzyzy", "干活儿了！干活儿了！");
    }
}
