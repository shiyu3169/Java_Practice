// assignment 10
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

/** CS 2510 Assignment 11  */

import java.util.Iterator;
import java.io.*;

/** StringIterator is a concrete class for iterating over all the
 *    words in a StringBuffer or text file.  At present a word is defined
 *    to be a maximal contiguous sequence of English letters.
 */
public class StringIterator implements Iterator<Word>, Iterable<Word>{
  
    private StreamTokenizer tok;
  
    /** Create a StringIterator over the words in the given filename */
    public StringIterator (String filename){
        try {
            FileInputStream fin = new FileInputStream(filename);
            InputStreamReader isr = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(isr);
            this.tok = wordTokenizer(br);
        }catch (FileNotFoundException e) {
            this.tok = wordTokenizer (new StringReader (""));
            System.err.println ("StringIterator: File \"" + filename + "\" not found.");
        }
    }
  
    /** Create a StringIterator over the words in the given StringBuffer */
    public StringIterator (StringBuffer sb) {
        this.tok = wordTokenizer(new StringReader(sb.toString()));
    }
  
    /** Is there another word in this StringIterator */
    public boolean hasNext () {
        int tt = nextToken();
        while ((tt != tok.TT_EOF) && (tt != tok.TT_WORD)) {
            tt = nextToken();
        }
        // Pretend we haven't seen this token yet.
        tok.pushBack();
        return tt == tok.TT_WORD;
    }
  
    /** Return the next word in the Iterator */
    public Word next(){
        int tt = nextToken();
        while ((tt != tok.TT_EOF) && (tt != tok.TT_WORD)) {
            tt = nextToken();
        }
        if (tt == tok.TT_WORD) {
            return new Word(tok.sval);
        }
        throw new RuntimeException(eofError);
    }
  
    /** Not implemented, not needed. */
    public void remove(){
        throw new RuntimeException("StringIterator: Remove Not Possible");
    }
  
    /** Make this iterator available for FOR-EACH loops */
    public Iterator<Word> iterator(){ return this; }

    
    /** Behaves like tok.nextToken(), but catches any IOException
     *    and treats it as though it were the end of input. */
    private int nextToken(){
        int tt = 0;
        try {
            tt = tok.nextToken();
        }
        catch (IOException e) {
            tt = tok.TT_EOF;
        }
        return tt;
    }
  
    private String eofError = "Tried to read past end of input.";
  
    /** Given a Reader, returns a StreamTokenizer for that Reader
     *    that parses words. */
    private static StreamTokenizer wordTokenizer (Reader in) {
        StreamTokenizer tok = new StreamTokenizer (in);
        tok.resetSyntax ();
        tok.lowerCaseMode (true);
        tok.wordChars ('a', 'z');
        tok.wordChars ('A', 'Z');
        tok.eolIsSignificant (false);
        return tok;
    }
}
