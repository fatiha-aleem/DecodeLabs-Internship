import java.util.Scanner;

public class ATM {

    static String accountHolder = "Ali";
    static String accountNumber = "123456789";
    static double balance = 5000.00;

    static void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit must be greater than 0.");
        } else {
            balance = balance + amount;
            System.out.println("Deposit successful!");
            System.out.println("Deposited amount: $" + amount);
            System.out.println("New balance: $" + balance);
        }
    }

    static void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance = balance - amount;
            System.out.println("Withdrawal successful!");
            System.out.println("Withdrawn amount: $" + amount);
            System.out.println("Remaining balance: $" + balance);
        }
    }

    static void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    static void displayMenu() {
        System.out.println("\n========== ATM MENU ==========");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.println("==============================");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("       WELCOME TO ATM");
        System.out.println("================================");

        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);

        int choice;

        do {
            displayMenu();

            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");

                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid amount. Please enter a number.");
                        scanner.next();
                        System.out.print("Enter amount to deposit: ");
                    }

                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");

                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid amount. Please enter a number.");
                        scanner.next();
                        System.out.print("Enter amount to withdraw: ");
                    }

                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }

        } while (choice != 4);

        scanner.close();
    }
}