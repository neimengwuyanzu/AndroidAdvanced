package com.example.dagger2demo;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

/**
 * @ProjectName AndroidAdvanced
 * @Author ayu
 * @Date 2023/4/11
 *
 * @Module 注解用于定义一个依赖对象的提供方法集合，这些方法通常用于创建和提供必要的依赖项（例如数据库实例或API客户端）。
 * @Module 提供了一种指定如何创建和提供依赖项的机制，以便Dagger2可以使用它们注入依赖项。
 *
 * @Provides 用来生成实例
 */
@Module
public class GsonModule {

    @Provides
    public Gson provideGson(){
        return new Gson();
    }
}
