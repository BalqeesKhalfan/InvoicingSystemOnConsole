import java.util.*;

public class Shop {
    private String shopName;
    private  Map<String, String> invoiceHeader;
    private  List<Item> items;
    private  List<Invoice> invoices;


    public Shop(String shopName) {
        this.shopName = shopName;
        this.invoiceHeader = new HashMap<>();
        this.items = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

    public String getShopName() {
        return shopName;
    }
    // Setters for shop name and invoice header
    public static void setShopName(String shopName) {

    }

    public  void setInvoiceHeader(String tel, String fax, String email, String website) {
        invoiceHeader.put("Telephone", tel);
        invoiceHeader.put("Fax", fax);
        invoiceHeader.put("Email", email);
        invoiceHeader.put("Website", website);
    }
  //
  // Add Methods Of  managing items
    //add Item
  public void addItem(Item item) {
      items.add(item);
  }
   //
    public List<Item> getItems() {
        return items;
    }
    //delete an Item
    public void deleteItem(int itemId) {
        items.removeIf(item -> item.getItemId() == itemId);
    }
    // update Item Price
    public void changeItemPrice(int itemId, double newPrice) {
        for (Item item : items) {
            if (item.getItemId() == itemId) {
                item.setUnitPrice(newPrice);
                break;
            }
        }
    }

    //methods of Managing invoices
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }


    //load Data

    // Method to load default data or allow user to enter data
    public List<String> loadData(Scanner scanner) {
        System.out.println("Do you want to load default data? (yes/no): ");
        String choice = scanner.nextLine().toLowerCase();
        //scanner.nextLine();

        if (choice.equals("yes")) {
           return loadDefaultData();
        } else if (choice.equals("no")) {
            // Prompt user to enter their own data
            System.out.println("Enter your own data:");

            // Load items

            List<Item> enteredItems = DataLoader.loadItemsFromConsole(scanner);

            // Load invoices

            List<Invoice> enteredInvoices = DataLoader.loadInvoicesFromConsole(scanner);

            // Add entered data to shop
            items.addAll(enteredItems);
            invoices.addAll(enteredInvoices);
        } else {
            System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
        }
        return null;
    }
    // set shop Name
    public static void setShopName(Scanner scanner, Shop shop) {
        System.out.print("Enter new shop name: ");
        scanner.nextLine(); // Clear the input buffer
        String newShopName = scanner.nextLine();
        shop.setShopName(newShopName);
        System.out.println("Shop name : " + newShopName);
    }
    //Set invoice header
    static void setInvoiceHeader(Scanner scanner, Shop shop) {
        System.out.println("Enter Invoice Header Information:");
        System.out.print("Telephone: ");
        String tel = scanner.next();
        System.out.print("Fax: ");
        String fax = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Website: ");
        String website = scanner.next();
        shop.setInvoiceHeader(tel, fax, email, website);
        System.out.println("Invoice header information set successfully.");
    }
    // Method to load default data

    public List<String> loadDefaultData() {
        List<String> defaultData = new ArrayList<>();

        // Add some default items
        defaultData.add("Default Items:");
        defaultData.add(String.format("%-10s %-15s %-10s", "ID", "Name", "Price"));
        Item item1 = new Item(1, "Apple", 1.5);
        Item item2 = new Item(2, "Banana", 0.75);
        Item item3 = new Item(3, "Orange", 1.0);

        items.add(item1);
        items.add(item2);
        items.add(item3);

        // Add items to the list
        defaultData.add(String.format("%-10d %-15s %-10.2f", item1.getItemId(), item1.getItemName(), item1.getUnitPrice()));
        defaultData.add(String.format("%-10d %-15s %-10.2f", item2.getItemId(), item2.getItemName(), item2.getUnitPrice()));
        defaultData.add(String.format("%-10d %-15s %-10.2f", item3.getItemId(), item3.getItemName(), item3.getUnitPrice()));
        defaultData.add(""); // Add an empty line

        // Add some default invoices
        defaultData.add("Default Invoices:");
        for (Invoice invoice : getDefaultInvoices()) {
            defaultData.add(invoice.toString());
        }

        return defaultData;
    }

     List<Invoice> getDefaultInvoices() {
        List<Invoice> defaultInvoices = new ArrayList<>();

        Item item1 = new Item(1, "Apple", 1.5);
        Item item2 = new Item(2, "Banana", 0.75);
        Item item3 = new Item(3, "Orange", 1.0);

        Invoice invoice1 = new Invoice(1, "John Doe", "1234567890", "2024-04-20");
        invoice1.addItem(item1, 3);
        invoice1.addItem(item2, 2);

        Invoice invoice2 = new Invoice(2, "Jane Smith", "0987654321", "2024-04-21");
        invoice2.addItem(item3, 4);

        defaultInvoices.add(invoice1);
        defaultInvoices.add(invoice2);

        return defaultInvoices;
    }

    // method of reporting all Items
    public void reportAllItems() {
        System.out.println("All Shop Items:");
        for (Item item : items) {
            System.out.println(item);
        }
    }
    // create new invoice
    public static void createNewInvoiceMenu(Shop shop, Scanner scanner) {
        System.out.println("Create New Invoice Menu:");

        // Collect invoice information
        System.out.print("Enter Invoice Number: ");
        int invoiceNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter customer full name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter invoice date: ");
        String invoiceDate = scanner.nextLine();

        // Create new invoice object
        Invoice newInvoice = new Invoice(invoiceNumber, customerName, phoneNumber, invoiceDate);

        // Add items to the invoice
        while (true) {
            System.out.print("Enter item ID (or -1 to finish adding items): ");
            int itemId = scanner.nextInt();
            if (itemId == -1) {
                break;
            }

            // Search for item by ID and add to the invoice
            boolean found = false;
            for (Item item : shop.getItems()) {
                if (item.getItemId() == itemId) {
                    found = true;
                    System.out.print("Enter quantity for item " + item.getItemName() + ": ");
                    int quantity = scanner.nextInt();
                    newInvoice.addItem(item, quantity);
                    break;
                }
            }
            if (!found) {
                System.out.println("Item with ID " + itemId + " not found.");
            }
        }

        // Add the newly created invoice to the shop
        shop.addInvoice(newInvoice);

        // Inform the user that the invoice was created successfully
        System.out.println("Invoice created successfully.");
    }
 //return all invoices
 public List<Invoice> getAllInvoices() {
     return invoices;
 }
    // Method to search for an invoice by invoice number
    public Invoice findInvoiceByNumber(int invoiceNumber) {
        for (Invoice invoice : invoices) {
            if (invoice.getInvoiceNumber() == invoiceNumber) {
                return invoice;
            }
        }
        return null; // Return null if invoice is not found
    }




}
