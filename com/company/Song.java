package com.company;

public class Song implements Comparable<Song> {

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

    @Override
    public boolean equals(Object aSong) {
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
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
