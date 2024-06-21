import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Enter your customer ID: ");
        String id = sc.nextLine();

        BankAccount bk = new BankAccount(name, id);
        bk.showMenu();
        sc.close();
    }
}

class BankAccount {
    private int balance;
    private int previousTransaction;
    private String customerName;
    private String customerId;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
        } else {
            System.out.println("Please enter a valid amount.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0) {
            balance -= amount;
            previousTransaction = -amount;
        } else {
            System.out.println("Please enter a valid amount.");
        }
    }

    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred.");
        }
    }

    public void showMenu() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("=================");
            System.out.println("Enter an option:");
            System.out.println("=================");
            option = sc.next().charAt(0);
            option = Character.toUpperCase(option);

            switch (option) {
                case 'A':
                    System.out.println("Balance: " + getBalance());
                    break;

                case 'B':
                    System.out.println("Enter amount to deposit:");
                    int amount = sc.nextInt();
                    deposit(amount);
                    break;

                case 'C':
                    System.out.println("Enter amount to withdraw:");
                    int withdrawAmount = sc.nextInt();
                    withdraw(withdrawAmount);
                    break;

                case 'D':
                    System.out.println("Your previous transaction:");
                    getPreviousTransaction();
                    break;

                case 'E':
                    System.out.println("Exiting the menu.");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }

        } while (option != 'E');

        sc.close();
    }
}
