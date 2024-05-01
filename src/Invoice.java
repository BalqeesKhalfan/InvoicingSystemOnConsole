import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Invoice implements  InvoiceInterface{
    private static int nextInvoiceNumber = 1;
    Integer invoiceNumber;
    String customerName;
     String phoneNumber;
     String invoiceDate;
     //LocalDate invoiceDate;// to add the curante date
     List<Item> items;
    private List<Integer> quantities;
     double totalAmount;
    double paidAmount;
     double balance;

    public Invoice() {
    }

    public Invoice(Integer invoiceNumber, String customerName, String phoneNumber, String invoiceDate) {
        this.invoiceNumber = nextInvoiceNumber++;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.invoiceDate = invoiceDate;
        this.items = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.totalAmount = 0.0;
        this.paidAmount = 0.0;
        this.balance = 0.0;
    }


    //Getter and Setter

    @Override
    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }
   @Override
    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
   @Override
    public String getCustomerName() {
        return customerName;
    }
   @Override
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
   @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
  @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String getInvoiceDate() {
        return invoiceDate;
    }
   @Override
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
  @Override
    public List<Item> getItems() {
        return items;
    }
   @Override
    public void setItems(List<Item> items) {
        this.items = items;
    }
  @Override
    public double getTotalAmount() {
        return totalAmount;
    }
   @Override
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    @Override

    public double getPaidAmount() {
        return paidAmount;
    }
   @Override
    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }
   @Override
    public double getBalance() {
        return balance;
    }
   @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public int getQuantityOfAnItem(Item item) {
        int index = items.indexOf(item);
        if (index != -1) {
            return quantities.get(index);
        }
        return 0;
    }
    @Override
    public double getItemAmount(Item item) {
        int index = items.indexOf(item);
        if (index != -1) {
            return item.getUnitPrice() * quantities.get(index);
        }
        return 0;
    }
    // method to add new Item
    @Override
    public void addItem(Item item, Integer quantity) {
        items.add(item);
        quantities.add(quantity);
        totalAmount +=item.getUnitPrice() *quantity;
    }

    // method to calculate total mount
    @Override
    public double calculateTotalAmount() {
        double total = 0.0;
        for (Item item : items) {
            total += item.calculateAmount();
        }
        return total;
    }
    //method to update paid amount
    @Override
    public void updatePaidAmount(double amount) {
        if (amount >= 0) {
            this.paidAmount += amount;
            this.balance = this.totalAmount - this.paidAmount;
        } else {
            System.out.println("Error: Paid amount cannot be negative.");
        }
    }

    // method to mark Invoice paid
    @Override
    public void markInvoicePaid() {
        if (this.balance == 0.0) {
            System.out.println("Invoice already paid.");
        } else {
            this.paidAmount = this.totalAmount;
            this.balance = 0.0;
            System.out.println("Invoice marked as paid.");
        }
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", invoiceDate='" + invoiceDate + '\'' +
                '}';
    }
    //create new invoice
    public static void createNewInvoiceMenu(Shop shop, Scanner scanner) {
        System.out.println("Create New Invoice Menu:");

        // Collect invoice information
        System.out.print("Enter Invoice Number : ");
        scanner.nextLine(); // Clear the input buffer
        Integer invoiceNumber= scanner.nextInt();

        System.out.print("Enter customer full name: ");
        scanner.nextLine(); // Clear the input buffer
        String customerName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter invoice date: ");
        String invoiceDate = scanner.nextLine();

        // Create new invoice object
        Invoice newInvoice = new Invoice(invoiceNumber,customerName, phoneNumber, invoiceDate);

        // Add items to the invoice
        while (true) {
            System.out.print("Enter item ID (or -1 to finish adding items): ");
            int itemId;
            try {
                itemId = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input for item ID.");
                scanner.nextLine(); // Clear the input buffer
                continue;
            }
            if (itemId == -1) {
                break;
            }
            // Search for item by ID and add to the invoice
            boolean found = false;
            for (Item item : shop.getItems()) {
                if (item.getItemId() == itemId) {
                    found = true;
                    System.out.print("Enter quantity for item " + item.getItemName() + ": ");
                    int quantity;
                    try {
                        quantity = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid input for quantity.");
                        scanner.nextLine(); // Clear the input buffer
                        continue;
                    }
                    newInvoice.addItem(item, quantity);
                    break;
                }
            }
            if (!found) {
                System.out.println("Item with ID " + itemId + " not found.");
            }
        }

        // Add invoice to shop or perform any further actions as needed
        System.out.println("Invoice created successfully.");
    }

    //method or report statistic menu
    @Override
    public  void statisticsMenu(Shop shop) {
        System.out.println("Report: Statistics Menu:");

        int totalItems = 0;
        int totalInvoices = shop.getInvoices().size();
        double totalSales = 0;

        // Calculate total number of items and total sales from all invoices
        for (Invoice invoice : shop.getInvoices()) {
            totalItems += invoice.getItems().size();
            totalSales += invoice.getTotalAmount();
        }

        // Print statistics
        System.out.println("Total number of items sold: " + totalItems);
        System.out.println("Total number of invoices: " + totalInvoices);
        System.out.println("Total sales: OMR" + totalSales);
    }



    // Method to generate a report of all invoices

   @Override
    public  void reportAllInvoices(Shop shop) {
        System.out.println("Report: All Invoices Menu:");
        List<Invoice> allInvoices = shop.getAllInvoices();
        if (allInvoices.isEmpty()) {
            System.out.println("No invoices found.");
        } else {
            System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Invoice No", "Invoice Date", "Customer Name", "Total Amount", "Paid Amount");
            for (Invoice invoice : allInvoices) {
                System.out.printf("%-15d %-15s %-15s $%-14.2f $%-14.2f\n", invoice.getInvoiceNumber(), invoice.getInvoiceDate(), invoice.getCustomerName(), invoice.getTotalAmount(), invoice.getPaidAmount());
            }
        }
    }


    // search Invoice Menu
    @Override
    public  void searchInvoicesMenu(Shop shop, Scanner scanner) {
        System.out.println("Search Invoices Menu:");
        System.out.print("Enter Invoice Number: ");
        int searchInvoiceNumber = scanner.nextInt();

        // Search for the invoice
        Invoice foundInvoice = shop.findInvoiceByNumber(searchInvoiceNumber);

        if (foundInvoice != null) {
            // If invoice is found, display its details
            System.out.println("Invoice Details:");
            System.out.println(foundInvoice);
        } else {
            System.out.println("Invoice with number " + searchInvoiceNumber + " not found.");
        }
    }


}
