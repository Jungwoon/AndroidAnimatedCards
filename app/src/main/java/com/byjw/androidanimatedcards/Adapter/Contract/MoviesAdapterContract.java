package com.byjw.androidanimatedcards.Adapter.Contract;

import com.byjw.androidanimatedcards.Listener.OnItemClickListener;
import com.byjw.androidanimatedcards.Adapter.MoviesModel;

import java.util.ArrayList;

/**
 * Created by jungwoon on 2017. 10. 24..
 */

public interface MoviesAdapterContract {

    interface View {

        void setOnClickListener(OnItemClickListener onItemClickListener);

        void notifyAdapter();

    }

    interface Model {

        void addItems(ArrayList<MoviesModel> moviesList);

        void clearItem();

        MoviesModel getItem(int position);

    }
}
