package com.example.rxretrofitcashdagger.rxretrofitcashdagger.network;

import com.example.rxretrofitcashdagger.rxretrofitcashdagger.model.MovieObject;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("top_rated?api_key=3c3d662f3dfecdd191da7642c1b1e2af")
    Observable<MovieObject> getTopRatedMovies();
}
