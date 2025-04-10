package assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OneIfelse {
    public static void main(String[] args) {
        Map<Integer, String> orderStatusMap = new HashMap<>();
        orderStatusMap.put(101, "Processing");
        orderStatusMap.put(102, "Delivered");
        orderStatusMap.put(103, "Cancelled");
        orderStatusMap.put(104, "Delivered");
        orderStatusMap.put(105, "Processing");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();

        if (orderStatusMap.containsKey(orderId)) {
            String status = orderStatusMap.get(orderId);
            if (status.equalsIgnoreCase("Delivered")) {
                System.out.println("The order has been delivered.");
            } else if (status.equalsIgnoreCase("Processing")) {
                System.out.println("The order is still being processed.");
            } else if (status.equalsIgnoreCase("Cancelled")) {
                System.out.println("The order was cancelled.");
            } else {
                System.out.println("Status: " + status);
            }
        } else {
            System.out.println("Order ID not found.");
        }

        scanner.close();
    }
}
