package assignment;
import java.util.*;

class Order {
    int orderId;
    String customerName;
    String item;
    String status;

    public Order(int orderId, String customerName, String item, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.item = item;
        this.status = status;
    }
}

public class FiveLoops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Order[] orders = {
            new Order(101, "Samikksha", "Mobile Phone", "Delivered"),
            new Order(102, "Ravi", "Laptop", "Processing"),
            new Order(103, "Samikksha", "Headphones", "Shipped"),
            new Order(104, "Meena", "Camera", "Cancelled"),
            new Order(105, "Samikksha", "Smartwatch", "Delivered")
        };

        System.out.print("Enter customer name: ");
        String customer = scanner.nextLine();
        boolean found = false;

        System.out.println("Orders for " + customer + ":");
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].customerName.equalsIgnoreCase(customer)) {
                System.out.println("Order ID: " + orders[i].orderId + ", Item: " + orders[i].item + ", Status: " + orders[i].status);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No orders found for this customer.");
        }

        scanner.close();
    }
}
