// assignment 10
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu


/** <code>Word</code> represents a word and its number of occurrences */
public class Word {
    
    /*TEMPLATE
     * Fields
     * this.s....   -- String
     * this.freq.... -- int
     * 
     * Methods
     * this.equals(Object)... --boolean
     * this.hashCode().....   --int
     * this.toString().....   --String
     * this.increment()....   --void
     * 
     * Methods for fields
     * this.s.equals(Object)....  -- boolean
     * this.s.hashCode().....     -- int
     * 
     * 
     */
    String s;
    int freq;

    public Word(String s) {
        this.s = s;
        this.freq = 1;
    }
  
    /** Is this Word equal to the given Object */
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        else { Word word1 = (Word)obj;
        return this.s.equals(word1.s); }
    }
  
    /** Produce this Word's hashCode */
    public int hashCode() {
        return this.s.hashCode();
    }
  
    /** Produce a String representation of this Word */
    public String toString() {
        return this.s + this.freq;
    }
    
    // Increment this word's frequency
    public void increment() {
        this.freq = this.freq + 1;
    }

}
