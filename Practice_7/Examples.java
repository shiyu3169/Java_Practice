//assignment 7
// pair 134
// Singh, Bhavneet
// singhb
//Wang, Shiyu
//shiyu

import tester.*;

// Bank Account Examples and Tests
public class Examples {

    public Examples() {
        reset();
    }

    Account check1;
    Account savings1;
    Account credit1;
    Account check2;
    Account check1a;
    Account savings2;
    Account credit2;
    Bank    bank1 = new Bank("bank1");
    Bank    bank2 = new Bank("bank2");
    Bank    bank3 = new Bank("bank1");
    ILoA    mt = new MtLoA();

    // Initializes Accounts to use for testing with effects.
    // We place inside reset() so we can "reuse" the Accounts
    public void reset() {

        // Initialize the Account examples
        check1 = new Checking(1, 100, "First Checking Account", 20);
        savings1 = new Savings(4, 200, "First Savings Account", 2.5);
        credit1 = new Credit(5, 400, "First Credit Account", 1000, 2.0);
        check2 = new Checking(2, 500, "Second Checking Account", 50);
        savings2 = new Savings(3, 300, "Second Savings Account", 2.0);
        credit2 = new Credit(6, 600, "Second Credit Account", 2000, 1.5);
        bank1.add(check1);
        bank1.add(savings1);
        bank1.add(credit1);
        bank2.add(check2);
        bank2.add(savings2);
        bank2.add(credit2);
        bank3.add(new Checking(1, 90, "First Checking Account", 20));
        bank3.add(new Savings(4, 220, "First Savings Account",
                2.5));
        bank3.add(new Credit(5, 350, "First Credit Account", 1000,
                2.0));
        bank2.removeAccount(2);
    }
    
    
    // Tests the exceptions we expect to be thrown when
    // performing an "illegal" action.
    public void testExceptions(Tester t) {

        

        // account not in list to withdraw
        t.checkException(
                "Test for invalid Bank withdraw",
                new RuntimeException
                ("No such account exists to withdraw from."),
                this.bank1, "withdraw", 200, 2);
        // given negative withdrawal
        t.checkException("Test for invalid Bank withdraw",
                new RuntimeException("You cannot withdraw nothing,"
                        + " and you cannot withdraw a negative amount."
                        + " Your foolish self must have been guilty"
                        + " of one of these two actions."), this.bank2,
                "withdraw", -100, 3);
        // amount not available for withdrawal Checking
        t.checkException("Test for invalid Checking withdraw",
                new RuntimeException("1000 is not available"), this.check1,
                "withdraw", 1000);
        // amount not available for withdrawal Savings
        t.checkException("Test for invalid Savings withdraw",
                new RuntimeException("2000 is not available"), this.savings1,
                "withdraw", 2000);
        // amount not available for withdrawal Credit
        t.checkException("Test for invalid Credit withdraw",
                new RuntimeException("7000 is not available"), this.credit1,
                "withdraw", 7000);
        // no such account deposit
        t.checkException("Test for invalid Bank deposit",
                new RuntimeException(
                "No such account exists to deposit the amount in."),
                this.bank1, "deposit", 200, 2);
        // negative deposit
        t.checkException("Test for invalid Bank deposit", 
                new RuntimeException(
                "You cannot deposit nothing,"
                        + " and you cannot deposit a negative amount."
                        + " Your foolish self must have been guilty"
                        + " of one of these two actions."), this.bank2,
                "deposit", -100, 3);
        // deposit exceeds credit limit
        t.checkException("Test for invalid Credit deposit",
                new RuntimeException("Can't have no debt in a credit class"),
                this.credit1, "deposit", 7000);
        // test add buddy exception if account already in bank
        t.checkException("Test for duplicate account in a bank",
                new RuntimeException("Account already exists."), this.bank1,
                "add", this.check1);
        
        t.checkException("Test for remove account in empty list",
                new RuntimeException("No such account exists for removal."), 
                this.mt,
                "removeAccount", this.check1.accountNum);
      

    }

