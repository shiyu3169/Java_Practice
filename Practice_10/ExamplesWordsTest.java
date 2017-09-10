// assignment 10
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

import tester.Tester;
import junit.framework.TestCase;

// represents Junit tests for the Words class and such
public class ExamplesWordsTest extends TestCase {
    public void testWord() {
       
       String s = "hey";
       //test for equals and hashCode
       assertEquals(new Word("hey").equals(new Word("hey")), true);
       assertEquals(new Word("hey").equals(new Word("you")), false);
       assertEquals(new Word("hey").hashCode(), s.hashCode());
      
        
        //test for countWords and words
        WordCounter wc = new WordCounter();
        wc.countWords(new StringIterator(new StringBuffer("The Words Are")));
        assertEquals(wc.words.get(0), new Word("the"));
        assertEquals(wc.words(), 3);
        
        // test for countWords and words and printWords
        WordCounter macbeth = new WordCounter();
        macbeth.countWords(new StringIterator("Macbeth.txt"));
        macbeth.printWords(10);
        assertEquals(macbeth.words(), 3198);
        
    }
    //test the iterator 
    public void testStringIter(Tester t) {
        StringIterator wrds = new StringIterator(
                new StringBuffer("The Words Are"));
        
        int i = 0;
        for (Word w : wrds) {
            System.out.println(" Word[" + (i++) + "] :" + w);
        }
    }
}


