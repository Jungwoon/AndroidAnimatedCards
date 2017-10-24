package com.byjw.androidanimatedcards;

import android.content.Context;

import com.byjw.androidanimatedcards.Adapter.MoviesModel;

import java.util.ArrayList;

/**
 * Created by jungwoon on 2017. 10. 24..
 */

public class SampleMoviesData {
    private static final SampleMoviesData ourInstance = new SampleMoviesData();

    public static SampleMoviesData getInstance() {
        return ourInstance;
    }

    private SampleMoviesData() {}

    public ArrayList<MoviesModel> getItems(Context context, int size) {
        ArrayList<MoviesModel> items = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            items.add(new MoviesModel(cover[i], background[i], titles[i], description[i], releaseDate[i]));
        }

        return items;
    }

    private String[] titles = {
            "Leave Company",
            "Geostorm",
            "I am Heath Ledger I am",
            "Kinsman",
            "Windriver"
    };

    private String[] description = {
            "It's been nearly two years since Superman's (Henry Cavill) colossal battle with Zod (Michael Shannon) devastated the city of Metropolis.",
            "Political pressure mounts to install a system of accountability when the actions of the Avengers lead to collateral damage. The new status quo deeply divides members of the team.",
            "Worshiped as a god since the dawn of civilization, the immortal Apocalypse (Oscar Isaac) becomes the first and most powerful mutant. Awakening after thousands of years",
            "Raised by a family of wolves since birth, Mowgli (Neel Sethi) must leave the only home he's ever known when the fearsome tiger Shere Khan (Idris Elba) unleashes his mighty roar",
            "When Tony Stark (Robert Downey Jr.) jump-starts a dormant peacekeeping program, things go terribly awry, forcing him, Thor (Chris Hemsworth), the Incredible Hulk (Mark Ruffalo) and the rest of the Avengers to reassemble."
    };

    private String[] releaseDate = {
            "Release date: March 25, 2016",
            "Release date: May 6, 2016",
            "Release date: May 27, 2016",
            "Release date: April 15, 2016",
            "Release date: May 1, 2015"
    };


    private int cover[] = {
            R.drawable.exit,
            R.drawable.geostorm,
            R.drawable.iam,
            R.drawable.kingsman,
            R.drawable.windriver
    };

    private int background[] = {
            R.drawable.exit,
            R.drawable.geostorm,
            R.drawable.iam,
            R.drawable.kingsman,
            R.drawable.windriver
    };
}
