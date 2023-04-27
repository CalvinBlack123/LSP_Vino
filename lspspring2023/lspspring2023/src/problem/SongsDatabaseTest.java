package howard.edu.lsp.exam.problem;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class SongsDatabaseTest {

    private SongsDatabase database;

    @Before
    public void setUp() {
        database = new SongsDatabase();
    }

    @Test
    public void testAddSong() {
        database.addSong("Pop", "Song 1");
        Set<String> popSongs = database.getSongs("Pop");
        assertTrue(popSongs.contains("Song 1"));
        assertEquals(1, popSongs.size());

        database.addSong("Pop", "Song 2");
        popSongs = database.getSongs("Pop");
        assertTrue(popSongs.contains("Song 1"));
        assertTrue(popSongs.contains("Song 2"));
        assertEquals(2, popSongs.size());

        database.addSong("Rock", "Song 3");
        Set<String> rockSongs = database.getSongs("Rock");
        assertTrue(rockSongs.contains("Song 3"));
        assertEquals(1, rockSongs.size());
    }

    @Test
    public void testGetSongs() {
        database.addSong("Pop", "Song 1");
        database.addSong("Pop", "Song 2");
        database.addSong("Rock", "Song 3");

        Set<String> popSongs = database.getSongs("Pop");
        assertTrue(popSongs.contains("Song 1"));
        assertTrue(popSongs.contains("Song 2"));
        assertEquals(2, popSongs.size());

        Set<String> rockSongs = database.getSongs("Rock");
        assertTrue(rockSongs.contains("Song 3"));
        assertEquals(1, rockSongs.size());
    }

    @Test
    public void testGetGenreOfSong() {
        database.addSong("Pop", "Song 1");
        database.addSong("Pop", "Song 2");
        database.addSong("Rock", "Song 3");

        assertEquals("Pop", database.getGenreOfSong("Song 1"));
        assertEquals("Pop", database.getGenreOfSong("Song 2"));
        assertEquals("Rock", database.getGenreOfSong("Song 3"));
        assertNull(database.getGenreOfSong("Unknown Song"));
    }

}
