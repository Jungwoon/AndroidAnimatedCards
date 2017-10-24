package com.byjw.androidanimatedcards.Adapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;

import com.byjw.androidanimatedcards.Adapter.Contract.MoviesAdapterContract;
import com.byjw.androidanimatedcards.Listener.OnItemClickListener;
import com.byjw.androidanimatedcards.Main.DetailsActivity;
import com.byjw.androidanimatedcards.Util.Common;

import java.util.ArrayList;

/**
 * Created by jungwoon on 2017. 10. 23..
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> implements MoviesAdapterContract.Model, MoviesAdapterContract.View {

    private ArrayList<MoviesModel> moviesList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public MoviesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MoviesViewHolder(context, parent, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        if (holder == null) return;
        holder.onBind(moviesList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return moviesList != null ? moviesList.size() : 0;
    }

    @Override
    public void setOnClickListener(OnItemClickListener onItemClckListener) {
        this.onItemClickListener = onItemClckListener;
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void addItems(ArrayList<MoviesModel> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public void clearItem() {
        if (moviesList != null) moviesList.clear();
    }

    @Override
    public MoviesModel getItem(int position) {
        return moviesList.get(position);
    }
}
