
import java.time.LocalDate;
import java.util.List;

public class Invoice {
    Integer invoiceNumber;
    String customerName;
     String phoneNumber;
     LocalDate invoiceDate;// to add the curante date
     List<Item> items;
     double totalAmount;
    double paidAmount;
     double balance;

    public Invoice(Integer invoiceNumber, String customerName, String phoneNumber, LocalDate invoiceDate, List<Item> items, double totalAmount, double paidAmount, double balance) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.invoiceDate = invoiceDate;
        this.items = items;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.balance = balance;
    }

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

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
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
}
