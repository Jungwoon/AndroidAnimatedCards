package com.byjw.androidanimatedcards;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by jungwoon on 2017. 10. 23..
 */

public class MoviesAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater = null;

    MoviesAdapter(Context context, String[] list) {
        this.context = context;
        DataModel.movies = list;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return DataModel.movies.length;
    }

    @Override
    public Object getItem(int i) {
        return DataModel.movies.length;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if(view == null) {
            view = inflater.inflate(R.layout.card_item_template, null);
            holder = new ViewHolder();

            holder.cover = (ImageView) view.findViewById(R.id.img_cover);
            holder.background = (ImageView) view.findViewById(R.id.img_background);
            holder.movies = (TextView) view.findViewById(R.id.txt_title_details);
            holder.description = (TextView) view.findViewById(R.id.txt_movie_description);
            holder.releaseDate = (TextView) view.findViewById(R.id.txt_release_date);
            holder.blackLayer =  view.findViewById(R.id.view_black_layer);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        holder.movies.setText(DataModel.movies[i]);
        holder.description.setText(DataModel.description[i]);
        holder.releaseDate.setText(String.format("o %s", DataModel.releaseDate[i]));
        Glide.with(context).load(DataModel.cover[i]).into(holder.cover);
        Glide.with(context).load(DataModel.background[i]).into(holder.background);

        ObjectAnimator fade = ObjectAnimator.ofFloat(holder.blackLayer, View.ALPHA, 1f,.3f);
        fade.setDuration(1500);
        fade.setInterpolator(new LinearInterpolator());
        fade.start();


        return view;
    }

    private class ViewHolder {

        ImageView cover;
        ImageView background;
        TextView movies;
        TextView description;
        TextView releaseDate;
        View blackLayer;

    }
}
