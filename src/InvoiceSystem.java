import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InvoiceSystem {
    private static List<Item> items = new ArrayList<>(); // List to store all items
    private static List<Invoice> invoices = new ArrayList<>(); // List to store all invoices
    public static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args) {

        boolean exit = false;
        Integer choice;// Initialize choice to enter the loop initially
        while ( !exit){
            Menu.showMainMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    Menu.showShopSettingsMenu();
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    break;
                case 2:
                    Menu.showManageShopItemsMenu();
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    break;
                case 3:
                    createNewInvoice();
                    break;
                case 4:
                    // Implement reporting statistics
                    break;
                case 5:
                    // Implement reporting all invoices
                    break;
                case 6:
                    // Implement searching invoices
                    break;
                case 7:
                    // Implement program statistics
                    break;
                case 8:
                    // Exit the program
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }

    }
   /** public static void createNewInvoice(){
        System.out.println("Creating New Invoice:");
        System.out.println("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer phone number: ");
        String customerPhone = scanner.nextLine();

        Invoice newInvoice = new Invoice(customerName, customerPhone); // Create new Invoice object

        // Add items to the invoice
        boolean continueAdding = true;
        do {
            displayItems(); // Show available items
            System.out.println("Enter item ID (-1 to finish): ");
            int itemId = scanner.nextInt();

            if (itemId != -1) {
                System.out.println("Enter quantity: ");
                int quantity = scanner.nextInt();
                addItemToInvoice(newInvoice, itemId, quantity); // Add selected item to invoice
            } else {
                continueAdding = false;
            }
        } while (continueAdding);

        // Calculate total amount
        newInvoice.calculateTotalAmount();

        // Display invoice details for confirmation
        System.out.println("\n**Invoice Details**");
        System.out.println("Customer Name: " + newInvoice.getCustomerName());
        System.out.println("Customer Phone: " + newInvoice.getPhoneNumber());
        System.out.println("Invoice Date: " + newInvoice.getInvoiceDate()); // Assuming date is set during creation
        System.out.println("Items:");
        for (Item item : newInvoice.getItems()) {
            System.out.println(item.getItemName() + " x " + item.getQuantity() + " (" + item.getUnitPrice() + ")");
        }
        System.out.println("Total Amount: " + newInvoice.getTotalAmount());

        // Prompt user to confirm saving
        System.out.println("Save invoice? (y/n): ");
        char choice = scanner.next().charAt(0);

        if (choice == 'y' || choice == 'Y') {
            saveInvoice(newInvoice); // Call method to save the invoice
            System.out.println("Invoice saved successfully!");
        } else {
            System.out.println("Invoice discarded.");
        }
    }

    // Helper methods for displaying items, adding items to invoice, and saving invoice
    private static void displayItems() {
        // ... (Implement logic to display available items)
    }

    private static void addItemToInvoice(Invoice invoice, int itemId, int quantity) {
        // ... (Implement logic to find item by ID, add it to invoice with quantity)
    }

    private static void saveInvoice(Invoice invoice) {
        // ... (Implement logic to save invoice data to a file or database)
    }*/
   private static void createNewInvoice() {
       System.out.println("Creating New Invoice:");

       // Display available items
       System.out.println("Available Items:");
       for (Item item : items) {
           System.out.println(item.getItemId() + ". " + item.getItemName() + " - $" + item.getUnitPrice());
       }

       // Prompt user to select items and quantities
       List<Item> selectedItems = new ArrayList<>();
       boolean continueAdding = true;
       while (continueAdding) {
           System.out.print("Enter item ID to add to invoice (0 to finish): ");
           int itemId = scanner.nextInt();
           if (itemId == 0) {
               continueAdding = false;
               break;
           }
           System.out.print("Enter quantity: ");
           int quantity = scanner.nextInt();

           // Find the item by ID and add it to the list of selected items
           for (Item item : items) {
               if (item.getItemId() == itemId) {
                   selectedItems.add(new Item(item.getItemId(), item.getItemName(), item.getUnitPrice(), quantity));
                   break;
               }
           }
       }

       // Gather customer information
       scanner.nextLine(); // Consume newline
       System.out.print("Enter customer full name: ");
       String customerFullName = scanner.nextLine();
       System.out.print("Enter customer phone number: ");
       String phoneNumber = scanner.nextLine();

       // Calculate total amount
       double totalAmount = 0;
       for (Item item : selectedItems) {
           totalAmount += item.getUnitPrice() * item.getQuantity();
       }

       // Gather payment information
       System.out.print("Enter paid amount: ");
       double paidAmount = scanner.nextDouble();
       scanner.nextInt();


       // Calculate balance
       double balance = totalAmount - paidAmount;

       // Create and add the new invoice
       Invoice newInvoice = new Invoice(customerFullName, phoneNumber, new Date(), selectedItems, totalAmount, paidAmount, balance);
       invoices.add(newInvoice);

       System.out.println("New invoice created successfully.");
   }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }
}



