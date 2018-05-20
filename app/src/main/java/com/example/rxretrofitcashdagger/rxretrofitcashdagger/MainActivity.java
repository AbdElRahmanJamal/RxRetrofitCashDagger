package com.example.rxretrofitcashdagger.rxretrofitcashdagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.rxretrofitcashdagger.rxretrofitcashdagger.model.MovieInfo;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.model.MovieObject;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.viewmodel.MVVM;

import java.util.ArrayList;

import io.reactivex.functions.Consumer;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MVVM mvvm;
    DataRecycleViewAdapter dataRecycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataRecycleViewAdapter = new DataRecycleViewAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mvvm = new MVVM();
        getDataFromMVVM();

    }


    public void displayDataOnRecView(ArrayList<MovieInfo> movieInfos) {
        dataRecycleViewAdapter.setDataArrayList(movieInfos);
        recyclerView.setAdapter(dataRecycleViewAdapter);
        dataRecycleViewAdapter.notifyDataSetChanged();

    }

    public void getDataFromMVVM() {
        mvvm.fetchDataMVVM().subscribe(new Consumer<MovieObject>() {
            @Override
            public void accept(MovieObject userResponse) throws Exception {
                //       getView().updateList()
                Log.d("acceptFe: ", userResponse.getResults().size() + "");
                displayDataOnRecView(userResponse.getResults());
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
