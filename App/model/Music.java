package com.example.Music.App.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Music {
    private int id;
    private String SongName;
    private String genre;
    private String artist;
    private Integer duration;

    public Music() {
    }

    public Music(@JsonProperty ("id") int id,
                 @JsonProperty ("SongName") String SongName,
                 @JsonProperty ("genre")  String genre,
                 @JsonProperty("artist") String artist,
                 @JsonProperty ("duration")Integer duration) {
        this.id = id;
        this.SongName = SongName;
        this.genre = genre;
        this.artist = artist;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String SongName) {
        this.SongName = SongName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Music [artist=" + artist + ", genre=" + genre + ", id=" + id + ", duration="
                + duration
                + ", SongName=" + SongName + "]";
    }


}
