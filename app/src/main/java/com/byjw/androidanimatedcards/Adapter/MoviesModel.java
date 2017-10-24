package com.byjw.androidanimatedcards.Adapter;

/**
 * Created by jungwoon on 2017. 10. 24..
 */

public class MoviesModel {

    private int cover;
    private int background;
    private String title;
    private String description;
    private String releaseDate;

    public MoviesModel(int cover, int background, String title, String description, String releaseDate) {
        this.cover = cover;
        this.background = background;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
