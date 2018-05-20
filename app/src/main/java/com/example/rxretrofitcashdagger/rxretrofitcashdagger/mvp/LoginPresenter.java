package com.example.rxretrofitcashdagger.rxretrofitcashdagger.mvp;

import android.util.Log;

import com.example.rxretrofitcashdagger.rxretrofitcashdagger.LoginView;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.model.MovieObject;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.NetWorkObjectCreation;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.network.ServiceApi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter {
    LoginView context;

    public LoginPresenter(LoginView context) {
        this.context = context;
    }

    public void fetchDataMVP() {
        NetWorkObjectCreation netWorkService = new NetWorkObjectCreation();
        ServiceApi serviceApi = netWorkService.createNetWorkObject();
        serviceApi.getTopRatedMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<MovieObject>() {
                    @Override
                    public void accept(MovieObject userResponse) throws Exception {

                        context.displayDataOnRecView(userResponse.getResults());
                        Log.d("acceptFe: ", userResponse.getResults().size() + "");

                        //TODO:update ui
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("acceptFe: ", throwable.getLocalizedMessage());
                        //TODO:Update Ui
                    }
                });

    }
}
