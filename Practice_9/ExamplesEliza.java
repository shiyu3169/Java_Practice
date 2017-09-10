// assignment 9
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

import tester.*;
import java.util.*;

public class ExamplesEliza {

    // Examples ArrayLists of Strings representing answers
    ArrayList<String> wholist;
    ArrayList<String> whatlist;
    ArrayList<String> wherelist;
    ArrayList<String> whenlist;
    ArrayList<String> whylist;
    ArrayList<String> howlist;
    ArrayList<String> anylist;
    
    // sample Replies
    Reply who;
    Reply what;
    Reply where;
    Reply when;
    Reply why;
    Reply how;
    
    // sample Eliza
    Eliza eliza = new Eliza();
    
    // reset the data
    void reset() {
        wholist = new ArrayList<String> ();
        whatlist = new ArrayList<String> ();
        wherelist = new ArrayList<String> ();
        whenlist = new ArrayList<String> ();
        whylist = new ArrayList<String> ();
        howlist = new ArrayList<String> ();
        
        who = new Reply("who", wholist);
        what = new Reply("what", whatlist);
        where = new Reply("where", wherelist);
        when = new Reply("when", whenlist);
        why = new Reply("why", whylist);
        how = new Reply("how", howlist);
    }
    
    // initialize the data
    void initData() {
        reset();
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
        
        who = new Reply("who", wholist);
        what = new Reply("what", whatlist);
        where = new Reply("where", wherelist);
        when = new Reply("when", whenlist);
        why = new Reply("why", whylist);
        how = new Reply("how", howlist);
    }
    
    void testAll(Tester t) {
        
        //test the randomAnswer method in the Reply Class
        reset();
        t.checkExpect(who.randomAnswer("who"), 
                "There is no answer for your question.");
        t.checkExpect(who.randomAnswer("pourquoi"), 
                "TI-83.value() > TI-89 Platinum.value(); Always.");
        t.checkExpect(what.randomAnswer("what"), 
                "There is no answer for your question.");
        t.checkExpect(what.randomAnswer("qi"), 
                "TI-83.value() > TI-89 Platinum.value(); Always.");
        t.checkExpect(where.randomAnswer("where"), 
                "There is no answer for your question.");
        t.checkExpect(where.randomAnswer("warum"), 
                "TI-83.value() > TI-89 Platinum.value(); Always.");
        t.checkExpect(when.randomAnswer("when"),
                "There is no answer for your question.");
        t.checkExpect(when.randomAnswer("jiggle"),
                "TI-83.value() > TI-89 Platinum.value(); Always.");
        t.checkExpect(why.randomAnswer("why"),
                "There is no answer for your question.");
        t.checkExpect(why.randomAnswer("a"),
                "TI-83.value() > TI-89 Platinum.value(); Always.");
        t.checkExpect(how.randomAnswer("how"),
                "There is no answer for your question.");
        t.checkExpect(how.randomAnswer(""),
                "TI-83.value() > TI-89 Platinum.value(); Always.");
        
        initData();
        t.checkOneOf(who.randomAnswer("who"), new String[]{
            "Your dad.", 
            "You.", 
            "That 3 year old who died yesterday."});
        t.checkOneOf(what.randomAnswer("what"), new String[]{
            "What?", 
            "A new beginning. so you can fix your horrible" +
            " breath.",
            "Iphone 5s."});
        t.checkOneOf(where.randomAnswer("where"), new String[]{
            "In that volcano, " +
            "give it a look-see.", 
            "In the rundown motel you were conceived in.",
            "At the bottom of sea. You have to be there" +
            " for at least an hour to find what you're looking for."});
        t.checkOneOf(when.randomAnswer("when"), new String[]{
            "At 9. PM or AM? Well that I can't tell you.", 
            "When I thoroughly enjoy having a bad day.",
            "At dawn."});
        t.checkOneOf(why.randomAnswer("why"), new String[]{
            "Because you're weak.", 
            "Because you're fat.",
            "Because I hate your face."});
        t.checkOneOf(how.randomAnswer("how"), new String[]{
            "I ask myself that everytime.", 
            "You already know. Deep within your mind." +
            " And deep within your bowels. You know.",
            "Kill yourself. Please."});
        
        // test the firstWord method in Eliza Class
        t.checkExpect(eliza.firstWord("PopY PPOopo Cliff"), "popy");
        t.checkExpect(eliza.firstWord("why"), "why");
        t.checkExpect(eliza.firstWord(""), "");
        t.checkExpect(eliza.firstWord(" what"), "what");
        
        // test the first method in Eliza Class
        t.checkExpect(eliza.first("PopY PPOopo Cliff"), "PopY");
        t.checkExpect(eliza.first("why"), "why");
        t.checkExpect(eliza.first(" what"), "");
        
        
        // test the method randomAnswer in Eliza Class
        t.checkOneOf(eliza.randomAnswer("who"), new String[]{
            "Your dad.", 
            "You.", 
            "That 3 year old who died yesterday."});
        t.checkOneOf(eliza.randomAnswer("what"), new String[]{
            "What?", 
            "A new beginning. so you can fix your horrible" +
            " breath.",
            "Iphone 5s."});
        t.checkOneOf(eliza.randomAnswer("where"), new String[]{
            "In that volcano, " +
            "give it a look-see.", 
            "In the rundown motel you were conceived in.",
            "At the bottom of sea. You have to be there" +
            " for at least an hour to find what you're looking for."});
        t.checkOneOf(eliza.randomAnswer("when"), new String[]{
            "At 9. PM or AM? Well that I can't tell you.", 
            "When I thoroughly enjoy having a bad day.",
            "At dawn."});
        t.checkOneOf(eliza.randomAnswer("why"), new String[]{
            "Because you're weak.", 
            "Because you're fat.",
            "Because I hate your face."});
        t.checkOneOf(eliza.randomAnswer("how"), new String[]{
            "I ask myself that everytime.", 
            "You already know. Deep within your mind." +
            " And deep within your bowels. You know.",
            "Kill yourself. Please."});
        t.checkExpect(eliza.randomAnswer("wuzzup"),
            "TI-83.value() > TI-89 Platinum.value(); Always.");
    }
    
}
