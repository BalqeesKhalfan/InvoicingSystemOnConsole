import java.util.*;

public class InvoiceSystem {

    //FIXME: Two of these are never used

    private static Map<Integer, Integer> menuSelections = new HashMap<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop("Artificial Intelligence Center for selling technical devices");
        // use boolean to check if the program is running or not
        boolean isRunning = true; // Set the initial value to true

        while (isRunning) { // Use the boolean variable as the loop condition
            try {
                Menu.showMainMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                menuSelections.put(choice, menuSelections.getOrDefault(choice, 0) + 1);
                processMainMenu(choice, scanner, shop);
            } catch (InputMismatchException e) { // Catch InputMismatchException specifically
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            } catch (Exception e) { // Catch other exceptions
                System.out.println("An error occurred: " + e.getMessage());
                isRunning = false; // Set isRunning  false to exit the loop
            }
        }

    }
    static void processMainMenu(int choice, Scanner scanner, Shop shop) {
        switch (choice) {
            case 1:
                Menu.processShopSettingsMenu(scanner, shop);
                break;
            case 2:
                Menu.processManageShopItemsMenu(scanner, shop);
                break;
            case 3:
                Shop.createNewInvoiceMenu(shop, scanner);

                break;
            case 4:
                Invoice.statisticsMenu(shop);

                break;
            case 5:
                Invoice.reportAllInvoices(shop);

                break;
            case 6:
                Invoice.searchInvoicesMenu(shop, scanner);
                break;
            case 7:
                printMenuSelections();
                break;
            case 8:
                exitProgram(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 1 and 8.");
        }
    }



    public static void exitProgram(Scanner scanner) {
        System.out.print("Are you sure you want to exit? (y/n): ");
        String confirm = scanner.next();
        if (confirm.equalsIgnoreCase("y")) {
            System.out.println("Exiting program.");
            System.exit(0);
        } else if (confirm.equalsIgnoreCase("n")) {
            // Do nothing, just return from the method
        } else {
            System.out.println("Invalid choice. Please enter 'y' or 'n'.");
        }
    }

    //print Menu selection
    private static void printMenuSelections() {
        System.out.println("Program Statistics Menu:");
        for (Map.Entry<Integer, Integer> entry : menuSelections.entrySet()) {
            System.out.println("Menu Option " + entry.getKey() + ": " + entry.getValue() + " times selected");
        }
    }
}

