/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject.network;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxJavaHelper {


    public static ObservableTransformer handleObservable() {
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable upstream) {
                return upstream.subscribeOn(Schedulers.io()).
                        observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static FlowableTransformer handleFlowable() {
        return new FlowableTransformer() {
            @Override
            public Publisher apply(Flowable upstream) {
                return upstream.subscribeOn(Schedulers.io()).
                        observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static SingleTransformer handleSingle() {
        //                upstream -> upstream
        //                .subscribeOn(Schedulers.io())
        //                .observeOn(AndroidSchedulers.mainThread());
        return new SingleTransformer() {
            @Override
            public SingleSource apply(Single upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };

    }







}
