import java.util.Date;
import java.util.List;

public class Invoice {
     String customerFullName;
     String phoneNumber;
    Date invoiceDate;
    List<Item> items;
     double totalAmount;
     double paidAmount;
     double balance;
}
