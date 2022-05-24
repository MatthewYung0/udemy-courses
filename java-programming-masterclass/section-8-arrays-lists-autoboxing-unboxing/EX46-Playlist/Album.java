import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    public ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String songName, double duration) {
        Song song = findSong(songName);
        if (song == null) {
            Song newSong = new Song(songName, duration);
            return songs.add(newSong);
        }
        return false;
    }

    public boolean addToPlayList(int track, LinkedList<Song> playlist) {
        int trackPosition = 0;
        Iterator<Song> songIterator = playlist.iterator();
        while (songIterator.hasNext()) {
            Song song = songIterator.next();
            if (trackPosition == track) {
                playlist.add(trackPosition, song);
                System.out.println(song.getTitle());
                return true;
            }
            trackPosition++;
        }
        return false;
    }

//    public boolean addToPlaylist(String songName, LinkedList<Song> playlist) {
//
//    }

    private Song findSong(String songName) {
        for (Song song : songs) {
            if (song.getTitle().equals(songName)) {
                return song;
            }
        }
        return null;
    }

}
