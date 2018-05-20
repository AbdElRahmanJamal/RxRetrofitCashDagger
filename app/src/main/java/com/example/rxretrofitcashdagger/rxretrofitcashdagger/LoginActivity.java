package com.example.rxretrofitcashdagger.rxretrofitcashdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rxretrofitcashdagger.rxretrofitcashdagger.model.MovieInfo;
import com.example.rxretrofitcashdagger.rxretrofitcashdagger.mvp.LoginPresenter;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements LoginView {

    RecyclerView recyclerView;
    LoginPresenter loginPresenter;
    DataRecycleViewAdapter dataRecycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataRecycleViewAdapter = new DataRecycleViewAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loginPresenter = new LoginPresenter(this);
        loginPresenter.fetchDataMVP();

    }

    @Override
    public void displayDataOnRecView(ArrayList<MovieInfo> movieInfos) {
        dataRecycleViewAdapter.setDataArrayList(movieInfos);
        recyclerView.setAdapter(dataRecycleViewAdapter);
        dataRecycleViewAdapter.notifyDataSetChanged();

    }
}