package com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module

public class ApplicationModule {
    private Context mContext;

    public ApplicationModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Singleton
    Context provideApplication() {
        return mContext;
    }
}

