import java.util.*;

public class InvoiceSystem {

    private static Map<Integer, Integer> menuSelections = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop("Artificial Intelligence Center for selling technical devices");

        boolean isRunning = true;

        while (isRunning) {
            try {
                Menu.showMainMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (isValidChoice(choice)) { // Validate the user's choice
                    menuSelections.put(choice, menuSelections.getOrDefault(choice, 0) + 1);
                    processMainMenu(choice, scanner, shop);
                } else {
                    System.out.println("Invalid choice. Please choose a number between 1 and 8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                isRunning = false;
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
        String confirm = scanner.nextLine().trim().toLowerCase(); // Normalize input
        if (confirm.equals("y")) {
            System.out.println("Exiting program.");
            System.exit(0);
        } else if (!confirm.equals("n")) {
            System.out.println("Invalid choice. Please enter 'y' or 'n'.");
        }
    }

    private static void printMenuSelections() {
        System.out.println("Program Statistics Menu:");
        for (Map.Entry<Integer, Integer> entry : menuSelections.entrySet()) {
            System.out.println("Menu Option " + entry.getKey() + ": " + entry.getValue() + " times selected");
        }
    }

    // Validate user's choice
    private static boolean isValidChoice(int choice) {
        return choice >= 1 && choice <= 8;
    }
}
