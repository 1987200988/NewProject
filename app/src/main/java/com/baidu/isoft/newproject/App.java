/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject;

import android.app.Application;
import android.content.Context;
import androidx.multidex.MultiDex;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();



    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }
}
