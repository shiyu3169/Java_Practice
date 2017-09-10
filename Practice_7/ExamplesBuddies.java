import tester.*;


// runs tests for the buddies problem
public class ExamplesBuddies{
  
  ILoBuddy mt = new MTLoBuddy();
  
  Person ann = new Person("ann");
  Person bob = new Person("bob");
  Person cole = new Person("cole");
  Person dan = new Person("dan");
  Person ed = new Person("ed");
  Person fay = new Person("fay");
  Person gabi = new Person("Gabi");
  Person hank = new Person("hank");
  Person jan = new Person("Jan");
  Person kim = new Person("kim");
  Person len = new Person("Len");

  
   void initBuddies() {
    ann.addBuddy(bob);
    ann.addBuddy(cole);
    bob.addBuddy(ann);
    bob.addBuddy(ed);
    bob.addBuddy(hank);
    cole.addBuddy(dan);
    dan.addBuddy(cole);
    ed.addBuddy(fay);
    fay.addBuddy(ed);
    fay.addBuddy(gabi);
    gabi.addBuddy(ed);
    gabi.addBuddy(fay);
    jan.addBuddy(len);
    jan.addBuddy(kim);
    kim.addBuddy(jan);
    kim.addBuddy(len);
    len.addBuddy(jan);
    len.addBuddy(kim);
  }
  

   void testall(Tester t) {
       initBuddies(); 
       initBuddies();
       initBuddies(); 
       
  //test for handDirectBuddy
       t.checkExpect(ann.hasDirectBuddy(bob), true);
       t.checkExpect(ann.hasDirectBuddy(ann), false);
       t.checkExpect(bob.hasDirectBuddy(dan), false);
              
       
  //test for hasDistantBuddy in Person class
       t.checkExpect(ann.hasDistantBuddy(ed), true);
       t.checkExpect(hank.hasDistantBuddy(kim), false); 
       t.checkExpect(kim.hasDistantBuddy(bob), false);
       t.checkExpect(bob.hasDistantBuddy(kim), false);
       t.checkExpect(ann.hasDistantBuddy(gabi), true);
        

  //test for partyCount in Person class
       t.checkExpect(ann.partyCount(), 8);
       t.checkExpect(bob.partyCount(), 8);
       t.checkExpect(hank.partyCount(), 1); 
       t.checkExpect(len.partyCount(), 3);
       t.checkExpect(kim.partyCount(), 3);
       t.checkExpect(fay.partyCount(), 3);
    
       
  //test for countCommonBuddies in Person class
      t.checkExpect(ann.countCommonBuddies(bob), 0);
      t.checkExpect(kim.countCommonBuddies(jan), 1);
      t.checkExpect(ann.countCommonBuddies(ann), 2);

  
  //test for in in MTLoBuddy class
      t.checkExpect(mt.in(ann), false);
      t.checkExpect(mt.in(hank), false);
  
  
  //test for partyCount in MTLoBuddy class
      t.checkExpect(mt.partyCount(ann.buddies), 0);
      t.checkExpect(hank.buddies.partyCount(hank.buddies), 0);

  
  //test for countCommonBuddies in MTLobuddy class
      t.checkExpect(mt.countCommonBuddies(ann.buddies), 0);
      t.checkExpect(mt.countCommonBuddies(hank.buddies), 0);
  
      
  //test for hasDistantbuddy in MTLoBuddy class
      t.checkExpect(mt.hasDistantBuddy(ann, mt), false);
      t.checkExpect(mt.hasDistantBuddy(bob, ann.buddies), false);
 
  
  //test for accumulate in MTLobuddy class
      t.checkExpect(mt.accumulate(mt), mt);
      t.checkExpect(mt.accumulate(ann.buddies), ann.buddies);
  
  
  //test for in in ConsLoBuddy class
      t.checkExpect(ann.buddies.in(bob), true);
      t.checkExpect(bob.buddies.in(kim), false);
      t.checkExpect(bob.buddies.in(bob), false);
  
  
  //test for partyCount in ConsLobuddy class
      t.checkExpect(ann.buddies.partyCount(mt), 8);
      t.checkExpect(bob.buddies.partyCount(bob.buddies), 0);
      
  
  //test for countCommonBuddies in ConsLobuddy class
      t.checkExpect(ann.buddies.countCommonBuddies(bob.buddies), 0);
      t.checkExpect(bob.buddies.countCommonBuddies(fay.buddies), 1);
  
      
  //test for hasDistantBuddy in ConsLobuddy class
      t.checkExpect(ann.buddies.hasDistantBuddy(bob, mt), true);
      t.checkExpect(ann.buddies.hasDistantBuddy(bob, ann.buddies), false);
      t.checkExpect(ann.buddies.hasDistantBuddy(kim, mt), false);
   
   
   //test for accumulate in ConsLobuddy class
      t.checkExpect(cole.buddies.accumulate(mt), cole.buddies);
      t.checkExpect(ann.buddies.accumulate(cole.buddies), 
              (new ConsLoBuddy(bob,
                      (new ConsLoBuddy (cole, (new ConsLoBuddy(dan, mt)))))));
   }
}

