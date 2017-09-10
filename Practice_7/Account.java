//assignment 7
// pair 134
// Singh, Bhavneet
// singhb
//Wang, Shiyu
//shiyu

// Represents a bank account
public abstract class Account {

    int accountNum;  // Must be unique
    int balance; //Must remain above zero 
    //(others Accts have more restrictions)
    String name;     // Name on the account

    public Account(int accountNum, int balance, String name) {
        this.accountNum = accountNum;
        this.balance = balance;
        this.name = name;
    }
    
    
    

 // Withdraw the given amount from this Account
 abstract int withdraw(int amount);

// Deposit the given funds into this Account
// Return the new balance
abstract int deposit(int funds);

// Return this Account with the new balance, given the deposit amount
abstract Account accDep(int amount);

// Return this Account with the new balance, given the withdrawal amount
abstract Account accWit(int amount);

// is this the account based on the given number?


}
