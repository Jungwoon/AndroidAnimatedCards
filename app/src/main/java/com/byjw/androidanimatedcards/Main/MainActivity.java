package com.byjw.androidanimatedcards.Main;

import android.app.ActivityOptions;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;

import com.byjw.androidanimatedcards.Adapter.MoviesAdapter;
import com.byjw.androidanimatedcards.Main.Contract.MainContract;
import com.byjw.androidanimatedcards.Main.Contract.MainPresenter;
import com.byjw.androidanimatedcards.R;
import com.byjw.androidanimatedcards.SampleMoviesData;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        MoviesAdapter moviesAdapter = new MoviesAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(moviesAdapter);

        mainPresenter = new MainPresenter(this, this);
        mainPresenter.attachView(MainActivity.this);
        mainPresenter.setMoviesAdapterModel(moviesAdapter);
        mainPresenter.setMoviesAdapterView(moviesAdapter);
        mainPresenter.setSampleMoviesData(SampleMoviesData.getInstance());
        mainPresenter.loadItems(this, false);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mainPresenter.detachView();
    }

    @Override
    public void showToast(String text) {

    }
}
