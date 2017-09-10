import java.util.Comparator;

//This class represents a comparator for Strings
class StringComparator implements Comparator<String> {
    
    // compares two strings lexographically
    public int compare(String first, String second) {
        return first.compareTo(second);
    }

}
