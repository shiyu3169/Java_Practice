//assignment 7
// pair 134
// Singh, Bhavneet
// singhb
//Wang, Shiyu
//shiyu

// Represents the empty List of Accounts
public class MtLoA implements ILoA {

    MtLoA() {
    }
    /*TEMPLATE
     * FIELDS
     * None
     * 
     * METHODS
     * ...this.contain(Account)...     --boolean
     * ...this.deposit(int, int)...     --ILoA
     * ...this.withdraw(int, int)...    --ILoA
     * ...this.removeAccount(int)  --ILoA
     *
     * 
     * METHODS FOR FIELDS
     * Built-in
     */

    // Does this empty list of Accounts contain the given Account?
    public boolean contains(Account that) {
        return false;
    }

    // Deposit the given amount into the Account associated with the
    // given account number in this empty List of Accounts if possible
    public ILoA deposit(int amount, int accNum) {
        throw new RuntimeException
        ("No such account exists to deposit the amount in.");
    }
    
    // Withdraw the given amount from the Account associated with the
    // given account number in this empty List of Accounts if possible
    public ILoA withdraw(int amount, int accNum) {
        throw new RuntimeException
        ("No such account exists to withdraw from.");
    }
    
    // Remove the Account associated with the given account number
    // in this empty List of Accounts
    public ILoA removeAccount(int acctNo) {
        throw new RuntimeException("No such account exists for removal.");
    }
    
}
