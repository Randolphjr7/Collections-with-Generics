package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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



    // load the file & print song list
    public void go() {
        getSongs();
        Collections.sort(songList);
        System.out.println(songList);

        // instance of the Comprartor inner class
        ArtistCompare artistCompare  = new ArtistCompare();
        // if you pass a Comparator to the sort method, the sort order is determined by the Comparator
        // rather than the element's own compareTo() method.
        Collections.sort(songList, artistCompare);

        System.out.println(songList);
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
