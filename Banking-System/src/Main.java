import pack2.BankingSystem;
import java.util.Scanner;

public class Main extends BankingSystem {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n====== BANKING SYSTEM MENU ======");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Account Balance");
            System.out.println("5. Transfer Funds");
            System.out.println("6. View Transaction History");
            System.out.println("7. Apply Interest (Savings Only)");
            System.out.println("8. Display All Accounts");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    viewBalance();
                    break;
                case 5:
                    transferFunds();
                    break;
                case 6:
                    viewTransactions();
                    break;
                case 7:
                    applyInterest();
                    break;
                case 8:
                    displayAllAccounts();
                    break;
                case 9:
                    System.out.println("Thank you for using the banking system!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 9);
    }

}
