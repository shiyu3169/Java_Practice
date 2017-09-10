//assignment 7
// pair 134
// Singh, Bhavneet
// singhb
//Wang, Shiyu
//shiyu

// Represents a non-empty List of Accounts
public class ConsLoA implements ILoA{

    Account first;
    ILoA rest;

    public ConsLoA(Account first, ILoA rest) {
        this.first = first;
        this.rest = rest;
    }
    
    /*TEMPLATE
     * FIELDS
     * ...this.first...      --Account
     * ...this.rest...       --ILoA
     * 
     * METHODS
     * ...this.contain(Account)...     --boolean
     * ...this.deposit(int, int)...     --ILoA
     * ...this.withdraw(int, int)...    --ILoA
     * ...this.removeAccount(int)  --ILoA
     *
     * 
     * METHODS FOR FIELDS
     * ...this.first.accDep(int)...     --Account
     * ...this.first.accwit(int)...     --Account
     * ...this.rest.contain(Account)...     --boolean
     * ...this.rest.deposit(int,int)...          --ILoA
     * ...this.rest.withdraw(int,int)...         --ILoA
     * ...this.rest.removeAccount(int)...       --ILoA
     */

    

    // Does this nonempty list of accounts contain the given account?
    public boolean contains(Account that) {
        return this.first.equals(that) || this.rest.contains(that);
    }
    
    // Deposit the given amount into the Account associated with the 
    // given account number in this nonempty List of Accounts if possible
    public ILoA deposit(int amount, int accNum) {
        if (this.first.accountNum == accNum)
            return new ConsLoA(this.first.accDep(amount), this.rest);
        else return new ConsLoA
                (this.first, this.rest.deposit(amount, accNum));
    }
    
    // Withdraw the given amount from the Account associated with the 
    // given account number in this nonempty List of Accounts if possible
    public ILoA withdraw(int amount, int accNum) {
        if (accNum == this.first.accountNum)
            return new ConsLoA(this.first.accWit(amount), this.rest);
        else return new ConsLoA
                (this.first, this.rest.withdraw(amount, accNum));
    }
    
    // Remove the Account associated with the given account number
    // in this nonempty List of Accounts
    public ILoA removeAccount(int acctNo) {
        if (this.first.accountNum == acctNo)
            return this.rest;
        else return new ConsLoA(this.first, this.rest.removeAccount(acctNo));
    }
    
}