/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject.business.joke;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.baidu.isoft.newproject.bean.JokeBean;
import com.baidu.isoft.newproject.business.joke.adapter.RecycleJokeAdapter;
import com.baidu.isoft.newproject.databinding.ActivityJokeBinding;
import com.bumptech.glide.Glide;

import android.app.Activity;
import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class JokeViewModel{

     public static final String TAG = JokeViewModel.class.getSimpleName();
     private Activity activity;
     private ActivityJokeBinding activityJokeBinding;


     public JokeViewModel(Activity activity,ActivityJokeBinding activityJokeBinding){
         this.activity = activity;
         this.activityJokeBinding = activityJokeBinding;
     }

     public void queryData(){


         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         Date date = null;
         try {
             date = df.parse("2018-05-05");
         } catch (ParseException e) {
             e.printStackTrace();
         }
         Calendar cal = Calendar.getInstance();
         cal.setTime(date);
         long timestamp = cal.getTimeInMillis();
         long time = timestamp / 1000;
         JokeModel jokeModel = new JokeModel();
         jokeModel.getJokeData(0,1,time+"")
                 .subscribe(new SingleObserver<JokeBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onSuccess(JokeBean jokeBean) {
                         Log.e(TAG, "onSuccess: "+jokeBean.result.data.size() );
                         RecycleJokeAdapter recycleJokeAdapter = new RecycleJokeAdapter(activity, jokeBean);
                         activityJokeBinding.recycleJoke.setLayoutManager(new LinearLayoutManager(activity,
                                 LinearLayoutManager.VERTICAL,false));
                         activityJokeBinding.recycleJoke.setAdapter(recycleJokeAdapter);

                     }

                     @Override
                     public void onError(Throwable e) {

                     }
                 });


     }









}
