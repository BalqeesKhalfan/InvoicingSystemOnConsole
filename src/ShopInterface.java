import java.util.List;
import java.util.Scanner;

public interface ShopInterface {

    String getShopName();

    void setInvoiceHeader(String tel, String fax, String email, String website);
    void addItem(Item item);
    List<Item> getItems();
    void deleteItem(int itemId);
    void changeItemPrice(int itemId, double newPrice);
    void addInvoice(Invoice invoice);
    List<Invoice> getInvoices();
    List<String> loadData(Scanner scanner);

    //Set invoice header


    // set shop Name
    void setShopName(Scanner scanner, Shop shop);

    //Set invoice header
    void setInvoiceHeader(Scanner scanner, Shop shop);

    //void reportAllItems();
    void  createNewInvoiceMenu(Shop shop, Scanner scanner);

    // create new invoice
//    public static void createNewInvoiceMenu(Shop shop, Scanner scanner) {
//        System.out.println("Create New Invoice Menu:");
//        // Collect invoice information
//        System.out.print("Enter Invoice Number: ");
//        int invoiceNumber = scanner.nextInt();
//        scanner.nextLine(); // Consume newline character
//        System.out.print("Enter customer full name: ");
//        String customerName = scanner.nextLine();
//        System.out.print("Enter phone number: ");
//        String phoneNumber = scanner.nextLine();
//        System.out.print("Enter invoice date: ");
//        String invoiceDate = scanner.nextLine();
//        // Create new invoice object
//        Invoice newInvoice = new Invoice(invoiceNumber, customerName, phoneNumber, invoiceDate);
//        // Add items to the invoice
//        boolean addingItems = true;
//        while (addingItems) { //Use boolean variable
//            System.out.print("Enter item ID (or any negative value to finish adding items): ");
//            int itemId = scanner.nextInt();
//            if (itemId < 0) { // Check if the input is negative to finish adding items
//                addingItems = false; // Set the boolean variable false to exit the loop
//                break;
//            }
//            // Search for item by ID and add to the invoice
//
//            boolean found = false;
//            for (Item item : shop.getItems()) {
//                if (item.getItemId() == itemId) { // Check if the item ID matches
//                    found = true;
//                    System.out.print("Enter quantity for item " + item.getItemName() + ": ");
//                    int quantity = scanner.nextInt();
//                    newInvoice.addItem(item, quantity); // Add the item to the invoice with the specified quantity
//                    break;
//                }
//            }
//            if (!found) {
//                System.out.println("Item with ID " + itemId + " not found.");
//            }
//        }
//
//        // Add the newly created invoice to the shop
//        shop.addInvoice(newInvoice);
//
//        // Inform the user that the invoice was created successfully
//        System.out.println("Invoice created successfully.");
//    }
   // void createNewInvoiceMenu(ShopInterface shop, Scanner scanner);

    List<Invoice> getAllInvoices();
    Invoice findInvoiceByNumber(int invoiceNumber);

    void reportAllItems();

    // String setShopName(String newShopName);

    // set shop Name





}
