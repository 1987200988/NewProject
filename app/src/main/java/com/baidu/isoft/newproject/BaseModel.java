/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject;

/**
 * Created by shendonghui on 2018/1/15.
 * <p>
 * 将rpc type封装在这里 这个以后有时间做
 */

public abstract class BaseModel {
    private int grpcType = -1;
    public static final int FETCH_SECTION_MSG = 1;
    public static final int START_ROUTING = 2;
    public static final int LAUNCH = 3;
    public static final int DISENGAGE = 4;
    public static final int STOPANDGO = 5;
    public static final int CHECK_POSITION_STATUS = 6;
    public static final int AUTO_PARKING = 7;
    public static final int AUTO_OUT_GARAGE = 8;
    public static final int FETCH_SAFECHECK_RESULT = 9;
    public static final int SWITCH_DOOR = 10;
    public static final int SWITCH_EMERGENCYLAMP = 11;
    public static final int SWITCH_FRONTLAMP = 12;
    public static final int SWITCH_HEADLIGHTS = 13;
    public static final int SWITCH_COURTESYLAMP = 14;
    public static final int TRIGGER_ALARMHORN = 15;
    public static final int TRIGGER_EMERGENCYSTOP = 16;
    public static final int NOTI_AIRCONDITION = 17;
    public static final int SET_HUDINFO = 18;
    public static final int OTA = 19;
    public static final int FETCH_COLLECT_DATA_MSG = 20;
    public static final int NOTI_WORKING_STATE = 21;
    public static final int CHECK_CALIBRATION_VALIDITY = 22;
    public static final int DOWNLOAD_INFO = 23;
    public static final int FETCH_PREPROCTASK_STATUS = 24;
    public static final int SHUTDOWN_SYSTEM = 25;
    public static final int TRANSFER_SYSTEM_CONTROL = 26;
    public static final int CHECK_PARKING_RELATION = 27;
    public static final int PRE_ROUTING = 28;
    public static final int DISENGAGE_FEEDBACK = 29;
    public static final int COARSECAMERA_VALIDITY = 30;
    public static final int LIDARIMU_VALIDITY = 31;
    // LauncherService
    public static final int GETWORKERS = 32;
    public static final int CONTROLWORKERS = 33;
    public static final int MOVELOGSYNC = 34;
    public static final int OPENAPI = 35;
    public static final int TRIGGER_PLAY_RECORD = 36;
    public static final int TRIGGERJOYSTICKAUTH = 38;
    // latest is 35
    public static final int HEART_BEAT = 37;

    public static final int SAMPLE = 100;
    public static final int ERROR = 101;

    public BaseModel(int grpcType) {
        this.grpcType = grpcType;
    }

    private void setGrpcType(int grpcType) {
        this.grpcType = grpcType;
    }

