/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject.business.news;

import com.baidu.isoft.newproject.R;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        //下面为android封装好的单例也可以自己封装
        StatusModel statusModel = ViewModelProviders.of(this).get(StatusModel.class);

        statusModel.a.observe(this,new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {


            }
        });

//        statusModel.getInstance().a.observe(this, new Observer<Double>() {
//            @Override
//            public void onChanged(Double aDouble) {
//
//            }
//        });

    }
}
