import java.util.*;

public class InvoiceSystem {
    private static List<Item> items = new ArrayList<>(); // List to store all items
    private static List<Invoice> invoices = new ArrayList<>(); // List to store all invoices
    private static Map<Integer, Integer> menuSelections = new HashMap<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop("My Grocery Shop");

        while (true) {
            try {
                Menu.showMainMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                menuSelections.put(choice, menuSelections.getOrDefault(choice, 0) + 1);
                Menu.processMainMenu(choice, scanner, shop);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }

        }

    }
}

