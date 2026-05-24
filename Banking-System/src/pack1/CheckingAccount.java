package pack1;

public class CheckingAccount extends BankAccount {
     private double overdraftLimit;

    public CheckingAccount(String accNo, String name, double deposit, double overdraftLimit) {
        super(accNo, name, deposit);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount + " successfully!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + " successfully!");
        } else {
            System.out.println("Withdrawal exceeds overdraft limit or invalid amount!");
        }
    }

}
