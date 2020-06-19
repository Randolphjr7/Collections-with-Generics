package com.company;

public class Song {

    String title;
    String artist;
    String rating;
    String bpm;

    Song(String t, String a, String r, String b) {
        title  = t;
        artist = a;
        rating = r;
        bpm    = b;
    }

    String getTitle() {
        return title;
    }

    String getArtist() {
        return artist;
    }

    String getRating() {
        return rating;
    }

    String getBpm() {
        return bpm;
    }

    public String toString() {
        return title;
    }
}