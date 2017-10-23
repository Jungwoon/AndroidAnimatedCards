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
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertview == null) {

            convertview = inflater.inflate(R.layout.card_item_template, null);
            holder = new ViewHolder();

            holder._cover = (ImageView) convertview.findViewById(R.id.img_cover_d);
            holder._background = (ImageView) convertview.findViewById(R.id.img_background);
            holder._movies = (TextView) convertview.findViewById(R.id.txt_movie_details);
            holder._plot = (TextView) convertview.findViewById(R.id.txt_plot_d);
            holder._releaseDate = (TextView) convertview.findViewById(R.id.txt_release_d);
            holder._vw_blayer =  convertview.findViewById(R.id.vw_blacklayer);

            convertview.setTag(holder);

        }
        else {
            holder = (ViewHolder) convertview.getTag();
        }


        holder._movies.setText(DataModel.movies[i]);
        holder._plot.setText(DataModel.plot[i]);
        holder._releaseDate.setText(String.format("o %s", DataModel.releaseDate[i]));
        //holder._cover.setImageResource(cover[i]);
        Glide.with(context).load(DataModel.cover[i]).into(holder._cover);
//        Picasso.with(context).load(DataModel.cover[i]).into(holder._cover);
        // holder._background.setImageResource(background[i]);
        Glide.with(context).load(DataModel.background[i]).into(holder._background);
//        Picasso.with(context).load(DataModel.background[i]).into(holder._background);


        ObjectAnimator fade = ObjectAnimator.ofFloat(holder._vw_blayer, View.ALPHA, 1f,.3f);
        fade.setDuration(1500);
        fade.setInterpolator(new LinearInterpolator());
        fade.start();


        return convertview;
    }

    public class ViewHolder {

        ImageView _cover;
        ImageView _background;
        TextView _movies;
        TextView _plot;
        TextView _releaseDate;
        View _vw_blayer;

    }
}
