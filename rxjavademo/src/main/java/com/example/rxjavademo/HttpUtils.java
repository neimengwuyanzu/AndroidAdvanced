package com.example.rxjavademo;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ProjectName AndroidAdvanced
 * @Author ayu
 * @Date 2023/4/10
 */
public class HttpUtils {

    private static final String BASE_URL = "https://wanandroid.com/";
    private static HttpUtils instance;
    private Retrofit retrofit;


    public static HttpUtils getInstance() {
        if (instance == null) {
            synchronized (HttpUtils.class) {
                if (instance == null) {
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    private HttpUtils() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        // 添加请求拦截器，用于打印请求日志
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(new LoggingInterceptor());

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public <T> Observable<T> create(final Class<T> service) {
        return Observable.create(new ObservableOnSubscribe<T>() {
                    @Override
                    public void subscribe(final ObservableEmitter<T> emitter) throws Exception {
                        T api = retrofit.create(service);
                        emitter.onNext(api);
                        emitter.onComplete();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