    public int getGrpcType() {
        return grpcType;
    }

//    public Observable<BaseModel> perform() {
//        Observable observable = Observable.create(new ObservableOnSubscribe<BaseModel>() {
//            @Override
//            public void subscribe(ObservableEmitter<BaseModel> e) throws Exception {
//                if (!e.isDisposed()) {
//                    e.onNext(BaseModel.this);
//                    e.onComplete();
//                }
//            }
//        }).map(new Function<BaseModel, BaseModel>() {
//            @Override
//            public BaseModel apply(BaseModel rq) throws Exception {
//                HMIGrpcServiceGrpc.HMIGrpcServiceBlockingStub stub =
//                        HMIGrpcServiceGrpc.newBlockingStub(DriveModule.getInstance().getManagedChannel())
//                                .withDeadlineAfter(6000, TimeUnit.MILLISECONDS);
//                return DriveModule.getInstance().grpc(stub, rq);
//            }
//        }).subscribeOn(Schedulers.io());
//
//        return observable;
//    }
//
//    public Observable<BaseModel> performLongDeadLine() {
//        Observable observable = Observable.create(new ObservableOnSubscribe<BaseModel>() {
//            @Override
//            public void subscribe(ObservableEmitter<BaseModel> e) throws Exception {
//                if (!e.isDisposed()) {
//                    e.onNext(BaseModel.this);
//                    e.onComplete();
//                }
//            }
//        }).map(new Function<BaseModel, BaseModel>() {
//            @Override
//            public BaseModel apply(BaseModel rq) throws Exception {
//                HMIGrpcServiceGrpc.HMIGrpcServiceBlockingStub stub =
//                        HMIGrpcServiceGrpc.newBlockingStub(DriveModule.getInstance().getManagedChannel())
//                                .withDeadlineAfter(23000, TimeUnit.MILLISECONDS);
//                return DriveModule.getInstance().grpc(stub, rq);
//            }
//        }).subscribeOn(Schedulers.io());
//
//        return observable;
//    }
//
//    /**
//     * InspectorServiceGrpc GRPC逻辑封装
//     *
//     * @return
//     */
//    public Observable<BaseModel> inspectorPerform(int milliseconds) {
//        Observable observable = Observable.create(new ObservableOnSubscribe<BaseModel>() {
//            @Override
//            public void subscribe(ObservableEmitter<BaseModel> e) throws Exception {
//                if (!e.isDisposed()) {
//                    e.onNext(BaseModel.this);
//                    e.onComplete();
//                }
//            }
//        }).map(new Function<BaseModel, BaseModel>() {
//            @Override
//            public BaseModel apply(BaseModel rq) throws Exception {
//                InspectorServiceGrpc.InspectorServiceBlockingStub stub =
//                        InspectorServiceGrpc.newBlockingStub(InspectorModule.getInstance().getManagedChannel())
//                                .withDeadlineAfter(milliseconds, TimeUnit.MILLISECONDS);
//                return InspectorModule.getInstance().grpc(stub, rq);
//            }
//        }).subscribeOn(Schedulers.io());
//
//        return observable;
//    }
//
//    /**
//     * LauncherService GRPC逻辑封装
//     *
//     * @return
//     */
//    public Observable<BaseModel> launcherPerform(int milliseconds) {
//        Observable observable = Observable.create(new ObservableOnSubscribe<BaseModel>() {
//            @Override
//            public void subscribe(ObservableEmitter<BaseModel> e) throws Exception {
//                if (!e.isDisposed()) {
//                    e.onNext(BaseModel.this);
//                    e.onComplete();
//                }
//            }
//        }).map(new Function<BaseModel, BaseModel>() {
//            @Override
//            public BaseModel apply(BaseModel rq) throws Exception {
//                LauncherServiceGrpc.LauncherServiceBlockingStub stub =
//                        LauncherServiceGrpc.newBlockingStub(LauncherModule.getInstance().getManagedChannel())
//                                .withDeadlineAfter(milliseconds, TimeUnit.MILLISECONDS);
//                return LauncherModule.getInstance().grpc(stub, rq);
//            }
//        }).subscribeOn(Schedulers.io());
//
//        return observable;
//    }
//
//
//    public Observable<BaseModel> delay(int milliseconds) {
//        HLog.d("delay 0");
//        Observable observable = Observable.create(new ObservableOnSubscribe<BaseModel>() {
//            @Override
//            public void subscribe(ObservableEmitter<BaseModel> e) throws Exception {
//                if (!e.isDisposed()) {
//                    e.onNext(BaseModel.this);
//                    e.onComplete();
//                }
//            }
//        }).delay(milliseconds, TimeUnit.MILLISECONDS).map(new Function<BaseModel, BaseModel>() {
//            @Override
//            public BaseModel apply(BaseModel rq) throws Exception {
//                HLog.d("delay 1");
//                HMIGrpcServiceGrpc.HMIGrpcServiceBlockingStub stub =
//                        HMIGrpcServiceGrpc.newBlockingStub(DriveModule.getInstance().getManagedChannel())
//                                .withDeadlineAfter(6000, TimeUnit.MILLISECONDS);
//
//                return DriveModule.getInstance().grpc(stub, rq);
//            }
//        }).subscribeOn(Schedulers.io());
//        HLog.d("delay 2");
//
//        return observable;
//    }

}
