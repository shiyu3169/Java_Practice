// assignment 10
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

import java.util.ArrayList;

import tester.*;

/** Class to hold examples of data and tests */
public class ExamplesWords {

   public ExamplesWords() { }



   /** Test Word Classes... */
   public void testWords(Tester t) {
        
        String s = "hey";
        //test for equals and hashCode
        t.checkExpect(new Word("hey").equals(new Word("hey")), true);
        t.checkExpect(new Word("hey").equals(new Word("you")), false);
        t.checkExpect(new Word("hey").hashCode(), s.hashCode());
      
        
      //test for countWords and words
        WordCounter wc = new WordCounter();
        wc.countWords(new StringIterator(new StringBuffer("The Words Are")));
        t.checkExpect(wc.words.get(0), new Word("the"));
        t.checkExpect(wc.words(), 3);
        
        
        // test for countWords and words and printWords
        WordCounter macbeth = new WordCounter();
        macbeth.countWords(new StringIterator("Macbeth.txt"));
        macbeth.printWords(10);
        t.checkExpect(macbeth.words(), 3198);
    }
    //test the Iterator
    public void testStringIter(Tester t) {
        StringIterator wrds = new StringIterator(
                new StringBuffer("The Words Are"));
        
        int i = 0;
        for (Word w : wrds) {
            System.out.println(" Word[" + (i++) + "] :" + w);
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
    WordCounter ww = new WordCounter();
    WordCounter mm = new WordCounter();
    // initialize the data
    public void initData() {
        reset();
        ww.sortedInsert(1, ilist, icomp);
        ww.sortedInsert(2, ilist, icomp);
        ww.sortedInsert(3, ilist, icomp);
        ww.sortedInsert(1, ilist, icomp);
        mm.sortedInsert("a", slist, scomp);
        mm.sortedInsert("b", slist, scomp);
        mm.sortedInsert("c", slist, scomp);
        mm.sortedInsert("b", slist, scomp);
        
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
        ww.insertionSort(slist, scomp);
        mm.insertionSort(ilist, icomp);
        
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
 