    // Test the deposit method(s)
    public void testDeposit(Tester t) {
       
        

        // given test from assignment: but it makes no sense for this to be here
        t.checkExpect(check1.withdraw(25), 75);
        t.checkExpect(check1, new Checking
                (1, 75, "First Checking Account", 20));

        
        // Checking class
        t.checkExpect(check1.deposit(15), 90);
        t.checkExpect(check1, new Checking
                (1, 90, "First Checking Account", 20));

        // Saving class
        t.checkExpect(savings1.deposit(20), 220);
        t.checkExpect(savings1, new Savings(4, 220, "First Savings Account",
                2.5));

        // Credit class
        t.checkExpect(credit1.deposit(50), 350);
        t.checkExpect(credit1, new Credit(5, 350,
                "First Credit Account", 1000,
                2.0));

        //ConsLoA class
        t.checkExpect(bank1.accounts.deposit(100, 5), 
                new ConsLoA(new Credit(5, 250, "First Credit Account",
                        1000, 2.0),
                        new ConsLoA(savings1, 
                                new ConsLoA(check1, mt))));
        
        t.checkExpect(bank1.accounts.deposit(100, 4), 
                new ConsLoA(credit1,
                        new ConsLoA(new Savings
                                (4, 320, "First Savings Account", 2.5), 
                                new ConsLoA(check1, mt))));
        t.checkExpect(bank1.accounts.deposit(7000, 1), 
                new ConsLoA(credit1,
                        new ConsLoA(savings1, 
                                new ConsLoA(
                                   new Checking(1, 7090,
                                      "First Checking Account", 20), mt)))); 
        
        
    }
    
    //test the method contains 
    public void testContains(Tester t) {
       
       
        //MtLoA class
        t.checkExpect(mt.contains(check1), false);
        
        //ConsLoA class
        t.checkExpect(bank1.accounts.contains(check1), true);
        t.checkExpect(bank1.accounts.contains(check2), false);
        
        
    }
    

  //test the method contains 
    public void testRemove(Tester t) {
        
        t.checkExpect(bank1.accounts.removeAccount(1), 
                new ConsLoA(credit1,
                        new ConsLoA(savings1, mt)));
        t.checkExpect(bank1.accounts.removeAccount(5), 
                new ConsLoA(savings1,
                        new ConsLoA(check1, mt)));
        
        
    }
    
    // Test the deposit method(s)
    public void testWithdraw(Tester t) {
        
        // Checking class
        t.checkExpect(check1.withdraw(15), 7075);
        t.checkExpect(check1, new Checking
                (1, 7075, "First Checking Account", 20));

        // Saving class
        t.checkExpect(savings1.withdraw(20), 300);
        t.checkExpect(savings1, new Savings(4, 300, "First Savings Account",
                2.5));

        // Credit class
        t.checkExpect(credit1.withdraw(50), 300);
        t.checkExpect(credit1, new Credit
                (5, 300, "First Credit Account", 1000,
                2.0));

        //ConsLoA class
        t.checkExpect(bank1.accounts.withdraw(100, 5), 
                new ConsLoA(new Credit
                        (5, 400, "First Credit Account", 1000, 2.0),
                        new ConsLoA(savings1, 
                                new ConsLoA(check1, mt))));
        
        t.checkExpect(bank1.accounts.withdraw(100, 4), 
                new ConsLoA(credit1,
                        new ConsLoA(new Savings
                                (4, 200, "First Savings Account", 2.5), 
                                new ConsLoA(check1, mt))));
        t.checkExpect(bank1.accounts.withdraw(10, 1), 
                new ConsLoA(credit1,
                        new ConsLoA(savings1, 
                                new ConsLoA(
                                   new Checking(1, 7065,
                                      "First Checking Account", 20), mt))));  
    }
    
    // test the accDep method
    public void testAccDep(Tester t) {
        //Checking class
        t.checkExpect(check1.accDep(50), new Checking(1, 7115,
                "First Checking Account", 20));
        //Savings class
        t.checkExpect(savings1.accDep(50), 
                new Savings(4, 250, "First Savings Account", 2.5));
        //Credit class
        t.checkExpect(credit1.accDep(50), 
                new Credit(5, 350, "First Credit Account", 1000, 2.0));
    }
    
    
    // test the accWit method
    public void testAccWit(Tester t) {
        //Checking class
        t.checkExpect(check1.accWit(50), new Checking(1, 7065,
                "First Checking Account", 20));
        //Savings class
        t.checkExpect(savings1.accWit(50), 
                new Savings(4, 200, "First Savings Account", 2.5));
        //Credit class
        t.checkExpect(credit1.accWit(50), 
                new Credit(5, 400, "First Credit Account", 1000, 2.0));
    }
    

}
