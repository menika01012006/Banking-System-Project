package pack1;

 public abstract class BankAccount {
    private String accountnumber;
    private String accountholder;
    protected double balance;

    public BankAccount(String accountnumber, String accountholder, double balance) {
        this.accountholder = accountholder;
        this.accountnumber = accountnumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountnumber;
    }

    public String getAccountholder() {
        return accountholder;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public void displayAccountInfo() {
        System.out.println("----------------------------------");
        System.out.println("Account Number: " + accountnumber);
        System.out.println("Account Holder: " + accountholder);
        System.out.println("Current Balance: ₹" + balance);
        System.out.println("----------------------------------");
    }

}
