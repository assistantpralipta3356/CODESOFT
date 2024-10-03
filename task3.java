import java.util.*;
public class task3 {
    private BankAccount userAccount;
    private Scanner scanner;
    
    public task3() {
        scanner = new Scanner(System.in);
        userAccount = new BankAccount(1000.0); // Starting balance
    }
    
    public void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private void displayMenu() {
        System.out.println("\n=== ATM Menu ===");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.println("Enter your choice:");
    }
    
    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f\n", userAccount.getBalance());
    }
    
    private void deposit() {
        System.out.println("Enter amount to deposit:");
        double amount = scanner.nextDouble();
        if (userAccount.deposit(amount)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    
    private void withdraw() {
        System.out.println("Enter amount to withdraw:");
        double amount = scanner.nextDouble();
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
    
    public static void main(String[] args) {
        task3 atm = new task3();
        atm.start();
    }
}

class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
    
