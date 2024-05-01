import java.util.List;
import java.util.Scanner;

public interface InvoiceInterface {
    Integer getInvoiceNumber();
    void setInvoiceNumber(Integer invoiceNumber);
    String getCustomerName();
    void setCustomerName(String customerName);
    String getPhoneNumber();
    void setPhoneNumber(String phoneNumber);
    String getInvoiceDate();
    void setInvoiceDate(String invoiceDate);
    List<Item> getItems();
    void setItems(List<Item> items);
    double getTotalAmount();
    void setTotalAmount(double totalAmount);
    double getPaidAmount();
    void setPaidAmount(double paidAmount);
    double getBalance();
    void setBalance(double balance);
    int getQuantityOfAnItem(Item item);
    double getItemAmount(Item item);
    void addItem(Item item, Integer quantity);
    double calculateTotalAmount();
    void updatePaidAmount(double amount);
    void markInvoicePaid();

    //method or report statistic menu
    void statisticsMenu(Shop shop);

    void reportAllInvoices(Shop shop);

    // search Invoice Menu
    void searchInvoicesMenu(Shop shop, Scanner scanner);
}
