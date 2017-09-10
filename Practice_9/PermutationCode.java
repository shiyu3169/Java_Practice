// assignment 9
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

import java.util.*;

/**
 * A class that defines a new permutation code, as well as methods for encoding
 * and decoding of the messages that use this code.
 */
public class PermutationCode {
  /** The original list of characters to be encoded */
  ArrayList<Character> alphabet = 
        new ArrayList<Character>(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
            't', 'u', 'v', 'w', 'x', 'y', 'z'));
  
  ArrayList<Character> code = new ArrayList<Character>(26);
  
  /** A random number generator */
  Random rand = new Random();
  
  /* Template:
   * 
   * Fields:
   * None
   * 
   * Methods:
   * ...this.initEncoder()...                        -- ArrayList<String>
   * ...this.encode(String)...                       -- String
   * ...this.decode(String)...                       -- String
   * ...this.map()...                                -- ArrayList<String>
   * ...this.mapToString(ArrayList<String>, count)...-- ArrayList<String>
   * 
   * Methods for Fields:
   * None
   * 
   */
  
  
  /**
   * Create a new instance of the encoder/decoder with a new permutation code 
   */
  PermutationCode() {
    this.code = this.initEncoder();
  }
  
  /**
   * Create a new instance of the encoder/decoder with the given code 
   */
  PermutationCode(ArrayList<Character> code) {
    this.code = code;
  }
  
  // copy of alphabet
  ArrayList<Character> alpha = 
          new ArrayList<Character>(Arrays.asList(
              'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
              'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
              't', 'u', 'v', 'w', 'x', 'y', 'z'));

  // the target ArrayList in which the encoded characters go sequentially
  ArrayList<Character> a = new ArrayList<Character> ();
  
  /** Initialize the encoding permutation of the characters */
  ArrayList<Character> initEncoder() {
      
      if (alpha.size() == 0)
          return a;
      
      // produces a random number from alpha's size
      int r = rand.nextInt(alpha.size());
      a.add(alpha.remove(r));
      return this.initEncoder();
  }
  
  /**
   * produce an encoded <code>String</code> from the given <code>String</code>
   * @param source the <code>String</code> to encode
   * @return the secretly encoded <String>
   */
  
  // encode the given string with this PermutationCode
  String encode(String source) {
      
      // alphabet as ArrayList of Strings
      ArrayList<String> alphabet2 = 
              new ArrayList<String>(Arrays.asList(
                  "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                  "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                  "u", "v", "w", "x", "y", "z")); 
      // get the first letter of the source string
      String s = source.substring(0, 1);
      
      if (source.length() == 1)
          return  this.code.get(alphabet2.indexOf(source))
                  .toString();
      else return this.code.get(alphabet2.indexOf(s))
              .toString() + 
              this.encode(source.substring(1, source.length()));
  }
  
  /**
   * produce an decoded <code>String</code> from the given <code>String</code>
   * @param source the <code>String</code> to decode
   * @return the revealed <String>
   */
  
  // map this PermutationCode
  ArrayList<String> map() {
      return this.mapToString(new ArrayList<String> (), 0);
  }
  
  // map this PermutationCode's code into an ArrayList of Strings
  // recur on this code until the given ArrayList of Strings has
  // the same code as this one except as Strings, not characters
  // count is used as an accumulator to check indices
  ArrayList<String> mapToString(ArrayList<String> alist, int count) {
      if (this.code.size() == alist.size())
          return alist;
      else alist.add(this.code.get(count).toString());
      return this.mapToString(alist, (count + 1));
  }
  
  // decode the given String using this PermutationCode
  String decode(String cod) {
      // get the first letter of the code string
      String s = cod.substring(0, 1);
      
    if (cod.length() == 1)
        return this.alphabet.get(this.map().indexOf(cod)).toString(); 
    else return this.alphabet.get(this.map().indexOf(s)).toString() +
            this.decode(cod.substring(1, cod.length()));
  }
  
}

