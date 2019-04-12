/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject.network;

import com.baidu.isoft.newproject.bean.JokeBean;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String DEBUG_URL = "http://cp01-face-1.epc.baidu.com:8014/";
    String BASE_URL = "http://v.juhe.cn/joke/content/";
    String BASE_HTTPS_URL = "https://fleet.apollo.auto/";

    String JOKE_KEY = "0e79585c627db86f0e9c5f0bb38c29f3";


    @GET("list.php")
    Single<JokeBean> getJoke(
            @Query("key") String key,
            @Query("page") int page,
            @Query("pagesize") int pagesize,
            @Query("sort") String sort,
            @Query("time") String time
    );










}
