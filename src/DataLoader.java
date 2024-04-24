import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataLoader {
    public static List<Item> loadItemsFromConsole(Scanner scanner) {
        List<Item> items = new ArrayList<>();
        System.out.println("Enter item details in the following format: itemId, itemName, unitPrice");
        System.out.println("Type 'done' when you have finished adding items.");

        boolean continueEnteringItems = true; // Boolean variable to control the loop

        while (continueEnteringItems) {
            // Read the user input and remove leading/trailing whitespace
            System.out.print("Enter item details: ");
            String line = scanner.nextLine().trim();

            // Check if the user wants to stop entering items
            if (line.equalsIgnoreCase("done")) {
                continueEnteringItems = false; // Set the boolean variable  false to exit the loop
                break;
            }

            // Split the input line into parts using comma as delimiter
            String[] parts = line.split(",");

            // Check if the input has exactly 3 parts
            if (parts.length != 3) {
                // Inform the user about the invalid input format
                System.out.println("Invalid input format. Please enter itemId, itemName, unitPrice separated by commas.");
                continue; // Skip to the next iteration of the loop
            }

            try {
                // Parse the input parts into itemId, itemName, and unitPrice
                int itemId = Integer.parseInt(parts[0].trim()); // Trim to remove leading/trailing whitespace
                String itemName = parts[1].trim();
                double unitPrice = Double.parseDouble(parts[2].trim());

                // Create an Item object and add it to the list
                Item item = new Item(itemId, itemName, unitPrice);
                items.add(item);
            } catch (NumberFormatException e) {
                // Inform the user about the invalid input format
                System.out.println("Invalid input format. Please enter valid numbers for itemId and unitPrice.");
            }
        }
        return items;
    }

    ///
    public static List<Invoice> loadInvoicesFromConsole(Scanner scanner) {

        //same comments for this one as loadItemsFromConsole function
        List<Invoice> invoices = new ArrayList<>();
        System.out.println("Enter item details in the following format: invoiceNumber,customerName, phoneNumber, invoiceDate");
        System.out.println("Type 'done' when you have finished adding invoices.");
        boolean continueEnteringInvoice = true;
        while (continueEnteringInvoice) {
            System.out.print("Enter invoice details: ");
            String line = scanner.nextLine().trim();
            // Check if the user wants to stop entering invoice
            if (line.equalsIgnoreCase("done")) {
                continueEnteringInvoice = false; // Set the boolean variable  false to exit the loop
                break;
            }
            // Split the input line into parts using comma as delimiter
            String[] parts = line.split(",");

            // Check if the input has exactly 3 parts
            if (parts.length != 4) {
                // Inform the user about the invalid input format
                System.out.println("Invalid input. Please enter invoiceNumber,customerName, phoneNumber, invoiceDate separated by commas.");
                continue; // Skip to the next iteration of the loop
            }
            try {
                // Parse the input parts into invoiceNumber,customerName, phoneNumber, invoiceDate
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
