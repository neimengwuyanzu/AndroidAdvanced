package com.example.dagger2demo;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @ProjectName AndroidAdvanced
 * @Author ayu
 * @Date 2023/4/11
 */
@Module
public class EnglineModule {
    @Provides
//    @Named("GasoLine")
    @Gasoline
    public Engine provideGasoline(){
        return new GasoLineEngine();
    }

    @Provides
//    @Named("Diesel")
    @Diesel
    public Engine provideDiesel(){
        return new DieselEngine();
    }
}
