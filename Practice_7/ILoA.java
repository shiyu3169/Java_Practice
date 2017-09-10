//assignment 7
// pair 134
// Singh, Bhavneet
// singhb
//Wang, Shiyu
//shiyu

// Represents a List of Accounts
public interface ILoA{

    // Does this list of Accounts contain the given Account?
    public boolean contains(Account that);
    
    // Deposit the given amount into the Account associated with the 
    // given account number in this List of Accounts if possible
    public ILoA deposit(int amount, int accNum);
    
    // Withdraw the given amount from the Account associated with the 
    // given account number in this List of Accounts if possible
    public ILoA withdraw(int amount, int accNum);
    
    // Remove the Account associated with the given account number
    // from this List of Accounts
    public ILoA removeAccount(int acctNo);
}

