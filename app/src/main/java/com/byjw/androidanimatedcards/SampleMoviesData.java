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
            "Kinsman: The Golden Circle",
            "Jigsaw",
            "Blade Runner 2049",
            "It",
            "American Made",
            "The Foreigner",
            "The LEGO Ninjago Movie"
    };

    private String[] description = {
            "When their headquarters are destroyed and the world is held hostage, the Kingsman's journey leads them to the discovery of an allied spy organization in the US. These two elite secret organizations must band together to defeat a common enemy.",
            "Bodies are turning up around the city, each having met a uniquely gruesome demise. As the investigation proceeds, evidence points to one suspect: John Kramer, the man known as Jigsaw, who has been dead for ten years.",
            "A young blade runner's discovery of a long-buried secret leads him to track down former blade runner Rick Deckard, who's been missing for thirty years.",
            "A group of bullied kids band together when a shapeshifting demon, taking the appearance of a clown, begins hunting children.",
            "The story of Barry Seal, an American pilot who became a drug-runner for the CIA in the 1980s in a clandestine operation that would be exposed as the Iran-Contra Affair.",
            "A humble businessman with a buried past seeks justice when his daughter is killed in an act of terrorism. A cat-and-mouse conflict ensues with a government official, whose past may hold clues to the killers' identities.",
            "Shunned by everyone for being the son of an evil warlord, a teenager seeks to defeat him with the help of his fellow ninjas."
    };

    private String[] releaseDate = {
            "Release date: Sep 27, 2017",
            "Release date: Oct 13, 2017",
            "Release date: Oct 12, 2017",
            "Release date: Sep 07, 2017",
            "Release date: Sep 14, 2017",
            "Release date: Oct 13, 2017",
            "Release date: Sep 28, 2017"
    };


    private int cover[] = {
            R.drawable.kingsman,
            R.drawable.jigsaw,
            R.drawable.bladerunner,
            R.drawable.it,
            R.drawable.americanmade,
            R.drawable.foriener,
            R.drawable.ninjago
    };

    private int background[] = {
            R.drawable.kingsman,
            R.drawable.jigsaw,
            R.drawable.bladerunner,
            R.drawable.it,
            R.drawable.americanmade,
            R.drawable.foriener,
            R.drawable.ninjago
    };
}
