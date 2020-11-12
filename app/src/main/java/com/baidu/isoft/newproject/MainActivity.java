/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    ViewPager2 viewpager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
//        MainFunctionBean mainFunctionBean = new MainFunctionBean();
//        mainFunctionBean.jokeField.set("笑话");
//        mainFunctionBean.newsField.set("新闻");
//        mainBinding.setMainFunction(mainFunctionBean);
////abcfffabcwoshimasterhahahah
//        //woshi shui
//
//
//        viewpager2 = findViewById(R.id.viewpager2);
//        findViewById(R.id.joke_activity).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MainActivity.this.startActivity(new Intent(MainActivity.this, JokeActivity.class));
//            }
//        });
//        findViewById(R.id.news_activity).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MainActivity.this.startActivity(new Intent(MainActivity.this, NewsActivity.class));
//            }
//        });
//
//        FloatWindowManager.getInstance().show();
//
//
//        viewpager2.setAdapter(new ViewPager2Adapter(this));
//
//        final long totalTime = 10;
//
//        Observable.interval(1, TimeUnit.SECONDS)
//                .map(new Function<Long, Long>() {
//
//                    @Override
//                    public Long apply(Long aLong) throws Exception {
//                        Log.e(TAG, "apply: "+aLong );
//                        return  totalTime - aLong;
//                    }
//                }).take(totalTime+1)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        Log.e(TAG, "accept: "+aLong );
//                    }
//                });
//
//
//
//
    }
}
