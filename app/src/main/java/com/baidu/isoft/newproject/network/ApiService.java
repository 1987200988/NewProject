/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject.network;

import com.baidu.isoft.newproject.bean.JokeBean;
import com.baidu.isoft.newproject.bean.LolBean;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String DEBUG_URL = "http://cp01-face-1.epc.baidu.com:8014/";
    String BASE_URL = "http://v.juhe.cn/joke/content/";
    String BASE_HTTPS_URL = "https://fleet.apollo.auto/";

    String JOKE_KEY = "0e79585c627db86f0e9c5f0bb38c29f3";

    private String BASE_URL_QUANMIN = "http://www.quanmin.tv/";
    @GET("list.php")
    Single<JokeBean> getJoke(
            @Query("key") String key,
            @Query("page") int page,
            @Query("pagesize") int pagesize,
            @Query("sort") String sort,
            @Query("time") String time
    );

// if(position==0){
//        mLolData = iApiInterface.getLolData("1","2.2.4","1","4");
//    }else if(position==1){
//        mLolData = iApiInterface.getLolData1("1","2.2.4","1","4");
//
//    }else if(position==2){
//        mLolData = iApiInterface.getLolData2("1","2.2.4","1","4");
//
//    }else if(position==3){
//        mLolData = iApiInterface.getLolData3("1","2.2.4","1","4");
//
//    }else if(position==4){
//        mLolData = iApiInterface.getLolData4("1","2.2.4","1","4");
//
//    }else if(position==5){
//        mLolData = iApiInterface.getLolData5("1","2.2.4","1","4");

    @GET("json%2Fcategories%2Fbeauty%2Flist.json?11211639")
    Observable<LolBean> getLolData1(@Query("os") String os1,
                                    @Query("v") String v,
                                    @Query("os") String os2,
                                    @Query("ver") String ver);

    @GET("json%2Fcategories%2Foverwatch%2Flist.json?11211639")
    Observable<LolBean> getLolData2(@Query("os") String os1,
                                    @Query("v") String v,
                                    @Query("os") String os2,
                                    @Query("ver") String ver);







}
