// assignment 9
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

import java.util.*;

// this class represents a psychiatrist who has a list of replies
public class Eliza {
    ArrayList<Reply> replies;

    Eliza() {
        this.replies = new ArrayList<Reply> ( );
        this.initReplies();
    }
    
    
    /* Template:
     * 
     * Fields:
     * ...this.replies...                            -- ArrayList<Reply>
     * 
     * Methods:
     * ...this.initReplies()...                      -- void
     * ...this.firstWord(String)...                  -- String
     * ...this.first(String)...                      -- String
     * ...this.randomAnswer(String)...               -- String
     * 
     * Methods for Fields:
     * 
     * Built-in
     */
    
    //Effect: Initialize Eliza's replies
    public void initReplies() {
    
     // Examples ArrayLists of Strings representing answers
        ArrayList<String> wholist = new ArrayList<String> ();
        ArrayList<String> whatlist = new ArrayList<String> ();
        ArrayList<String> wherelist = new ArrayList<String> ();
        ArrayList<String> whenlist = new ArrayList<String> ();
        ArrayList<String> whylist = new ArrayList<String> ();
        ArrayList<String> howlist = new ArrayList<String> ();

            wholist.add("You.");
            wholist.add("Your dad.");
            wholist.add("That 3 year old who died yesterday.");
            
            whatlist.add("What?");
            whatlist.add("A new beginning. so you can fix your horrible" +
            " breath.");
            whatlist.add("Iphone 5s.");
            
            wherelist.add("In that volcano, "
                    + "give it a look-see.");
            wherelist.add("In the rundown motel you were conceived in.");
            wherelist.add("At the bottom of sea. You have to be there" +
            " for at least an hour to find what you're looking for.");
            
            whenlist.add("At 9. PM or AM? Well that I can't tell you.");
            whenlist.add("When I thoroughly enjoy having a bad day.");
            whenlist.add("At dawn.");
            
            whylist.add("Because you're weak.");
            whylist.add("Because you're fat.");
            whylist.add("Because I hate your face.");
            
            howlist.add("I ask myself that everytime.");
            howlist.add("You already know. Deep within your mind." +
                    " And deep within your bowels. You know.");
            howlist.add("Kill yourself. Please.");
            
            // Sample replies
            Reply who = new Reply("who", wholist);
            Reply what = new Reply("what", whatlist);
            Reply where = new Reply("where", wherelist);
            Reply when = new Reply("when", whenlist);
            Reply why = new Reply("why", whylist);
            Reply how = new Reply("how", howlist);
            
            // Samples ArrayList of Reply
            ArrayList<Reply> replylist = new ArrayList<Reply>();
            
            replylist.add(who);
            replylist.add(what);
            replylist.add(where);
            replylist.add(when);
            replylist.add(why);
            replylist.add(how);
            
            this.replies = replylist;
            
    }
    
    // Get the first word of the given string 
    public String firstWord(String s) {
        return this.first(s.trim().toLowerCase());
    }
    
    // Get the first word of the given string 
    public String first(String s) {
        if (s.startsWith(" "))
            return "";
        else if (s.length() <= 1)
            return s;
        else return s.substring(0, 1) + this.first(s.substring(1, s.length()));
    }
    
    // give the Reply in this Eliza's ArrayList of Replies in response
    // to the given question 
    public String randomAnswer(String question) {
        if (question.equals("who"))
            return this.replies.get(0).randomAnswer(question);
        if (question.equals("what"))
            return this.replies.get(1).randomAnswer(question);
        if (question.equals("where"))
            return this.replies.get(2).randomAnswer(question);
        if (question.equals("when"))
            return this.replies.get(3).randomAnswer(question);
        if (question.equals("why"))
            return this.replies.get(4).randomAnswer(question);
        else return this.replies.get(5).randomAnswer(question);
    }
    
}
