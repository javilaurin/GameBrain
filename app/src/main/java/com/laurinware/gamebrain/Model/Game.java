package com.laurinware.gamebrain.Model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Game {

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("url")
    @Expose
    public String url;

    @SerializedName("summary")
    @Expose
    public String summary;

    @SerializedName("storyline")
    @Expose
    public String storyline;

    @SerializedName("developers")
    @Expose
    public List<Integer> developers = null;

    @SerializedName("publishers")
    @Expose
    public List<Integer> publishers = null;

    @SerializedName("category")
    @Expose
    public int category;

    @SerializedName("genres")
    @Expose
    public List<Genre> genres = null;

    @SerializedName("first_release_date")
    @Expose
    public int firstReleaseDate;

    /*
    @SerializedName("screenshots")
    @Expose
    public List<Screenshot> screenshots = null;

    @SerializedName("videos")
    @Expose
    public List<Video> videos = null;

    @SerializedName("cover")
    @Expose
    public Cover cover;

    @SerializedName("esrb")
    @Expose
    public Esrb esrb;

    @SerializedName("pegi")
    @Expose
    public Pegi pegi;

    @SerializedName("websites")
    @Expose
    public List<Website> websites = null;
*/
    /**
     * No args constructor for use in serialization
     */
    public Game() {
    }

    /**
     * @param id
     * @param name
     * @param url
     * @param summary
     * @param storyline
     * @param developers
     * @param publishers
     * @param category
     * @param genres
     * @param firstReleaseDate
     //* @param videos
     //* @param websites
     //* @param cover
     //* @param screenshots
     //* @param esrb
     //* @param pegi
     */
    public Game(int id, String name, String url, String summary, String storyline, List<Integer> developers,
                List<Integer> publishers, int category, List<Genre> genres, int firstReleaseDate/*,
                List<Screenshot> screenshots, List<Video> videos, Cover cover, Esrb esrb, Pegi pegi, List<Website> websites*/) {
        super();
        this.id = id;
        this.name = name;
        this.url = url;
        this.summary = summary;
        this.storyline = storyline;
        this.developers = developers;
        this.publishers = publishers;
        this.category = category;
        this.genres = genres;
        this.firstReleaseDate = firstReleaseDate;
        /*
        this.screenshots = screenshots;
        this.videos = videos;
        this.cover = cover;
        this.esrb = esrb;
        this.pegi = pegi;
        this.websites = websites;
        */
    }

}
