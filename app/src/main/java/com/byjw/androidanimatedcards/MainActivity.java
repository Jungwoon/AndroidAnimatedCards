package com.byjw.androidanimatedcards;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        MoviesAdapter moviesAdapter = new MoviesAdapter(MainActivity.this, DataModel.movies);
        listView.setAdapter(moviesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //We are passing Bundle to activity, these lines will animate when we laucnh activity
                Bundle bundle = ActivityOptions
                        .makeSceneTransitionAnimation(MainActivity.this, Pair.create(view, "selectedMovie"))
                        .toBundle();

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(DataModel.BACKGROUND, DataModel.background[i]);
                intent.putExtra(DataModel.COVER, DataModel.cover[i]);
                intent.putExtra(DataModel.TITLE, DataModel.movies[i]);
                intent.putExtra(DataModel.DESCRIPTION, DataModel.description[i]);
                startActivity(intent, bundle);

            }
        });
    }
}
