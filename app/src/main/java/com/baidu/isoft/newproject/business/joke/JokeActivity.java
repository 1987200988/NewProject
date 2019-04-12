/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject.business.joke;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.baidu.isoft.newproject.R;
import com.baidu.isoft.newproject.bean.JokeBean;
import com.baidu.isoft.newproject.business.news.NewsModel;
import com.baidu.isoft.newproject.databinding.ActivityJokeBinding;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class JokeActivity extends AppCompatActivity {

    private ActivityJokeBinding viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(JokeActivity.this, R.layout.activity_joke);
        JokeBean jokeBean1 = new JokeBean();
        jokeBean1.reasonField.set("haxiba");
        viewDataBinding.setJokeBean(jokeBean1);
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
                        JokeBean jokeBean1 = new JokeBean();
                        jokeBean1.reasonField.set("haxiba");
                        viewDataBinding.setJokeBean(jokeBean1);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });


    }
}
