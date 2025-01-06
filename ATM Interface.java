import java.util.Scanner;

// Class to represent a Bank Account
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance invalid. Setting to 0.");
        }
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance for this withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be greater than 0.");
        }
    }

    // Method to check balance
    public double checkBalance() {
        return balance;
    }
}

// Class to represent the ATM Machine
class ATM {
    private BankAccount account;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Display menu and handle user input
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Current balance: $" + account.checkBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

// Main class to run the program
public class ATMInterface {
    public static void main(String[] args) {
        // Initialize a bank account with a starting balance
        BankAccount userAccount = new BankAccount(500.0); // Example starting balance

        // Create ATM instance and start it
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
