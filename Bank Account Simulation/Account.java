import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountNumber;
    private String holderName;
    private double balance;
    private List<String> transactions;

    public Account(int accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: " + amount + " | Balance: " + balance);
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: " + amount + " | Balance: " + balance);
            System.out.println("Successfully withdrew ₹" + amount);
        } else {
            System.out.println("Invalid or insufficient funds!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactions() {
        System.out.println("\n--- Transaction History ---");
        for (String t : transactions) {
            System.out.println(t);
        }
    }

    @Override
    public String toString() {
        return "Account No: " + accountNumber + " | Holder: " + holderName + " | Balance: ₹" + balance;
    }
}
