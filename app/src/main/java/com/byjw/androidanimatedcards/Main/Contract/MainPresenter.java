package com.byjw.androidanimatedcards.Main.Contract;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.byjw.androidanimatedcards.Adapter.Contract.MoviesAdapterContract;
import com.byjw.androidanimatedcards.Adapter.MoviesModel;
import com.byjw.androidanimatedcards.Listener.OnItemClickListener;
import com.byjw.androidanimatedcards.Main.DetailsActivity;
import com.byjw.androidanimatedcards.Main.MainActivity;
import com.byjw.androidanimatedcards.SampleMoviesData;
import com.byjw.androidanimatedcards.Util.Common;

import java.util.ArrayList;

/**
 * Created by jungwoon on 2017. 10. 24..
 */

public class MainPresenter implements MainContract.Presenter, OnItemClickListener {

    private MainContract.View view;
    private MoviesAdapterContract.Model moviesAdapterModel;
    private MoviesAdapterContract.View moviesAdapterView;

    private SampleMoviesData sampleMoviesData;

    private Context context;
    private Activity activity;

    public MainPresenter(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void setMoviesAdapterModel(MoviesAdapterContract.Model moviesAdapterModel) {
        this.moviesAdapterModel = moviesAdapterModel;
    }

    @Override
    public void setMoviesAdapterView(MoviesAdapterContract.View moviesAdapterView) {
        this.moviesAdapterView = moviesAdapterView;
        this.moviesAdapterView.setOnClickListener(this);
    }

    @Override
    public void setSampleMoviesData(SampleMoviesData sampleMoviesData) {
        this.sampleMoviesData = sampleMoviesData;
    }

    @Override
    public void loadItems(Context context, boolean isClear) {

        ArrayList<MoviesModel> items = sampleMoviesData.getItems(context, 4);

        if (isClear) moviesAdapterModel.clearItem();

        moviesAdapterModel.addItems(items);
        moviesAdapterView.notifyAdapter();
    }

    @Override
    public void onClickListener(int position, View view) {
        MoviesModel movieItem = moviesAdapterModel.getItem(position);

        Bundle bundle = ActivityOptions
                .makeSceneTransitionAnimation(activity, Pair.create(view, "selectedMovie"))
                .toBundle();

        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(Common.BACKGROUND, movieItem.getBackground());
        intent.putExtra(Common.COVER, movieItem.getCover());
        intent.putExtra(Common.TITLE, movieItem.getTitle());
        intent.putExtra(Common.DESCRIPTION, movieItem.getDescription());
        context.startActivity(intent, bundle);

    }

    @Override
    public void onLongClickListener() {

    }
}
