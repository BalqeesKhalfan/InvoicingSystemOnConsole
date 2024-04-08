import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
    private String shopName;
    private Map<String, String> invoiceHeader;
    private List<Item> items;
    private List<Invoice> invoices;

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
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setInvoiceHeader(String tel, String fax, String email, String website) {
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
    // method of reporting all Items
    public void reportAllItems() {
        System.out.println("All Shop Items:");
        for (Item item : items) {
            System.out.println(item);
        }
    }
    //methods of Managing invoices
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }




}
