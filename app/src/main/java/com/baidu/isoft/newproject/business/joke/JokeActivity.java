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
    private JokeViewModel jokeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(JokeActivity.this, R.layout.activity_joke);

        jokeViewModel = new JokeViewModel(this, viewDataBinding);
        jokeViewModel.queryData();


    }
}
