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
    public List<Item> getItems() {
        return items;
    }
    //delete an Item
    // Remove an item from the 'items' list based on the given itemId
    public void deleteItem(int itemId) {
        // Use the removeIf method to remove items based on a condition
        items.removeIf(item -> item.getItemId() == itemId);
        //  This line of code will  remove items that satisfy the condition specified in the lambda expression
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
    public  List<String> loadData(Scanner scanner) {
        List<String> loadedData = new ArrayList<>(); // Create a new list to store loaded data
        System.out.println("Do you want to load default data? (yes/no): ");
        String choice = scanner.nextLine().toLowerCase();
        //scanner.nextLine();

        if (choice.equals("yes")) {
            loadedData.addAll(loadDefaultData());// Load default data and add it to the list
        } else if (choice.equals("no")) {
            // Prompt user to enter their own data
            System.out.println("Enter your own data:");
            // Load items
            List<Item> enteredItems = DataLoader.loadItemsFromConsole(scanner);
            // Load invoices
            List<Invoice> enteredInvoices = DataLoader.loadInvoicesFromConsole(scanner);
            // Add entered data to shop
            items.addAll(enteredItems);// Add entered items to the list of shop items
            invoices.addAll(enteredInvoices); // Add entered invoices to the list of shop invoices
        } else {
            System.out.println("Invalid choice. Please enter 'yes' or 'no'.");

        }
        return loadedData;
    }
    // set shop Name
    public static void setShopName(Scanner scanner, Shop shop) {
        boolean isValidName = false; // boolean to check  if the entered name is valid

        while (!isValidName) {
            System.out.print("Enter new shop name: ");
            String newShopName = scanner.nextLine().trim(); // Trim leading and trailing whitespace

            // Check if the entered name contains only letters and is not empty
            if (newShopName.matches("[a-zA-Z]+")) {
                shop.setShopName(newShopName);
                System.out.println("Shop name : " + newShopName);
                isValidName = true; // Set the flag to true to exit the loop
            } else {
                System.out.println("Invalid shop name. Please enter a name containing only letters.");
            }
        }
    }
    //Set invoice header
    static void setInvoiceHeader(Scanner scanner, Shop shop) {
        System.out.println("Enter Invoice Header Information:");
        String tel = "";
        String email = "";
        while (!isValidPhoneNumber(tel)) {
            System.out.print("Telephone: ");
            tel = scanner.next();
            if (!isValidPhoneNumber(tel)) {
                System.out.println("Invalid telephone number format. Please enter a valid phone number starting with 9 or 7 and containing 8 digits.");
            }
        }
        while (!isValidEmail(email)){
            System.out.print("Email: ");
            email = scanner.next();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email address containing '@gmail.com'.");
            }
        }
        System.out.print("Fax: ");
        String fax = scanner.next();
        System.out.print("Website: ");
        String website = scanner.next();
        shop.setInvoiceHeader(tel, fax, email, website);
        System.out.println("Invoice header information set successfully.");

    }


    private static boolean isValidPhoneNumber(String phoneNumber) {
        // Check if the phone number starts with 9 or 7 and has a length of 8 digits
        return phoneNumber.matches("[79]\\d{7}");
    }

    // Helper method to validate email format
    private static boolean isValidEmail(String email) {
        // Check if the email contains '@gmail.com'
        return email.endsWith("@gmail.com");
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

    public static void createNewInvoiceMenu(Shop shop, Scanner scanner) {
        System.out.println("Create New Invoice Menu:");

        // Collect invoice information
        int invoiceNumber = getValidInvoiceNumber(scanner);
        scanner.nextLine(); // Consume newline character
        String customerName = getValidCustomerName(scanner);
        String phoneNumber = getValidPhoneNumber(scanner);
        String invoiceDate = getValidInvoiceDate(scanner);

        // Create new invoice object
        Invoice newInvoice = new Invoice(invoiceNumber, customerName, phoneNumber, invoiceDate);

        // Add items to the invoice
        boolean addingItems = true;
        while (addingItems) {
            System.out.print("Enter item ID (or any negative value to finish adding items): ");
            int itemId = scanner.nextInt();
            if (itemId < 0) {
                addingItems = false;
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
    // Validation methods
    private static int getValidInvoiceNumber(Scanner scanner) {
        int invoiceNumber;
        while (true) {
            System.out.print("Enter Invoice Number: ");
            try {
                invoiceNumber = scanner.nextInt();
                if (invoiceNumber < 0) {
                    throw new IllegalArgumentException("Invoice number must be a positive integer.");
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid invoice number.");
                scanner.nextLine(); // Consume newline character
            }
        }
        return invoiceNumber;
    }

    private static String getValidCustomerName(Scanner scanner) {
        String customerName;
        while (true) {
            System.out.print("Enter customer full name: ");
            customerName = scanner.nextLine().trim();
            if (!customerName.isEmpty()) {
                break;
            }
            System.out.println("Customer name cannot be empty.");
        }
        return customerName;
    }

    private static String getValidPhoneNumber(Scanner scanner) {
        String phoneNumber;
        while (true) {
            System.out.print("Enter phone number: ");
            phoneNumber = scanner.nextLine().trim();
            if (isValidPhoneNumber(phoneNumber)) {
                break;
            }
            System.out.println("Invalid phone number format. Please enter a valid 8-digit number starting with 9 or 7.");
        }
        return phoneNumber;
    }



    private static String getValidInvoiceDate(Scanner scanner) {
        String invoiceDate;
        while (true) {
            System.out.print("Enter invoice date (dd-mm-yyyy): ");
            invoiceDate = scanner.nextLine().trim();
            if (isValidDateFormat(invoiceDate)) {
                break;
            }
            System.out.println("Invalid date format. Please enter the date in dd-mm-yyyy format.");
        }
        return invoiceDate;
    }
    private static boolean isValidDateFormat(String date) {
        return date.matches("\\d{2}-\\d{2}-\\d{4}");
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
