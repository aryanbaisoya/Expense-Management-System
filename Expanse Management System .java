import java.util.*;

class Expense {
    private String category;
    private double amount;

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() { return category; }
    public double getAmount() { return amount; }
}

public class ExpenseManager {
    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(String category, double amount) {
        expenses.add(new Expense(category, amount));
        System.out.println("Expense added successfully.");
    }

    public void viewExpenses() {
        double total = 0;
        System.out.println("\n--- Expense List ---");
        for (Expense e : expenses) {
            System.out.println(e.getCategory() + ": ₹" + e.getAmount());
            total += e.getAmount();
        }
        System.out.println("Total: ₹" + total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) {
            System.out.println("\n1. Add Expense\n2. View Expenses\n3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter category: ");
                String category = sc.next();
                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();
                manager.addExpense(category, amount);
            } else if (choice == 2) {
                manager.viewExpenses();
            } else {
                System.out.println("Goodbye!");
                break;
            }
        }

        sc.close();
    }
}