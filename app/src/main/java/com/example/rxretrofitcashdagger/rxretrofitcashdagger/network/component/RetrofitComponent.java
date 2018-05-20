package com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.component;

import com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.NetWorkObjectCreation;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.module.ApplicationModule;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.module.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {ApplicationModule.class, RetrofitModule.class})
public interface RetrofitComponent {
    Retrofit provideRetrofitModule();

    void inject(NetWorkObjectCreation netWorkObjectCreation);


}