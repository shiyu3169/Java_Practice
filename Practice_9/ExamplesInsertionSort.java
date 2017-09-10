// assignment 9
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

import java.util.*;
import tester.*;

// class to test the sortedInsert and insertSort method
public class ExamplesInsertionSort {
    
    /* Template:
     * 
     * Fields:
     * None
     * 
     * Methods:
     * ...this.sortedInsert(T, ArrayList<T>, Comparator<T>)             -- void
     * ...this.sortedInsertHelp(T, ArrayList<T>, Comparator<T>, Integer)-- void
     * ...this.insertionSort(T, ArrayList<T>, Comparator<T>)            -- void
     * ...this.insertionSortHelper(T, ArrayList<T>, Comparator<T>)      -- void
     * 
     * 
     * Methods for Fields:
     * No fields
     */
    

    // Effect: insert the given item into the given ArrayList based on the given
    // ordering in its appropriate place in the list
    public <T> void sortedInsert(T item, ArrayList<T> alist,
            Comparator<T> comp) {
        this.sortedInsertHelp(item, alist, comp, 0);
    }

    // Effect: insert the given item into the given ArrayList based on the 
    // given ordering; places the item at the given index if it is supposed
    // to be there
    public <T> void sortedInsertHelp(T item, ArrayList<T> alist,
            Comparator<T> comp, int ind) {

        if (alist.isEmpty())
            alist.add(item);

        else if ((alist.size() > ind) &&
                (comp.compare(alist.get(ind), item) <= 0))
            this.sortedInsertHelp(item, alist, comp, (ind + 1));

        else if ((alist.size() > ind) &&
                (comp.compare(alist.get(ind), item) > 0))
            alist.add(ind, item);

        else alist.add(item);
    }

    // Effect: sort the ArrayList based on the given ordering
    public <T> void insertionSort(ArrayList<T> alist,
            Comparator<T> comp) {
        
        if (!alist.isEmpty())
        this.insertionSortHelper(alist, comp);

    }

    // Effect: sort the given ArrayList based on the given ordering
    public <T> void insertionSortHelper(ArrayList<T> alist,
            Comparator<T> comp) {
        T it = alist.get(0);
        alist.remove(it);
        this.insertionSort(alist, comp);
        this.sortedInsert(it, alist, comp);
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
        this.insertionSort(slist, scomp);
        this.insertionSort(ilist, icomp);
        
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
        
        // test the method insertionSort indirectly
        initDataUnsorted();

        t.checkExpect(ilist.size(), 4);
        t.checkExpect(ilist.get(0), 1);
        t.checkExpect(ilist.get(1), 2);
        t.checkExpect(ilist.get(2), 3);
        t.checkExpect(ilist.get(3), 4);
        
        t.checkExpect(slist.size(), 4);
        t.checkExpect(slist.get(0), "a");
        t.checkExpect(slist.get(1), "b");
        t.checkExpect(slist.get(2), "c");
        t.checkExpect(slist.get(3), "d");
        
    }
    

    
}
