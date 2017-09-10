import java.util.ArrayList;
import java.util.Comparator;

// This class represents a systematic approach to creating algorithms in java
class Algorithms {

    // searches through the given list with the given comparator to locate 
    // the given object within the range of the given inclusive low and 
    // exclusive high
    // returns the index of the obj if it is in list and range, otherwise -1
    public <T> int binSearch( T item, ArrayList<T> list,
            Comparator<T> comp, Integer low, Integer high) {
    if ((low >= 0) && (high >= 0) && (high > low) && (high <= list.size()))
            return this.binary(low, high, list, comp, item);
    else return -1;
    }
    
    // searches the list for the given obj based on the given high and low
    // values and searches acts as a binary search method (it uses the given 
    // compare to see where to search next, or if the search should terminate)
    public <T> Integer binary(Integer low, Integer high,
            ArrayList<T> list, Comparator<T> comp, T obj)  {
        if (comp.compare(obj, list.get((low + high) / 2)) > 0)
            return this.binSearch(obj, list,
                                     comp,
                                     (low + high + 1) / 2,
                                     high);
        else if (comp.compare(obj, list.get((low + high) / 2)) == 0)
            return (low + high) / 2;
        else return this.binSearch(obj, list, comp, low, (low + high) / 2);
    }
    
}