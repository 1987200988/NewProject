/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject;

import android.content.Context;

public class ContextManager {


    private static Context mContext;

    public ContextManager() {
    }

    public static Context getContext() {

            return mContext;

    }

    public static void setContext(Context context) {
        mContext = context;
    }


}
