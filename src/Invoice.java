
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
}
