// represents a list of Person's buddies
interface ILoBuddy {

    // returns the number of people that are direct buddies 
    // of both this and that person
    public int countCommonBuddies(ILoBuddy that);
    
    // is the given person in this list
    public boolean in(Person given);
    
    // will the given person be invited to a party 
    // organized by this person?
    public boolean hasDistantBuddy(Person that, ILoBuddy remove);

    // returns the number of people who will show up at the party 
    // given by this person
    public int partyCount(ILoBuddy remove);
    
    // give the accumulator of the preceding function
    public ILoBuddy accumulate(ILoBuddy remove);
    
}
