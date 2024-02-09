public class Account {
    private int accountID;
    private String accountOwner;
    private double balance;

    public Account(int accountID, String accountOwner, double balance) {
        this.accountID = accountID;
        this.accountOwner = accountOwner;
        this.balance = balance;
    }

    public String toString() {
        // Return string format( accountID, accountOwner, balance )
        return "AccountID: " + accountID + "\nAccountName: " + accountOwner + "\nBalance: " + balance;
    
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Amount must be positive");
        }

    }

    public void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
        }
        else {
            System.out.println("Insufficient funds");
        
        }
    
    }

}