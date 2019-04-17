/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject;

import com.baidu.isoft.newproject.adapter.ViewPager2Adapter;
import com.baidu.isoft.newproject.bean.JokeBean;
import com.baidu.isoft.newproject.bean.MainFunctionBean;
import com.baidu.isoft.newproject.business.joke.JokeActivity;
import com.baidu.isoft.newproject.business.news.NewsActivity;
import com.baidu.isoft.newproject.databinding.ActivityMainBinding;
import com.baidu.isoft.newproject.network.ApiService;
import com.baidu.isoft.newproject.network.NetWorkHelper;
import com.baidu.isoft.newproject.network.RxJavaHelper;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    ViewPager2 viewpager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        MainFunctionBean mainFunctionBean = new MainFunctionBean();
        mainFunctionBean.jokeField.set("笑话");
        mainFunctionBean.newsField.set("新闻");
        mainBinding.setMainFunction(mainFunctionBean);



        viewpager2 = findViewById(R.id.viewpager2);
        findViewById(R.id.joke_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, JokeActivity.class));
            }
        });
        findViewById(R.id.news_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, NewsActivity.class));
            }
        });

        viewpager2.setAdapter(new ViewPager2Adapter(this));







    }
}
