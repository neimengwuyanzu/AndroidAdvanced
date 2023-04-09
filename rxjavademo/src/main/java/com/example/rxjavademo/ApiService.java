package com.example.rxjavademo;

import com.example.rxjavademo.bean.Swordsman;
import com.example.rxjavademo.bean.WanArticle;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @ProjectName AndroidAdvanced
 * @Author ayu
 * @Date 2023/4/10
 */
public interface ApiService {

    @GET("article/list/1/json")
    Observable<WanArticle> getData();

    @GET("data")
    Observable<Swordsman> getData(@Query("page") int page, @Query("size") int size);


}
