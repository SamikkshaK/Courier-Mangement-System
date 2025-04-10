package assignment;

import java.util.Scanner;

public class ThreeAuthentication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String employeeUsername = "employee01";
        String employeePassword = "emp123";

        String customerUsername = "customer01";
        String customerPassword = "cust123";

        System.out.println("Welcome! Are you an Employee or Customer?");
        System.out.print("Enter role (Employee/Customer): ");
        String role = scanner.nextLine().trim();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine().trim();

        if (role.equalsIgnoreCase("Employee")) {
            if (username.equals(employeeUsername) && password.equals(employeePassword)) {
                System.out.println("Employee login successful.");
            } else {
                System.out.println("Invalid employee credentials.");
            }
        } else if (role.equalsIgnoreCase("Customer")) {
            if (username.equals(customerUsername) && password.equals(customerPassword)) {
                System.out.println("Customer login successful.");
            } else {
                System.out.println("Invalid customer credentials.");
            }
        } else {
            System.out.println("Invalid role entered.");
        }

        scanner.close();
    }
}
