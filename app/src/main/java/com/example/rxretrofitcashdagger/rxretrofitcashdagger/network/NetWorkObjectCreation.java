package com.example.rxretrofitcashdagger.rxretrofitcashdagger.network;

import com.example.rxretrofitcashdagger.rxretrofitcashdagger.MyApplication;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.component.DaggerRetrofitComponent;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.component.RetrofitComponent;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.module.RetrofitModule;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class NetWorkObjectCreation {
    @Inject
    Retrofit retrofit;

    public ServiceApi createNetWorkObject() {
        MyApplication.getApiComponent().inject(this);
        return retrofit.create(ServiceApi.class);

    }
}