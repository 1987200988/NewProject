/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject.business.joke;

import com.baidu.isoft.newproject.bean.JokeBean;
import com.baidu.isoft.newproject.network.ApiService;
import com.baidu.isoft.newproject.network.NetWorkHelper;
import com.baidu.isoft.newproject.network.RxJavaHelper;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class JokeModel {




     public Single<JokeBean> getJokeData(int page,int pagesize,String time){
        return NetWorkHelper.getInstance().getService().getJoke(ApiService.JOKE_KEY,page,pagesize,"desc",
                 time).compose(RxJavaHelper.handleSingle());

     }




}
