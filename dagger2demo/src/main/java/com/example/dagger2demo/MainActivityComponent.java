package com.example.dagger2demo;

import dagger.Component;

/**
 * @ProjectName AndroidAdvanced
 * @Author ayu
 * @Date 2023/4/10
 */
@Component
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
