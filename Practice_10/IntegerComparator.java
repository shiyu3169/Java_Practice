// assignment 9
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

import java.util.Comparator;

// This class represents a comparator for integers
class IntegerComparator implements Comparator<Integer> {
    
    /* Template:
     * 
     * Fields:
     * None
     * 
     * Methods:
     * ...this.compare(Integer, Integer)...          -- int
     * 
     * Methods for Fields:
     * No fields
     * 
     */
    
    // compares two integers by their magnitude
    public int compare(Integer first, Integer second) {
        return first - second;
    }
    
}
