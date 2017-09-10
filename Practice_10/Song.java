// assignment 10
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

// Represents a song
public class Song implements IValue, MakeString {
    String title;
    String artist;
    int duration;  // in seconds(test is in minutes, written by TA or Professor
    
    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    
    /* Template
     *   Fields
     *     ... this.title ...       -- String
     *     ... this.artist ...      -- String
     *     ... this.duration ...    -- int
     *
     *   Methods 
     *     ... this.value() ...       -- int
     *     ... this.makeString() ...  -- String
     */
    
    // Compute the value of this Song, i.e., its duration
    public int value() {
        return this.duration;
    }
    
    // Make a String of this Song
    public String makeString() {
        return "Song: " + this.title + " by " + this.artist
                + "\nduration: " + this.duration + " minutes";
    }
}