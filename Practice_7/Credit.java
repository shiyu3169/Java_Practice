//assignment 7
// pair 134
// Singh, Bhavneet
// singhb
//Wang, Shiyu
//shiyu

// Represents a credit line account
public class Credit extends Account {

    int    creditLine; // Maximum amount accessible
    double interest;  // The interest rate charged

    public Credit(int accountNum, int balance, String name, int creditLine,
            double interest) {
        super(accountNum, balance, name);
        this.creditLine = creditLine;
        this.interest = interest;
    }
    
    /*TEMPLATE
     * FIELDS
     * ...this.accountNum...        --int
     * ...this.balance...           --int
     * ...this.name...              --String
     * ...this.creditLine...        --int
     * ...this.interest...          --interest
     * 
     * METHODS
     * ...this.accDep(int)...      --Account
     * ...this.deposit(int)...     --int
     * ...this.withdraw(int)...    --int
     * ...this.accWit(int)...      --Account
     *
     * 
     * METHODS FOR FIELDS
     * Built-in
     */

    // Withdraw the given amount from this Credit
    public int withdraw(int amount) {
        if ((this.balance + amount) > this.creditLine)
            throw new RuntimeException(
                             Integer.toString(amount)
                            + " is not available");
        else
            this.balance = this.balance + amount;
            return this.balance;
    }

    // Deposit the given funds into this Credit
    public int deposit(int funds) {
        if ((this.balance - funds) < 0)
            throw new RuntimeException
            ("Can't have no debt in a credit class");
        else this.balance = this.balance - funds;
            return this.balance;
    }

    // Return this Credit with the new balance, given the deposit amount
    public Account accDep(int amount) {
        return new Credit(this.accountNum, 
                          this.deposit(amount),
                          this.name, 
                          this.creditLine,
                          this.interest);
    }
    
    // Return this Credit with the new balance, given the withdrawal amount
    public Account accWit(int amount) {
        return new Credit(this.accountNum, 
                          this.withdraw(amount),
                          this.name, 
                          this.creditLine,
                          this.interest);
    }

}
