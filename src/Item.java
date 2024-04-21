import java.util.Objects;
import java.util.Scanner;

public class Item {
    Integer itemId;
     String itemName;
     double unitPrice;
    Integer quantity;

    public Item(Integer itemId, String itemName, double unitPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unitPrice = unitPrice;

    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // method to calculate the amount 
    public double calculateAmount() {

        return unitPrice* quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(unitPrice, item.unitPrice) == 0 && Objects.equals(itemName, item.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, unitPrice);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
    //add new Item
    static void addItem(Scanner scanner, Shop shop) {
        System.out.print("Enter Item ID: ");
        int itemId = scanner.nextInt();
        System.out.print("Enter Item Name: ");
        String itemName = scanner.next();
        System.out.print("Enter Unit Price: ");
        double unitPrice = scanner.nextDouble();
        Item newItem = new Item(itemId, itemName, unitPrice);
        shop.addItem(newItem);
        System.out.println("Item added successfully.");
    }
    // delete Item
    static void deleteItem(Scanner scanner, Shop shop) {
        System.out.print("Enter Item ID to delete: ");
        int deleteItemId = scanner.nextInt();
        shop.deleteItem(deleteItemId);
    }
    //change item price
    static void changeItemPrice(Scanner scanner, Shop shop) {
        System.out.print("Enter Item ID to change price: ");
        int changeItemId = scanner.nextInt();
        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();
        shop.changeItemPrice(changeItemId, newPrice);
    }

}
