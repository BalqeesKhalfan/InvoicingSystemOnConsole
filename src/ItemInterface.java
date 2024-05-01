import java.util.List;
import java.util.Scanner;

public interface ItemInterface {
    Integer getItemId();
    void setItemId(Integer itemId);
    String getItemName();
    void setItemName(String itemName);
    double getUnitPrice();
    void setUnitPrice(double unitPrice);
    Integer getQuantity();
    void setQuantity(Integer quantity);
    double calculateAmount();

    //add new Item
    void addItem(Scanner scanner, Shop shop);
    void changeItemPrice(Scanner scanner, Shop shop);
    void deleteItem(Scanner scanner, Shop shop);


    // method of reporting all Items

}
