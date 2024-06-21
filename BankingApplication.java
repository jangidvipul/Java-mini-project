import java.util.ArrayList;
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
    private ArrayList<String> miniStatement = new ArrayList<>();

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
            miniStatement.add("Deposited: " + amount);
        } else {
            System.out.println("Please enter a valid amount.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            previousTransaction = -amount;
            miniStatement.add("Withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
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

    public void showMiniStatement() {
        System.out.println("Mini Statement:");
        for (String transaction : miniStatement) {
            System.out.println(transaction);
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
        System.out.println("E. Mini Statement");
        System.out.println("F. Exit");

        while (option != 'F') 
        {
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
                    sc.nextLine(); // Consume the newline character
                    deposit(amount);
                    break;

                case 'C':
                    System.out.println("Enter amount to withdraw:");
                    int withdrawAmount = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                    withdraw(withdrawAmount);
                    break;

                case 'D':
                    System.out.println("Your previous transaction:");
                    getPreviousTransaction();
                    break;

                case 'E':
                    System.out.println("Showing mini statement:");
                    showMiniStatement();
                    break;

                case 'F':
               System.out.println("Exiting the menu.");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }

        }

        sc.close();
    }
}
