package com.example.rxjavademo;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;

/**
 * @ProjectName AndroidAdvanced
 * @Author ayu
 * @Date 2023/4/10
 */
public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        // 打印请求地址
        Log.d("LoggingInterceptor", "Url: " + request.url().toString());

        // 打印请求参数
        if (request.method().equals("POST")) {
            Buffer buffer = new Buffer();
            request.body().writeTo(buffer);
            String params = buffer.readUtf8();
            Log.d("LoggingInterceptor", "Params: " + params);
        }

        Response response = chain.proceed(request);

        return response;
    }
}
