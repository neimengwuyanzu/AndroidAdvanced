package com.example.dagger2demo;

import dagger.Component;

/**
 * @ProjectName AndroidAdvanced
 * @Author ayu
 * @Date 2023/4/10
 * modules = {} 指定module 可以指定多个
 */
@Component(modules = {GsonModule.class,EnglineModule.class})
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
