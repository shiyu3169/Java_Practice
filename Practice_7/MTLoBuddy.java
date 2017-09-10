// represents an empty list of Person's buddies
class MTLoBuddy implements ILoBuddy {
  MTLoBuddy() { }
 
  /*TEMPLATE
   * FIELDS
   * None
   *
   * METHODS:
   * ...this.in(Person)...                         -- Boolean
   * ...this.partyCount(ILoBoddy)...               -- int
   * ...this.countCommonBuddies(buddies)..         -- int
   * ...this.hasDistantBuddy(person, IloBuddy)...  -- Boolean
   * ...this.accumulate(ILoBuddy)...               -- ILoBuddy
   * 
   * METHODS FOR FIELDS:
   * Built-in
   */
  
  // returns the number of people that are direct buddies 
  // of both this and that person
  public int countCommonBuddies(ILoBuddy that) {
    return 0;
  }
  
  // is the given person in this list
  public boolean in(Person given) {
      return false;
  }
  
  // will the given person be invited to a party 
  // organized by this person?
  public boolean hasDistantBuddy(Person that, ILoBuddy remove) {
      return false;
  }
  
  // returns the number of people who will show up at the party 
  // given by this person
  public int partyCount(ILoBuddy remove) {
    return 0;
  }
  
  // give the accumulator of the preceding function
  public ILoBuddy accumulate(ILoBuddy remove) {
      return remove;
  }

  
}
