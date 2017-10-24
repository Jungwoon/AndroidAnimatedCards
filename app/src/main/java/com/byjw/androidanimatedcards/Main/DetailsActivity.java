package com.byjw.androidanimatedcards.Main;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.byjw.androidanimatedcards.R;
import com.byjw.androidanimatedcards.Util.Common;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.card_view)
    CardView cardView;

    @BindView(R.id.img_cover_details)
    ImageView cover;

    @BindView(R.id.txt_title_details)
    TextView title;

    @BindView(R.id.img_background_details)
    ImageView background;

    @BindView(R.id.txt_description_details)
    TextView description;

    @BindView(R.id.layout)
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        setCardSwayAnimation();
        setResources();

    }

    private void setResources() {
        Intent intent = getIntent();

        title.setText(intent.getStringExtra(Common.TITLE));
        description.setText(intent.getStringExtra(Common.DESCRIPTION));

        Glide.with(this).load(intent.getIntExtra(Common.BACKGROUND, 1)).into(background);
        Glide.with(this).load(intent.getIntExtra(Common.COVER, 1)).into(cover);
        Glide.with(this)
            .asBitmap()
            .load(intent.getIntExtra(Common.BACKGROUND, 1))
            .apply(new RequestOptions().centerCrop())
            .into(new SimpleTarget<Bitmap>(getDisplayMetrics().widthPixels, getDisplayMetrics().heightPixels) {
                @Override
                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                    Drawable drawable = new BitmapDrawable(resource);
                    layout.setBackground(drawable);
                }
        });
    }

    @NonNull
    private DisplayMetrics getDisplayMetrics() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    private void setCardSwayAnimation() {

        AnimatorSet animationSet = new AnimatorSet();

        //Translating Details_Card in Y Scale
        ObjectAnimator card_y = ObjectAnimator.ofFloat(cardView, View.TRANSLATION_Y, 70);
        card_y.setDuration(2500);
        card_y.setRepeatMode(ValueAnimator.REVERSE);
        card_y.setRepeatCount(ValueAnimator.INFINITE);
        card_y.setInterpolator(new LinearInterpolator());

        //Translating Movie_Cover in Y Scale
        ObjectAnimator cover_y = ObjectAnimator.ofFloat(cover, View.TRANSLATION_Y, 30);
        cover_y.setDuration(3000);
        cover_y.setRepeatMode(ValueAnimator.REVERSE);
        cover_y.setRepeatCount(ValueAnimator.INFINITE);
        cover_y.setInterpolator(new LinearInterpolator());

        animationSet.playTogether(card_y, cover_y);
        animationSet.start();
    }
}
