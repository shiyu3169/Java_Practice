//assignment 7
// pair 134
// Singh, Bhavneet
// singhb
//Wang, Shiyu
//shiyu

// Represents a savings Account
public class Savings extends Account {

    double interest; // The interest rate

    public Savings(int accountNum, int balance, String name, double interest) {
        super(accountNum, balance, name);
        this.interest = interest;
    }
    
    /*TEMPLATE
     * FIELDS
     * ...this.accountNum...        --int
     * ...this.balance...           --int
     * ...this.name...              --String
     * ...this.interest...          --double
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

    // Withdraw the given amount from this Savings
    public int withdraw(int amount) {
        if ((this.balance - amount) < 0)
            throw new RuntimeException(
                              Integer.toString(amount)
                            + " is not available");
        else
            this.balance = this.balance - amount;
            return this.balance;
    }

    // Deposit the given funds into this Savings
    public int deposit(int funds) {
        this.balance = this.balance + funds;
        return this.balance;
    }

    // Return this Savings with the new balance, given the deposit amount
    public Account accDep(int amount) {
        return new Savings(this.accountNum, this.deposit(amount), this.name,
                this.interest);
    }

    // Return this Savings with the new balance, given the withdrawal amount
    public Account accWit(int amount) {
        return new Savings(this.accountNum, this.withdraw(amount), this.name,
                this.interest);
    }

}
