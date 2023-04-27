package howard.edu.lsp.exam.problem;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SongsDatabase {
    /* Key is the genre, HashSet contains associated songs */
    private Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

    /* Add a song title to a genre */
    public void addSong(String genre, String songTitle) {
        HashSet<String> set = map.get(genre);
        if (set == null) {
            set = new HashSet<String>();
            map.put(genre, set);
        }
        set.add(songTitle);
    }

    /* Return the Set that contains all songs for a genre */
    public Set<String> getSongs(String genre) {
        return map.get(genre);
    }

    /* Return genre, i.e., jazz, given a song title */
    public String getGenreOfSong(String songTitle) {
        for (String genre : map.keySet()) {
            HashSet<String> set = map.get(genre);
            if (set.contains(songTitle)) {
                return genre;
            }
        }
        return null;
    }
}
