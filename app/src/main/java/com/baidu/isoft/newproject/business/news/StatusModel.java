
package com.baidu.isoft.newproject.business.news;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public class StatusModel extends ViewModel {


    public MutableLiveData<Double> a = new MutableLiveData<>();


    public MutableLiveData<Double> b = new MutableLiveData<>();


    public MutableLiveData<Float> c = new MutableLiveData<>();


    public MutableLiveData<Boolean> d = new MutableLiveData<>();




    public static StatusModel getInstance() {
        return StatusModelHolder.instance;
    }

    private static class StatusModelHolder{
        private static final StatusModel instance = new StatusModel();
    }




}
