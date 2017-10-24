package com.byjw.androidanimatedcards.Adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.byjw.androidanimatedcards.Listener.OnItemClickListener;
import com.byjw.androidanimatedcards.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jungwoon on 2017. 10. 23..
 */

class MoviesViewHolder extends RecyclerView.ViewHolder {

    private Context context;
    private OnItemClickListener onItemClickListener;

    @BindView(R.id.img_cover)
    ImageView cover;

    @BindView(R.id.img_background)
    ImageView background;

    @BindView(R.id.txt_title_details)
    TextView title;

    @BindView(R.id.txt_movie_description)
    TextView description;

    @BindView(R.id.txt_release_date)
    TextView releaseDate;

    @BindView(R.id.view_black_layer)
    View blackLayer;


    MoviesViewHolder(Context context, ViewGroup parent, OnItemClickListener onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.card_item_template, parent, false));
        ButterKnife.bind(this, itemView);

        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    void onBind(final MoviesModel moviesModel, final int position) {

        title.setText(moviesModel.getTitle());
        description.setText(moviesModel.getDescription());
        releaseDate.setText(String.format("o %s", moviesModel.getReleaseDate()));
        Glide.with(context).load(moviesModel.getCover()).into(cover);
        Glide.with(context).load(moviesModel.getBackground()).into(background);

        setFadeAnimation();

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClickListener(position, background);
                }
            }
        });
    }

    private void setFadeAnimation() {
        ObjectAnimator fade = ObjectAnimator.ofFloat(blackLayer, View.ALPHA, 1f, .3f);
        fade.setDuration(1500);
        fade.setInterpolator(new LinearInterpolator());
        fade.start();
    }
}

