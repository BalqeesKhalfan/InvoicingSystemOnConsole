
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Invoice {
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
    public Invoice(String customerName, String phoneNumber, String invoiceDate) {
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


    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public int getQuantityOfAnItem(Item item) {
        int index = items.indexOf(item);
        if (index != -1) {
            return quantities.get(index);
        }
        return 0;
    }

    public double getItemAmount(Item item) {
        int index = items.indexOf(item);
        if (index != -1) {
            return item.getUnitPrice() * quantities.get(index);
        }
        return 0;
    }
    // method to add new Item
    public void addItem(Item item, Integer quantity) {
        items.add(item);
        quantities.add(quantity);
        totalAmount +=item.getUnitPrice() *quantity;
    }

    // method to calculate total mount
    public double calculateTotalAmount() {
        double total = 0.0;
        for (Item item : items) {
            total += item.calculateAmount();
        }
        return total;
    }
    //method to update paid amount
    public void updatePaidAmount(double amount) {
        if (amount >= 0) {
            this.paidAmount += amount;
            this.balance = this.totalAmount - this.paidAmount;
        } else {
            System.out.println("Error: Paid amount cannot be negative.");
        }
    }

    // method to mark Invoice paid
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
        System.out.print("Enter customer full name: ");
        scanner.nextLine(); // Clear the input buffer
        String customerName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter invoice date: ");
        String invoiceDate = scanner.nextLine();

        // Create new invoice object
        Invoice newInvoice = new Invoice(customerName, phoneNumber, invoiceDate);

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

    public static void statisticsMenu(Shop shop) {
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
    public static void reportAllInvoices(Shop shop) {
        System.out.println("Report: All Invoices Menu:");
        List<Invoice> allInvoices = shop.getInvoices();
        if (allInvoices.isEmpty()) {
            System.out.println("No invoices found.");
        } else {
            System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Invoice No", "Invoice Date", "Customer Name", "No of Items", "Total");
            for (int i = 0; i < allInvoices.size(); i++) {
                Invoice invoice = allInvoices.get(i);
                System.out.printf("%-15d %-15s %-15s %-15d $%.2f\n", i + 1, invoice.getInvoiceDate(), invoice.getCustomerName(), invoice.getItems().size(), invoice.getTotalAmount());
            }
        }



    }

    // search Invoice Menu
    public static void searchInvoicesMenu(Shop shop, Scanner scanner) {
        System.out.println("Search Invoices Menu:");
        System.out.print("Enter Invoice Number: ");
        int searchInvoiceNumber = scanner.nextInt();
        boolean found = false;

        for (Invoice invoice : shop.getInvoices()) {
            if (invoice.getInvoiceNumber() == searchInvoiceNumber) {
                found = true;
                System.out.println("Invoice Details:");
                System.out.println("Invoice Number: " + invoice.getInvoiceNumber());
                System.out.println("Invoice Date: " + invoice.getInvoiceDate());
                System.out.println("Customer Name: " + invoice.getCustomerName());
                System.out.println("Phone Number: " + invoice.getPhoneNumber());
                System.out.println("Total Amount: " + invoice.getTotalAmount());
                System.out.println("Paid Amount: " + invoice.getPaidAmount());
                System.out.println("Balance: " + invoice.getBalance());

                System.out.println("Items:");
                for (Item item : invoice.getItems()) {
                    System.out.println("Item ID: " + item.getItemId());
                    System.out.println("Item Name: " + item.getItemName());
                    System.out.println("Unit Price: " + item.getUnitPrice());
                    System.out.println("Quantity: " + invoice.getQuantityOfAnItem(item));
                    System.out.println("Item Amount: " + invoice.getItemAmount(item));
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Invoice with number " + searchInvoiceNumber + " not found.");
        }
    }

}
