package pack2;

import java.util.Scanner;
import pack1.BankAccount;
import pack1.CheckingAccount;
import pack1.SavingsAccount;
import pack1.Transaction;

public class BankingSystem {
    private static Scanner sc = new Scanner(System.in);
    private static BankAccount[] accounts = new BankAccount[100];
    private static Transaction[][] transactions = new Transaction[100][50];
    private static int accountCount = 0;
    private static int[] transactionCount = new int[100];

    protected static void createAccount() {
        System.out.println("Select Account Type: ");
        System.out.println("1. Savings Account");
        System.out.println("2. Checking Account");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter Initial Deposit: ₹");
        double deposit = sc.nextDouble();

        if (type == 1) {
            System.out.print("Enter Interest Rate (%): ");
            double rate = sc.nextDouble();
            accounts[accountCount] = new SavingsAccount(accNo, name, deposit, rate);
        } else if (type == 2) {
            System.out.print("Enter Overdraft Limit: ₹");
            double limit = sc.nextDouble();
            accounts[accountCount] = new CheckingAccount(accNo, name, deposit, limit);
        } else {
            System.out.println("Invalid account type!");
            return;
        }

        System.out.println("Account created successfully!");
        accountCount++;
    }

    protected static BankAccount findAccount(String accNo) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accNo)) {
                return accounts[i];
            }
        }
        return null;
    }

    protected static int getAccountIndex(String accNo) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accNo)) {
                return i;
            }
        }
        return -1;
    }

    protected static void depositMoney() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter Amount to Deposit: ₹");
            double amount = sc.nextDouble();
            acc.deposit(amount);
            int idx = getAccountIndex(accNo);
            transactions[idx][transactionCount[idx]++] = new Transaction("Deposit", amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    protected static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter Amount to Withdraw: ₹");
            double amount = sc.nextDouble();
            acc.withdraw(amount);
            int idx = getAccountIndex(accNo);
            transactions[idx][transactionCount[idx]++] = new Transaction("Withdraw", amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    protected static void viewBalance() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            acc.displayAccountInfo();
        } else {
            System.out.println("Account not found!");
        }
    }

    protected static void transferFunds() {
        System.out.print("Enter Source Account Number: ");
        String srcAcc = sc.nextLine();
        System.out.print("Enter Destination Account Number: ");
        String destAcc = sc.nextLine();
        System.out.print("Enter Amount to Transfer: ₹");
        double amount = sc.nextDouble();

        BankAccount from = findAccount(srcAcc);
        BankAccount to = findAccount(destAcc);

        if (from != null && to != null) {
            if (from.getBalance() >= amount) {
                from.withdraw(amount);
                to.deposit(amount);
                int srcIdx = getAccountIndex(srcAcc);
                int destIdx = getAccountIndex(destAcc);
                transactions[srcIdx][transactionCount[srcIdx]++] = new Transaction("Transfer Out", amount);
                transactions[destIdx][transactionCount[destIdx]++] = new Transaction("Transfer In", amount);
                System.out.println("Funds transferred successfully!");
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("One or both accounts not found!");
        }
    }

    protected static void viewTransactions() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        int idx = getAccountIndex(accNo);
        if (idx != -1) {
            System.out.println("Transaction History for Account " + accNo + ":");
            for (int i = 0; i < transactionCount[idx]; i++) {
                transactions[idx][i].printTransaction();
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    protected static void applyInterest() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        BankAccount acc = findAccount(accNo);
        if (acc != null && acc instanceof SavingsAccount) {
            ((SavingsAccount) acc).applyInterest();
        } else {
            System.out.println("Invalid account or not a savings account!");
        }
    }

    protected static void displayAllAccounts() {
        if (accountCount == 0) {
            System.out.println("No accounts available!");
            return;
        }
        for (int i = 0; i < accountCount; i++) {
            accounts[i].displayAccountInfo();
        }
    }
}
