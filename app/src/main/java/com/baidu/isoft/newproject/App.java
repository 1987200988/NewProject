/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject;

import java.util.List;

import com.baidu.isoft.newproject.util.FloatWindow.FloatWindow;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.multidex.MultiDex;

public class App extends Application {

    private boolean mIsForeground;
    private Activity mCurrentActivity;
    public static final String TAG = App.class.getSimpleName();
    private int mActivityCount;

    @Override
    public void onCreate() {
        super.onCreate();
        if (isMainProcess(this)) {
            ContextManager.setContext(this);
            registerActivityLifecycleCallbacks(lifecycleCallbacks);
        }

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);


    }

    private boolean isMainProcess(Context context) {
        String pkgName = context.getPackageName();
        int pid = Process.myPid();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> processesList = am.getRunningAppProcesses();
        if (null != processesList) {
            for (ActivityManager.RunningAppProcessInfo info : processesList) {
                if (null != info && info.pid == pid) {
                    return pkgName.equals(info.processName);
                }
            }
        }

        return false;
    }

    private ActivityLifecycleCallbacks lifecycleCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            mCurrentActivity = activity;
        }

        @Override
        public void onActivityStarted(Activity activity) {
            //            mCurrentActivity = activity;
            if (mActivityCount == 0) {
                mIsForeground = true;
            }
            mActivityCount++;
            Log.e(TAG, "onActivityStarted: "+mActivityCount +"isForeground"+mIsForeground );
        }

        @Override
        public void onActivityResumed(Activity activity) {
            if (needShow(activity)) {
                if (FloatWindow.get("one") != null) {
                    FloatWindow.get("one").show();
                }
            } else {
                if (FloatWindow.get("one") != null) {
                    FloatWindow.get("one").hide();

                }
            }

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {
            mActivityCount--;

            if (mActivityCount == 0) {
                mIsForeground = false;
                if (FloatWindow.get("one") != null) {
                    Log.e(TAG, "onActivityStoped:hide");
                    FloatWindow.get("one").hide();

                }
            }
            Log.e(TAG, "onActivityStopped: "+mActivityCount+"isForeground"+mIsForeground );

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    };

        private boolean needShow(Activity activity) {
            if (FloatWindow.B.mActivities == null) {
                return true;
            }
            for (Class a : FloatWindow.B.mActivities) {
                if (a.isInstance(activity)) {
                    return true;
                }
            }
            return false;
        }

}
