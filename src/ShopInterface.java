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

    // set shop Name
    void setShopName(Scanner scanner, Shop shop);

    //Set invoice header
    void setInvoiceHeader(Scanner scanner, Shop shop);
    void  createNewInvoiceMenu(Shop shop, Scanner scanner);
    List<Invoice> getAllInvoices();
    Invoice findInvoiceByNumber(int invoiceNumber);
    void reportAllItems();

}
