import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import tester.Tester;

public class ExamplesInsertSort {

    /* Template:
     * 
     * Fields:
     * None
     * 
     * Methods:
     * ...this.sortedInsert(T, ArrayList<T>, Comparator<T>)...  -- void
     * ...this.sortedInsertHelp(T, ArrayList<T>,
     *                          Comparator<T>, Integer)...      -- void
     * ...this.insertSort(T, ArrayList<T>, Comparator<T>)...    -- ArrayList<T>
     * ...this.insertSortHelper(T, ArrayList<T>, 
     *                          Comparator<T>, ArrayList<T>)... -- ArrayList<T>
     * 
     * 
     * Methods for Fields:
     * No fields
     * 
     */
    
    // Effect: insert the given item into the given ArrayList based on the given
    // ordering in its appropriate place in the list
    public <T> void sortedInsert(T item, ArrayList<T> alist,
            Comparator<T> comp) {
        this.sortedInsertHelp(item, alist, comp, 0);
    }

    // Effect: insert the given item into the given ArrayList based on the given
    // ordering places the item at the given index if it is supposed to be
    // there
    public <T> void sortedInsertHelp(T item, ArrayList<T> alist,
            Comparator<T> comp, int ind) {

        if (alist.isEmpty())
            alist.add(item);

        else if ((alist.size() > ind)
                && (comp.compare(alist.get(ind), item) <= 0))
            this.sortedInsertHelp(item, alist, comp, (ind + 1));

        else if ((alist.size() > ind)
                && (comp.compare(alist.get(ind), item) > 0))
            alist.add(ind, item);

        else
            alist.add(item);
    }

    // Sort the given ArrayList with the given order
    public <T> ArrayList<T> insertSort(ArrayList<T> alist,
            Comparator<T> comp) {
            return this.insertSortHelper(alist, comp, new ArrayList<T>());
    }

    // Sort the givenArrayList with the given order and return the target
    // ArrayList
    public <T> ArrayList<T> insertSortHelper(ArrayList<T> alist,
            Comparator<T> comp, ArrayList<T> target) {
        if (alist.isEmpty())
            return this.drain(alist, target);
        else {
            this.sortedInsert(alist.remove(0), target, comp);
            return this.insertSortHelper(alist, comp, target);
        }
        
    }
    
    // Add to the first given list, all elements of the second given list
    // preserving order
    public <T> ArrayList<T> drain(ArrayList<T> original, ArrayList<T> take) {
        if (take.isEmpty())
            return original;
        else { original.add(take.remove(0));
        return this.drain(original, take);
        }
    }
    
    // sample ArrayLists of Integers and Strings
    ArrayList<Integer> ilist;
    ArrayList<String> slist;
    
    // sample StringComparator 
    StringComparator scomp = new StringComparator();
    
    // sample IntegerComparator
    IntegerComparator icomp = new IntegerComparator();
    
    // reset the data;
    public void reset() {
        
    ilist = new ArrayList<Integer> ( );
    slist = new ArrayList<String> ( );
    
    }
    
    // initialize the data
    public void initData() {
        reset();
        this.sortedInsert(1, ilist, icomp);
        this.sortedInsert(2, ilist, icomp);
        this.sortedInsert(3, ilist, icomp);
        this.sortedInsert(1, ilist, icomp);
        this.sortedInsert("a", slist, scomp);
        this.sortedInsert("b", slist, scomp);
        this.sortedInsert("c", slist, scomp);
        this.sortedInsert("b", slist, scomp);
        
    }
    
    // intialize the data, unsorted
    public void initDataUnsorted() {
        reset();
        ilist.add(3);
        ilist.add(2);
        ilist.add(4);
        ilist.add(1);
        slist.add("b");
        slist.add("a");
        slist.add("d");
        slist.add("c");
        
    }
    
    // test all the methods in this class
    public void testAll(Tester t) {
        
        // test the method sortedInsert indirectly 
        reset();
        t.checkExpect(ilist.size(), 0);
        initData();
        t.checkExpect(ilist.size(), 4);
        t.checkExpect(ilist.get(0), 1);
        t.checkExpect(ilist.get(1), 1);
        t.checkExpect(ilist.get(2), 2);
        t.checkExpect(ilist.get(3), 3);
        
        reset();
        t.checkExpect(slist.size(), 0);
        initData();
        t.checkExpect(slist.size(), 4);
        t.checkExpect(slist.get(0), "a");
        t.checkExpect(slist.get(1), "b");
        t.checkExpect(slist.get(2), "b");
        t.checkExpect(slist.get(3), "c");
        
        // test the method insertSort
        initDataUnsorted();

        t.checkExpect(ilist.size(), 4);
        t.checkExpect(ilist.get(0), 3);
        t.checkExpect(ilist.get(1), 2);
        t.checkExpect(ilist.get(2), 4);
        t.checkExpect(ilist.get(3), 1);
        t.checkExpect(this.insertSort(ilist, icomp),
                new ArrayList<Integer>(Arrays.asList(
                        1, 2, 3 , 4)));
        t.checkExpect(this.insertSort(ilist, icomp).size(), 4);
        t.checkExpect(this.insertSort(ilist, icomp).get(0), 1);
        
        t.checkExpect(slist.size(), 4);
        t.checkExpect(slist.get(0), "b");
        t.checkExpect(slist.get(1), "a");
        t.checkExpect(slist.get(2), "d");
        t.checkExpect(slist.get(3), "c");
        t.checkExpect(this.insertSort(slist, scomp),
                new ArrayList<String>(Arrays.asList(
                        "a", "b", "c" , "d")));
        
    }
    
    
    
}
