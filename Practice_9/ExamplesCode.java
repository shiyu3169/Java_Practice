// assignment 9
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import tester.*;

//This class represents tests for the PermutationCode class
public class ExamplesCode {

    // the ArrayList containing the alphabet sequentially
    ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList('a',
                                          'b', 'c', 'd', 'e', 'f', 'g', 'h',
                                          'i', 'j', 'k', 'l', 'm', 'n', 'o',
                                          'p', 'q', 'r', 's', 't', 'u', 'v',
                                          'w', 'x', 'y', 'z'));

    /** A random number generator */
    Random rand = new Random();
    
    // sample string
    String s = "cliff";
    
    // sample PermutationCode Encoder
    PermutationCode      encoder  = new PermutationCode();
    PermutationCode      encoder2 = new PermutationCode(
            new ArrayList<Character>(Arrays.asList('b',
                    'c', 'd', 'e', 'f', 'g', 'h', 'i',
                    'j', 'k', 'l', 'm', 'n', 'o', 'p',
                    'q', 'r', 's', 't', 'u', 'v', 'w',
                    'x', 'y', 'z', 'a')));

    // test the methods
    void testAll(Tester t) {
        
       t.checkExpect(encoder.code.size() == alphabet.size());
       
       t.checkExpect(encoder.decode(encoder.encode(s)), "cliff");
       
       t.checkOneOf(encoder.encode(s).substring(0, 1), new String[]{"a", "b",
           "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
           "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"});

       t.checkOneOf(encoder.decode(s).substring(0, 1), new String[]{"a", "b",
           "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
           "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"});
       
       t.checkExpect(encoder2.decode(encoder2.encode(s)), "cliff");
       
       t.checkExpect(encoder2.encode(s), "dmjgg");

       t.checkExpect(encoder2.decode(s), "bkhee");
       
       t.checkOneOf(encoder.initEncoder().get(0), new Character[]{'a',
               'b', 'c', 'd', 'e', 'f', 'g', 'h',
               'i', 'j', 'k', 'l', 'm', 'n', 'o',
               'p', 'q', 'r', 's', 't', 'u', 'v',
               'w', 'x', 'y', 'z'});
       
    }
}
