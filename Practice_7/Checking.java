//assignment 7
// pair 134
// Singh, Bhavneet
// singhb
//Wang, Shiyu
//shiyu

// Represents a checking Account
public class Checking extends Account {

    int minimum; // The minimum Account balance allowed

    public Checking(int accountNum, int balance, String name, int minimum) {
        super(accountNum, balance, name);
        this.minimum = minimum;
    }
    
    /*TEMPLATE
     * FIELDS
     * ...this.accountNum...        --int
     * ...this.balance...           --int
     * ...this.name...              --String
     * ...this.minimum...           --int
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
    

    // Withdraw the given amount from this Checking
    public int withdraw(int amount) {
        if ((this.balance - amount) < this.minimum)
            throw new RuntimeException(
                            Integer.toString(amount)
                            + " is not available");
        else
            this.balance = this.balance - amount;
            return this.balance;
    }

    // Deposit the given funds into this Checking
    public int deposit(int funds) {
        this.balance = this.balance + funds;
        return this.balance;
    }

    // Return this Checking with the new balance, given the deposit amount
    public Account accDep(int amount) {
        return new Checking(this.accountNum, this.deposit(amount), this.name,
                this.minimum);
    }

    // Return this Checking with the new balance, given the withdrawal amount
    public Account accWit(int amount) {
        return new Checking(this.accountNum, this.withdraw(amount), this.name,
                this.minimum);
    }

}
