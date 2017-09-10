import java.util.Comparator;

// This class represents a comparator for integers
class IntegerComparator implements Comparator<Integer> {
    
    // compares two integers by their magnitude
    public int compare(Integer first, Integer second) {
        return first - second;
    }
    
}
