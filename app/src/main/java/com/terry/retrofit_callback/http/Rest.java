package com.terry.retrofit_callback.http;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * *
 * name     Rest
 * Creater  Terry
 * time     2017/6/21
 * *
 **/

public class Rest {

    private static RestAPI restAPI;

    public static RestAPI getRestApi() {
        if (restAPI == null) {
            //声明日志类
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            //设定日志级别
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            //自定义OkHttpClient
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    //添加拦截器
                    .addInterceptor(httpLoggingInterceptor)
                    .build();
            restAPI = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(RestAPI.class);
        }
        return restAPI;

    }

}
