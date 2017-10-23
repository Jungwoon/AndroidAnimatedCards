package com.byjw.androidanimatedcards;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        Intent intent = getIntent();

        //These are lines helping Details_Card To Animate
        //===============================================
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

        Glide.with(this).load(intent.getIntExtra(DataModel.BACKGROUND, 1)).into(background);
        Glide.with(this).load(intent.getIntExtra(DataModel.COVER, 1)).into(cover);
        title.setText(intent.getStringExtra(DataModel.TITLE));
        description.setText(intent.getStringExtra(DataModel.DESCRIPTION));

    }
}
