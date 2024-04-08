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






}
