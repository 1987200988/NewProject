/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject;



public abstract class BaseModel {
    private int grpcType = -1;

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
