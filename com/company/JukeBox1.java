package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;


public class JukeBox1 {

    // store the song titles in an array list
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {

        // start
        new JukeBox1().go();
    }

    // inner class that implements Comparator
    // type parameter matches the type we're going to compare - in this case song objects
    class ArtistCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            // let the String variables do the actual comparison, since
            // Strings already know how to alphabetize themselves
            return one.getArtist().compareTo(two.getArtist());
        }
    }

    // inner class that implements Comparator
    // type parameter matches the type we're going to compare
    class BpmCompare implements Comparator<Song> {
        // compare beats per minute
        public int compare(Song one, Song two) {
            int oneBpm = Integer.parseInt(one.bpm);
            int twoBpm = Integer.parseInt(two.bpm);

            if(oneBpm < twoBpm)
                return 1;
            if(oneBpm > twoBpm)
                return -1;
            else
                return 0;
        }
    }



    // load the file & print song list
    public void go() {

        getSongs();

        // before any sorting
        System.out.println("\nSonglist without any sorting:");
        System.out.println(songList);

        // sorts songs by title
        System.out.println("\nSonglist sorted by Title");
        Collections.sort(songList);
        System.out.println(songList);

        // instance of the Comparator inner class
        ArtistCompare artistCompare  = new ArtistCompare();
        // if you pass a Comparator to the sort method, the sort order is determined by the Comparator
        // rather than the element's own compareTo() method.
        System.out.println("\nSonglist sorted by Artist");
        Collections.sort(songList, artistCompare);
        System.out.println(songList);

        // instance of Bpm Comparator inner class
        BpmCompare bpmCompare = new BpmCompare();
        System.out.println("\nSonglist sorted by BPM");
        Collections.sort(songList, bpmCompare);
        System.out.println(songList);

        // SET - Collections that do no allow duplicates
        HashSet<Song> songSet = new HashSet<Song>(); // a new HashSet parameterized to hold songs
        // HashSet has a simple addAll() method that can take another collection and use it to populate
        // the HashSet. It's the same as if we added each song one at a time (except much simpler)
        songSet.addAll(songList);
        System.out.println("\nHashSet Does Not Allow Duplicates");
        System.out.println(songSet);
    }

    // read the file & call the addSong() method for each line
    void getSongs() {
        try {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    // method breaks the line into two tokens using the split method
    void addSong(String linetoParse) {
        String[] tokens = linetoParse.split("/");

        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }


}
