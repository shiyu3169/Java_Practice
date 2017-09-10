//assignment 7
// pair 134
// Singh, Bhavneet
// singhb
//Wang, Shiyu
//shiyu

// Represents a Bank with list of Accounts
public class Bank {
    
    String name;
    ILoA accounts;
    
    public Bank(String name) {
        this.name = name;

        // Each bank starts with no accounts
        this.accounts = new MtLoA();
    }
    
    /*TEMPLATE
     * FIELDS
     * ...this.name...        --String
     * ...this.accounts...    --ILoA
     * 
     * METHODS
     * ...this.add(Account)...         --void
     * ...this.deposit(int, int)...     --void
     * ...this.withdraw(int, int)...    --void
     * ...this.removeAccount(int)  --void
     * 
     * METHODS FOR FIELDS
     * ...this.accounts.countains(Account)...    --Boolean
     * ...this.accounts.deposit(int, int)...       --int
     * ...this.accounts.removeAccount(int)...  --ILoA
     * ...this.accounts.withdraw(int, int)...      --int
     * 
     */
    
    
    
    // Add a new Account to this Bank
    public void add(Account acct) {
        if (this.accounts.contains(acct))
            throw new RuntimeException("Account already exists.");
        else this.accounts = new ConsLoA(acct, this.accounts);

    }


    // Deposit the given amount into the Account associated with the
    //given account number in the List of Accounts in this Bank if possible
    public void deposit(int amount, int accNum) {
        if (amount <= 0)
        throw new RuntimeException("You cannot deposit nothing," +
        " and you cannot deposit a negative amount." +
        " Your foolish self must have been guilty" +
        " of one of these two actions.");
        else this.accounts = this.accounts.deposit(amount, accNum);
    }
    
    // Withdraw the given amount from the Account associated with the
    //given account number in the List of Accounts in this Bank if possible
    public void withdraw(int amount, int accNum) {
        if (amount > 0)
        this.accounts = this.accounts.withdraw(amount, accNum);
        else throw new RuntimeException("You cannot withdraw nothing," +
        " and you cannot withdraw a negative amount." +
        " Your foolish self must have been guilty" +
        " of one of these two actions.");
    }
    
    
    // Remove the Account associated with
    // the given account number from this Bank
    public void removeAccount(int acctNo) {
        this.accounts = this.accounts.removeAccount(acctNo);
    }
    
}
