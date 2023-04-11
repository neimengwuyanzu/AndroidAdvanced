package com.example.dagger2demo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @ProjectName AndroidAdvanced
 * @Author ayu
 * @Date 2023/4/11
 */
public class Car {
    private Engine mEngine;

    /**
     * 使用创建好的自定义注解 指定使用的类
     * @param engine
     */
    @Inject
    public Car(@Gasoline Engine engine){
        this.mEngine = engine;
    }

    public String run(){
        return mEngine.work();
    }
}
