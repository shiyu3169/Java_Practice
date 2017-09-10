// assignment 9
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

/* 
 * ---------------------------
 * |         Eliza           |
 * ---------------------------
 * |ArrayList<Reply> replies |
 * ------------|--------------
 *             |
 *             |
 *             |
 *             | (The Data type of the replies ArrayList)*
 *             |  
 *             |
 *             |      ----------------------------
 *             ------>|     Reply                |
 *                    ----------------------------
 *                    | String           keyword |
 *                    |ArrayList<String> answers |
 *                    ----------------------------
 * 
 */

import java.util.*;

// This class represents a reply
public class Reply {
    
    String keyword; // the keyword that leads to 
    ArrayList<String> answers; // these answers
    Reply(String keyword, ArrayList<String> answers) {
        this.keyword = keyword;
        this.answers = answers;
    }
    
    /* Template:
     * 
     * Fields:
     * ...this.keyword...                            -- String
     * ...this.answers...                            -- ArrayList<String>
     * 
     * Methods:
     * ...this.randomAnswer(String)...               -- String
     * 
     * Methods for Fields:
     * 
     * Built-in
     * 
     */
    
    // A random number generator
    Random rand = new Random();
 
    // produce a random answer from this ArrayList of Strings that are answers
    // if the given String matches any question in this list
    public String randomAnswer(String question) {
         if (question.equals(this.keyword))
            { if (this.answers.isEmpty())
                return "There is no answer for your question.";
            else return this.answers.get(rand.nextInt(answers.size())); }
        else return "TI-83.value() > TI-89 Platinum.value(); Always.";
    }
    
}
