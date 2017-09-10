// assignment 9
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

import java.util.Comparator;

//This class represents a comparator for Strings
class StringComparator implements Comparator<String> {
    
    /* Template:
     * 
     * Fields:
     * None
     * 
     * Methods:
     * ...this.compare(String, String)...          -- int
     * 
     * Methods for Fields:
     * No fields
     * 
     */
    
    // compares two strings lexographically
    public int compare(String first, String second) {
        return first.compareTo(second);
    }

}
