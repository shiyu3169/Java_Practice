// represents a list of Person's buddies
class ConsLoBuddy implements ILoBuddy {

  Person first;
  ILoBuddy rest;
  
  ConsLoBuddy(Person first, ILoBuddy rest) {
    this.first = first;
    this.rest = rest;
  }
  /*TEMPLATE
   * FIELDS
   * ...this.first...                             -- Person
   * ...this.rest...                              -- ILoBuddy
   *
   * METHODS:
   * ...this.in(Person)...                        -- Boolean
   * ...this.partyCount(ILoBoddy)...              -- int
   * ...this.countCommonBuddies(buddies)..        -- int
   * ...this.hasDistantBuddy(person, IloBuddy)..  -- Boolean
   * ...this.accumulate(ILoBuddy)...              -- ILoBuddy
   * 
   * METHODS FOR FIELDS:
   * ...this.rest.in(Person)...                         -- Boolean
   * ...this.rest.partyCount(ILoBoddy)...               -- int
   * ...this.rest.countCommonBuddies(buddies)..         -- int
   * ...this.rest.hasDistantBuddy(person, IloBuddy)..   -- Boolean
   * ...this.rest.accumulate(ILoBuddy)...               -- ILoBuddy
   */
  
    
  // returns the number of people that are direct buddies 
  // of both this and that person
  public int countCommonBuddies(ILoBuddy that) {
    if (that.in(this.first))
        return 1 + this.rest.countCommonBuddies(that);
    else return  this.rest.countCommonBuddies(that);
  }
  
  // is the given person in this list
  public boolean in(Person given) {
      return given.equals(this.first) || this.rest.in(given);
  }
 
  // will the given person be invited to a party 
  // organized by this person?
  public boolean hasDistantBuddy(Person that, ILoBuddy remove) {
      if (remove.in(this.first))
          return this.rest.hasDistantBuddy(that, remove);
      else return this.first.buddies.hasDistantBuddy
              (that, new ConsLoBuddy(this.first, remove))
              || this.rest.hasDistantBuddy
              (that, new ConsLoBuddy(this.first, remove))
              || this.first.equals(that);
  }
  
  // returns the number of people who will show up at the party 
  // given by this person
  public int partyCount(ILoBuddy remove) {
      if (remove.in(this.first))
          return this.rest.partyCount(remove);
      else return 1 + this.first.buddies.partyCount
              (new ConsLoBuddy(this.first, remove))
              + this.rest.partyCount(this.first.buddies.accumulate
                      (new ConsLoBuddy(this.first, remove)));
  }
  
  // give the accumulator of the preceding function
  public ILoBuddy accumulate(ILoBuddy remove) {
      return this.rest.accumulate(new ConsLoBuddy(this.first, remove));
  }

}
