import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataLoader {
    public static List<Item> loadItemsFromConsole(Scanner scanner) {
        List<Item> items = new ArrayList<>();
        System.out.println("Enter item details (itemId, itemName, unitPrice), type 'done' to finish:");
        while (true) { //use boolean variable
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("done")) {
                break;
            }
            String[] parts = line.split(","); //how will the user know of input format
            if (parts.length != 3) {
                System.out.println("Invalid input. Please enter itemId, itemName, unitPrice separated by commas.");
                continue;
            }
            try {

                // It is far better to use simpler logic, Your current logic is prone to erros
                int itemId = Integer.parseInt(parts[0]);
                String itemName = parts[1];
                double unitPrice = Double.parseDouble(parts[2]);
                Item item = new Item(itemId, itemName, unitPrice);
                items.add(item);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Please enter valid numbers for itemId and unitPrice.");
            }
        }
        return items;
    }

    ///
    public static List<Invoice> loadInvoicesFromConsole(Scanner scanner) {

        //same comments for this one as loadItemsFromConsole function
        List<Invoice> invoices = new ArrayList<>();
        System.out.println("Enter invoice details (invoiceNumber,customerName, phoneNumber, invoiceDate), type 'done' to finish:");
        while (true) {
            try {
                String line = scanner.nextLine().trim();
                if (line.equalsIgnoreCase("done")) {
                    break;
                }
                String[] parts = line.split(",");
                if (parts.length !=4) {
                    System.out.println("Invalid input. Please enter invoiceNumber,customerName, phoneNumber, invoiceDate separated by commas.");
                    continue;
                }
                Integer invoiceNumber= Integer.valueOf(parts[0]);
                String customerName = parts[1];
                String phoneNumber = parts[2];
                String invoiceDate = parts[3];
                Invoice invoice = new Invoice(invoiceNumber,customerName, phoneNumber, invoiceDate);
                invoices.add(invoice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Please enter valid values for customerName, phoneNumber, invoiceDate.");
            }
        }
        return invoices;
    }



}
