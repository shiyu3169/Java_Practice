/*   +----------------+
 *   |     Person     |------------------------------------------+
 *   +----------------+                                          |
 *   |String username |                                          |
 *   |ILoBuddy Buddies|----------+                               |
 *   +----------------+          |  +------------------+         |
 *                               +->|Interface ILoBuddy|---------|--+
 *                                  +--------+---------+         |  |
 *                                           |                   |  |
 *                                          / \                  |  |          
 *                                 +-------------------+         |  |
 *                                 |                   |         |  |
 *                          +------+------+     +------+------+  |  |  
 *                          |  MTLoBuddy  |     | ConsLoBuddy |  |  |
 *                          +-------------+     +-------------+  |  |
 *                          |             |     |person first |--+  |
 *                          +-------------+     |ILoBuddy rest|-----+
 *                                              +-------------+                
 */                                             


// represents a Person with a user name and a list of buddies
class Person {

  String username;
  ILoBuddy buddies;
  
  Person(String username) {
    this.username = username;
    this.buddies = new MTLoBuddy();
  }
  /*TEMPLATE
   * FIELDS:
   * ...this.username...                  -- String
   * ...this.buddies...                   -- ILoBuddy
   * 
   * METHODS:
   * ...this.hasDirectBuddy(Person)...    -- Boolean
   * ...this.PartyCount()...              -- int
   * ...this.countCommonBuddies(Person).. -- int
   * ...this.hasDistantbuddiy(Person)...  -- Boolean
   * ...this.addBuddy(Person)...          --void
   * 
   * METHODS FOR FIELDS:
   * ...this.buddies.in(Person)...                         -- Boolean
   * ...this.buddies.PartyCount(ILoBoddy)...               -- int
   * ...this.buddies.countCommonBuddies(buddies)..         -- int
   * ...this.buddies.hasDistantbuddiy(person, IloBuddy)... -- Boolean
   * 
   */
  
  
  // returns true if this Person has that as a direct buddy
  public boolean hasDirectBuddy(Person that) {
    return buddies.in(that);
  }
  
  // returns the number of people who will show up at the party 
  // given by this person
  public int partyCount() {
      return 1 + this.buddies.partyCount(new ConsLoBuddy
              (this, new MTLoBuddy()));
  }

  // returns the number of people that are direct buddies 
  // of both this and that person
  public int countCommonBuddies(Person that) {
    return this.buddies.countCommonBuddies(that.buddies);
  }

  
  // will the given person be invited to a party 
  // organized by this person?
  public boolean hasDistantBuddy(Person that) {
    return this.buddies.hasDistantBuddy(that,
            new ConsLoBuddy(this, new MTLoBuddy()));
  }
  
  //Change this person's buddy list so that it includes the given person
  public void addBuddy(Person buddy) {
      if (!this.buddies.in(buddy)) 
      this.buddies = new ConsLoBuddy(buddy, buddies);
  }


 
}
