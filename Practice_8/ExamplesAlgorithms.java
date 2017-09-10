import java.util.*;
import tester.*;

// This class represents tests for Algorithms, StringComp, and IntComp Classes
class ExamplesAlgorithms {

    // These are sample ArrayLists of Strings and Integers
    ArrayList<String> slist = new ArrayList<String>();
    ArrayList<Integer> ilist = new ArrayList<Integer>();

    // Sample Algorithms

    Algorithms algo = new Algorithms();

    <T> int binSearch(T item, ArrayList<T> alist, Comparator<T> comp) {
        return this.algo.binSearch(item, alist, comp, 0, (alist.size() - 1));
    }

    // Sample StringComp
    StringComparator stringComp = new StringComparator();
    // Sample IntComp
    IntegerComparator intComp = new IntegerComparator();

    // Effect: to initialize the sample data
    void initData() {
        slist.add("X");
        slist.add("Y");
        slist.add("Z");
        ilist.add(1);
        ilist.add(2);
        ilist.add(3);
    }

    // Effect: To give the base case values of sample data
    void resetData() {
        slist.clear();
        ilist.clear();
    }

    // Test the initData and resetData methods in the ExamplesAlgorithms Class
    void testContains(Tester t) {
        t.checkExpect(slist.contains("f"), false);
        t.checkExpect(slist.contains("X"), false);
        this.initData();
        t.checkExpect(slist.contains("X"), true);
        this.resetData();
        t.checkExpect(slist.isEmpty(), true);
    }

    // TESTS: StringComparator Class

    // Test the method compare
    void testCompareString(Tester t) {
        t.checkExpect(stringComp.compare("a", "b"), -1);
        t.checkExpect(stringComp.compare("a", "a"), 0);
        t.checkExpect(stringComp.compare("b", "a"), 1);
    }

    // TESTS: IntegerComparator Class

    // Test the method compare
    void testCompareInt(Tester t) {
        t.checkExpect(intComp.compare(1, 1), 0);
        t.checkExpect(intComp.compare(1, 2), -1);
        t.checkExpect(intComp.compare(2, 1), 1);
    }

    // TESTS: Algorithms Class

    // Test the method binary with safe numbers
    void testBinary(Tester t) {
        this.initData();
        t.checkExpect(algo.binary(0, 3, ilist, intComp, 3), 2);
        t.checkExpect(algo.binary(0, 3, ilist, intComp, 1), 0);
        t.checkExpect(algo.binary(0, 2, ilist, intComp, 3), -1);
    }

    // Test the method binarySearch
    void testBinarySearch(Tester t) {
        this.initData();
        t.checkExpect(this.binSearch(3, ilist, intComp), 2);
        t.checkExpect(this.binSearch(1, ilist, intComp), 0);
        t.checkExpect(this.binSearch(4, ilist, intComp), -1);
    }

}
