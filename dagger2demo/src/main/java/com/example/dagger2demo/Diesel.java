package com.example.dagger2demo;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

/**
 * @ProjectName AndroidAdvanced
 * @Author ayu
 * @Date 2023/4/11
 * 自定义注解
 */
@Qualifier
@Retention(RUNTIME)
public @interface Diesel {
}
