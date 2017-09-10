// assignment 6
// pair p134
// Singh, Bhavneet
// singhb
// shiyu
// this class represents a deque
import tester.*;
public class ExamplesDeque {
    //sample Deque
    Deque d;
    
    //sample Sentinel
    Sentinel s;
    Node abcnode;
    Node bcdnode;
    Node cdenode;
    Node defnode; 
    
    //EFFECT
    //give a empty list Deque
    void reset() {
        s = new Sentinel();
        d = new Deque();
        d.node  = s;
        abcnode = new Node("abc", null, null);
        bcdnode = new Node("bcd", null, null);
        cdenode = new Node("cde", null, null);
        defnode = new Node("def", null, null);
    }
    //EFFECT
    //give a orderd list Deque
    void list1() {
       reset();
       
       s.addPrev(defnode);
       s.addNext(abcnode);
       
       abcnode.addPrev(s);
       abcnode.addNext(bcdnode);
       
       bcdnode.addPrev(abcnode);
       bcdnode.addNext(cdenode);
       
       cdenode.addPrev(bcdnode);
       cdenode.addNext(defnode);
       
       defnode.addPrev(cdenode);
       defnode.addNext(s);
    }
    
    //EFFECT
    //give a unorderd list Deque
    void list2() {
        reset();
        
        s.addPrev(abcnode);
        s.addNext(defnode);
        
        abcnode.addNext(s);
        abcnode.addPrev(cdenode);
        
        bcdnode.addNext(cdenode);
        bcdnode.addPrev(defnode);
        
        cdenode.addNext(abcnode);
        cdenode.addPrev(bcdnode);
        
        defnode.addNext(bcdnode);
        defnode.addPrev(s);
    }
 
    
  void testAll(Tester t) {
          
      // ORDERED LIST
      list1();
      
      //size
      t.checkExpect(d.size(), 4);
      
      //addAtHead(using getFirst and size to check)
     d.addAtHead("abc");
     
     //getFirst
     t.checkExpect(d.getFirst(), new Node ("abc", abcnode, s));
     
     //size
     t.checkExpect(d.size(), 5);
     
     //addAtTail(using getlast and size to check)
     d.addAtTail("abc");
     
     //getLast
     t.checkExpect(d.getLast(), new Node("abc", s, defnode));
     
     //size
     t.checkExpect(d.size(), 6); 
     
     
     

     //removeFromHead(check it by size and getfirst)
     list1();
     d.removeFromHead();
     
     
     //size
     t.checkExpect(d.size(), 3);
     
     //getFirst
     t.checkExpect(d.getFirst(), new Node ("bcd", cdenode, s));
     
     //removeFromTail(check it by size and getlast)
     d.removeFromTail();
     
     //size
     t.checkExpect(d.size(), 2);
     
     //getLast
     t.checkExpect(d.getLast(), new Node ("cde", s, bcdnode));
     
     //insertSorted
     list1();
     d.insertSorted("a");
     t.checkExpect(d.size(), 5);
     t.checkExpect(d.getFirst(), new Node("a", abcnode, s));

     d.insertSorted("z");
     t.checkExpect(d.size(), 6);
     t.checkExpect(d.getLast(), new Node("z", s, defnode));
     

    
     
     //removeSorted
     list1();
     d.removeSorted("abc");
     t.checkExpect(d.size(), 3);
     t.checkExpect(d.getFirst(), new Node("bcd", cdenode, s));
     t.checkException(new RuntimeException
             ("No such String in the list"), d, "removeSorted", "a");
     
     
     
     
     

      
      // UNORDERED LIST
      list2();
      
      //size
      t.checkExpect(d.size(), 4);
      
      //addAtHead(using getFirst and size to check)
      list2();
      d.addAtHead("def");
      //getFirst
      t.checkExpect(d.getFirst(), new Node("def", defnode, s));
      
      //size
      t.checkExpect(d.size(), 5);
      
      //addAtTail(using getLast and size to check)
      d.addAtTail("def");
      
      //getLast
      t.checkExpect(d.getLast(), new Node("def", s, abcnode));
      
      //size
      t.checkExpect(d.size(), 6);
      
      //removeFromHead(check it by size and getFirst)
      list2();
      d.removeFromHead();
      
      //size
      t.checkExpect(d.size(), 3);
      
      //getFirst
      t.checkExpect(d.getFirst(), new Node ("bcd", cdenode, s));
      
      
      //removeFromTail(check it by size and getlast)
      d.removeFromTail();
      
      //size
      t.checkExpect(d.size(), 2);
      
      //getLast
      t.checkExpect(d.getLast(), new Node ("cde", s, bcdnode));
      

      
      
      
      
      
      // EMPTY LIST
      reset();
      
      //size
      t.checkExpect(d.size(), 0);
      
      //getFirst
      t.checkException(new RuntimeException
              ("Cannot get the first of an empty list"), d, "getFirst");
      
      //getLast
      t.checkException(new RuntimeException
              ("Cannot get the last of an empty list"), d, "getLast");
      
      //removeFromHead
      t.checkException(new RuntimeException
           ("Cannot remove the first of an empty list"), d, "removeFromHead");
      
      //removeFromTail
      t.checkException(new RuntimeException
            ("Cannot remove the last of an empty list"), d, "removeFromTail");
      
      reset();
      //addAtHead (using getFirst and getLast size to check it)
      d.addAtHead("abc");
      
      //size
      t.checkExpect(d.size(), 1);
      
      //getFirst
      t.checkExpect(d.getFirst(), new Node ("abc", s, s));
      
      //getLast
      t.checkExpect(d.getLast(), new Node ("abc", s, s));
      
      //addAtTail (using getFirst and getLast and size to check)
      reset();
      d.addAtTail("abc");
      
      //getFirst
      t.checkExpect(d.getFirst(), new Node ("abc", s, s));
      
      //getLast
      t.checkExpect(d.getLast(), new Node ("abc", s, s));
      
      //size
      t.checkExpect(d.size(), 1);
      
      //insertSorted
      reset();
      d.insertSorted("a");
      t.checkExpect(d.size(), 1);
      t.checkExpect(d.getFirst(), new Node ("a", s, s ));
      t.checkExpect(d.getLast(), new Node ("a", s, s ));
      
     //removeSorted
      reset();
      t.checkException(new RuntimeException
              ("No such String in the list"), d, "removeSorted", "abc");
     
      
  }
  
  
  
}