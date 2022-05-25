import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

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
        Iterator<Song> songIterator = songs.iterator();
        while (track >= 0 && songIterator.hasNext()) {
            Song song = songIterator.next();
            if (trackPosition == track - 1) {
                playlist.add(song);
                return true;
            }
            trackPosition++;
        }
        return false;
    }

    public boolean addToPlayList(String songName, LinkedList<Song> playlist) {
        Iterator<Song> songIterator = songs.iterator();
        while (songIterator.hasNext()) {
            Song song = songIterator.next();
            if (songName.equals(song.getTitle())) {
                playlist.add(song);
                System.out.println(song.getTitle());
                return true;
            }
        }
        return false;
    }

    private Song findSong(String songName) {
        for (Song song : songs) {
            if (song.getTitle().equals(songName)) {
                return song;
            }
        }
        return null;
    }

}
