/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject.network;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSocketFactory;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkHelper {

    private ApiService apiService;
    private static final int DEFAULT_TIMEOUT = 5000;


    private static class Singleton {
        private static final NetWorkHelper INSTANCE = new NetWorkHelper();
    }

    public static NetWorkHelper getInstance() {
        return Singleton.INSTANCE;
    }

    public ApiService getService() {
        return apiService;
    }

    private NetWorkHelper() {

//        SSLSocketFactory sslSocketFactory = SSLSocketLoader.createSSLSocketFactory();
//        boolean isHttpsEnabled = sslSocketFactory != null;

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.addInterceptor(loggingInterceptor);
//        if (isHttpsEnabled) {
//            builder.sslSocketFactory(sslSocketFactory);
//        }

        // 设置GSON转换规则
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl(isHttpsEnabled ? VOPService.BASE_HTTPS_URL : VOPService.BASE_URL)
                .baseUrl(ApiService.BASE_URL)
                .build();
        apiService = retrofit.create(ApiService.class);
    }
}
