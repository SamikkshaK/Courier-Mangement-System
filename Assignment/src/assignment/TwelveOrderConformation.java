package assignment;

import java.util.Scanner;

public class TwelveOrderConformation {

    public static String generateEmail(String name, String orderNumber, String address, String deliveryDate) {
        String email = "Dear " + name + ",\n\n" +
                "Thank you for your order!\n" +
                "Your order number is: " + orderNumber + "\n\n" +
                "Delivery Address:\n" + address + "\n\n" +
                "Expected Delivery Date: " + deliveryDate + "\n\n" +
                "We appreciate your business and hope you enjoy your purchase!\n\n" +
                "Best regards,\n" +
                "Courier Service Team";

        return email;
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Order Number: ");
        String orderNumber = sc.nextLine();

        System.out.print("Enter Delivery Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Expected Delivery Date (e.g., April 10, 2025): ");
        String deliveryDate = sc.nextLine();

        String emailContent = generateEmail(name, orderNumber, address, deliveryDate);
        System.out.println("\n--- Order Confirmation Email ---\n");
        System.out.println(emailContent);
    }
}

