package pao.lab10.iteratorSpliterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

class Playlist {
    private List<Song> songs;

    public Playlist(String s) {
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public Spliterator<Song> getSongsSpliterator() {
        return songs.spliterator();
    }
}

class Song {
    private String title;

    public Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class PlaylistSearcher {
    public static List<Song> searchPlaylist(Playlist playlist, String keyword) {
        List<Song> matchingSongs = new ArrayList<>();

        Spliterator<Song> spliterator = playlist.getSongsSpliterator();

        spliterator.forEachRemaining(new Consumer<Song>() {
            @Override
            public void accept(Song song) {
                if (song.getTitle().contains(keyword)) {
                    matchingSongs.add(song);
                }
            }
        });

        return matchingSongs;
    }

    public static void main(String[] args) {
        // Create some songs
        Song song1 = new Song("Take On Me");
        Song song2 = new Song("Sweet Child O' Mine");
        Song song3 = new Song("Don't Stop Believin'");
        Song song4 = new Song("Bohemian Rhapsody");
        Song song5 = new Song("Stairway to Heaven");

        // Create some playlists
        Playlist playlist1 = new Playlist("80s Hits");
        playlist1.addSong(song1);
        playlist1.addSong(song3);

        Playlist playlist2 = new Playlist("Rock Classics");
        playlist2.addSong(song2);
        playlist2.addSong(song4);
        playlist2.addSong(song5);

        // Search for songs in the playlists
        List<Song> results1 = searchPlaylist( playlist1, "Child");
        List<Song> results2 = searchPlaylist( playlist2, "Child");
        // Print the results
        System.out.println("Search results for playlist 1:");
        for (Song song : results1) {
            System.out.println(song.getTitle());
        }
        System.out.println();

        System.out.println("Search results for playlist 2:");
        for (Song song : results2) {
            System.out.println(song.getTitle());
        }
    }
}