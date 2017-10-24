package com.byjw.androidanimatedcards.Main.Contract;

import android.content.Context;

import com.byjw.androidanimatedcards.Adapter.Contract.MoviesAdapterContract;
import com.byjw.androidanimatedcards.SampleMoviesData;

/**
 * Created by jungwoon on 2017. 10. 24..
 */

public interface MainContract {

    interface View {
        void showToast(String text);
    }

    interface Presenter {

        void attachView(MainContract.View view);

        void detachView();

        void setMoviesAdapterModel(MoviesAdapterContract.Model moviesAdapterModel);

        void setMoviesAdapterView(MoviesAdapterContract.View moviesAdapterView);

        void setSampleMoviesData(SampleMoviesData sampleMoviesData);

        void loadItems(Context context, boolean isClear);

    }
}
