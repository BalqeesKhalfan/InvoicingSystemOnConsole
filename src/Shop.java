import java.util.*;

public class Shop {
    private String shopName;
    private static Map<String, String> invoiceHeader;
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
    public static void setShopName(String shopName) {

    }

    public static void setInvoiceHeader(String tel, String fax, String email, String website) {
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
    static void loadShopData(Scanner scanner, Shop shop) {
        List<Item> items = DataLoader.loadItemsFromConsole(scanner);
        List<Invoice> invoices = DataLoader.loadInvoicesFromConsole(scanner);
        System.out.println("Data Loaded :");
        System.out.println("Loaded Items:");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("Loaded Invoices:");
        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
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

    // method of reporting all Items
    public void reportAllItems() {
        System.out.println("All Shop Items:");
        for (Item item : items) {
            System.out.println(item);
        }
    }




}
