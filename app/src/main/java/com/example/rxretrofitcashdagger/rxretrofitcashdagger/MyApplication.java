package com.example.rxretrofitcashdagger.rxretrofitcashdagger;

import android.app.Application;
import android.content.Context;

import com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.component.DaggerRetrofitComponent;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.component.RetrofitComponent;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.module.ApplicationModule;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.module.RetrofitModule;

public class MyApplication extends Application {

    private static RetrofitComponent mApiComponent;
    private static Context context;
    private String BASE_URL = "https://api.themoviedb.org/3/movie/";

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        mApiComponent = DaggerRetrofitComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .retrofitModule(new RetrofitModule(BASE_URL))
                .build();
    }

    public static RetrofitComponent getApiComponent() {
        return mApiComponent;
    }

    public static Context getContext() {
        return context;
    }
}