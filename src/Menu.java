import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private static Map<Integer, Integer> menuSelections = new HashMap<>();
    // Method to show Main Menu
    public static void showMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1- Shop Settings");
        System.out.println("2- Manage Shop Items");
        System.out.println("3- Create New Invoice");
        System.out.println("4- Report: Statistics");
        System.out.println("5- Report: All Invoices");
        System.out.println("6- Search Invoices");
        System.out.println("7- Program Statistics");
        System.out.println("8- Exit");
    }
    // method to show shop settings menu
    public static void showShopSettingsMenu() {
        System.out.println("1- Load Data (Items and invoices)");
        System.out.println("2- Set Shop Name (data should be saved) ");
        System.out.println("3- Set Invoice Header (Tel / Fax / Email / Website)");
        System.out.println("4- Go Back");

    }
    public  static  void showManageShopItemsMenu(){
        System.out.println("1- Add Items ");
        System.out.println("2-Delete Items ");
        System.out.println("3- Change Item Price ");
        System.out.println("4- Report All Items");
        System.out.println("5- Go Back");
    }
    static void processMainMenu(int choice, Scanner scanner, Shop shop) {
        switch (choice) {
            case 1:
                processShopSettingsMenu(scanner, shop);
                break;
            case 2:
                processManageShopItemsMenu(scanner, shop);
                break;
            case 3:
                Invoice.createNewInvoiceMenu(shop, scanner);

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
    //exit program method
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


    //Shop setings process menu
    private static void processShopSettingsMenu(Scanner scanner, Shop shop) {
        Menu.showShopSettingsMenu();
        System.out.print("Enter your choice: ");
        int settingChoice = scanner.nextInt();
        switch (settingChoice) {
            case 1:

                Shop.loadShopData(scanner, shop);
                break;
            case 2:
                Shop.setShopName(scanner, shop);
                break;
            case 3:
                Shop.setInvoiceHeader(scanner, shop);
                break;
            case 4:
                Menu.showMainMenu();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    //process Item shop menu
    private static void processManageShopItemsMenu(Scanner scanner, Shop shop) {
        Menu.showManageShopItemsMenu();
        System.out.print("Enter your choice: ");
        int itemChoice = scanner.nextInt();
        switch (itemChoice) {
            case 1:
                Item.addItem(scanner,shop);

                break;
            case 2:

                Item.deleteItem(scanner, shop);
                break;
            case 3:

                Item.changeItemPrice(scanner, shop);
                break;
            case 4:
                shop.reportAllItems();
                break;
            case 5:
                Menu.showMainMenu();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

}
