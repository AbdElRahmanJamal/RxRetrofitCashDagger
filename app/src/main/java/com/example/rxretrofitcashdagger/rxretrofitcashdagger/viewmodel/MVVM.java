package com.example.rxretrofitcashdagger.rxretrofitcashdagger.viewmodel;

import android.util.Log;

import com.example.rxretrofitcashdagger.rxretrofitcashdagger.model.MovieInfo;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.model.MovieObject;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.NetWorkObjectCreation;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.ServiceApi;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MVVM {

    public MVVM() {
    }

    public Observable<MovieObject> fetchDataMVVM() {
        NetWorkObjectCreation netWorkService = new NetWorkObjectCreation();
        ServiceApi serviceApi = netWorkService.createNetWorkObject();
        return serviceApi.getTopRatedMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
