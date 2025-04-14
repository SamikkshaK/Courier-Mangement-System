package Main;

import dao.CourierServiceDb;
import dao.CourierServiceImpl;
import entities.Courier;
import entities.Employee;
import exceptions.TrackingNumberNotFoundException;
import dao.CourierAdminServiceImpl;
import dao.ICourierAdminService;

import java.util.*;

public class MainModule {
    public static void main(String[] args) throws TrackingNumberNotFoundException {
        Scanner sc = new Scanner(System.in);
        CourierServiceDb dbService = new CourierServiceDb();
        while (true) {
            System.out.println("\n----- Courier Management System -----");
            System.out.println("1. Place Order");
            System.out.println("2. Get Order Status");
            System.out.println("3. Cancel Order");
            System.out.println("4. Get Assigned Orders");
            System.out.println("5. View Delivery History");
            System.out.println("6. Shipment Status Report");
            System.out.println("7. Revenue Report");
            System.out.println("8. Add Courier Staff (Admin)");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Sender Name: ");
                    String sender = sc.nextLine();
                    System.out.print("Enter Receiver Name: ");
                    String receiver = sc.nextLine();
                    System.out.print("Enter Employee ID (e.g. EMP001): ");
                    String empId = sc.nextLine();
                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();

                    String trackingNumber = "TRK" + (int) (Math.random() * 10000);
                    Courier newCourier = new Courier(trackingNumber, sender, receiver, empId, status);

                    if (dbService.insertCourier(newCourier)) {
                        System.out.println(" Order placed successfully. Tracking Number: " + trackingNumber);
                    } else {
                        System.out.println(" Failed to place order.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Tracking Number: ");
                    String trackingNumber1 = sc.nextLine();
                    CourierServiceImpl service = new CourierServiceImpl();
                    String status1 = service.getOrderStatusFromDB(trackingNumber1);
                    System.out.println(status1);
                    break;

                case 3:
                    System.out.print("Enter Tracking Number to Cancel: ");
                    String trackingNumberCancel = sc.nextLine();
                    CourierServiceImpl cancelService = new CourierServiceImpl();
                    boolean cancelled = cancelService.cancelOrderInDB(trackingNumberCancel);
                    if (cancelled) {
                        System.out.println(" Order cancelled successfully.");
                    } else {
                        System.out.println(" Failed to cancel order.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to View Assigned Orders: ");
                    String employeeId = sc.nextLine();
                    List<Courier> orders = dbService.getAllCouriersByEmployeeId(employeeId);
                    if (orders.isEmpty()) {
                        System.out.println("No orders assigned to " + employeeId);
                    } else {
                        System.out.println("Assigned Orders for " + employeeId + ":");
                        for (Courier c : orders) {
                            System.out.println("Tracking #: " + c.getTrackingNumber() + ", Status: " + c.getStatus());
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter Tracking Number to View Delivery History: ");
                    String historyId = sc.nextLine();
                    List<String> history = dbService.getDeliveryHistory(historyId);
                    if (history.isEmpty()) {
                        System.out.println("No delivery history found.");
                    } else {
                        System.out.println("Delivery History for " + historyId + ":");
                        for (String h : history) {
                            System.out.println(h);
                        }
                    }
                    break;

                case 6:
                    System.out.println("SHIPMENT STATUS REPORT:");
                    Map<String, Integer> statusReport = dbService.getShipmentStatusReport();
                    if (statusReport.isEmpty()) {
                        System.out.println("No shipment data available.");
                    } else {
                        statusReport.forEach((s, count) -> System.out.println(s + ": " + count));
                    }
                    break;

                case 7:
                    System.out.println("REVENUE REPORT:");
                    double revenue = dbService.getTotalRevenue();
                    System.out.println("Total Revenue: " + revenue);
                    break;

                case 8:
                    System.out.println("--- Add New Courier Staff ---");
                    System.out.print("Enter Name: ");
                    String staffName = sc.nextLine();
                    System.out.print("Enter Contact Number: ");
                    int contact = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Role: ");
                    String role = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    float salary = sc.nextFloat();
                    sc.nextLine();

                    Employee newStaff = new Employee();
                    newStaff.setName(staffName);
                    newStaff.setContactNumber(contact);
                    newStaff.setEmail(email);
                    newStaff.setRole(role);
                    newStaff.setSalary(salary);

                    ICourierAdminService adminService1 = new CourierAdminServiceImpl();
                    int staffId = adminService1.addCourierStaff(newStaff);
                    if (staffId != -1) {
                        System.out.println(" Courier staff added successfully. ID: " + staffId);
                    } else {
                        System.out.println(" Failed to add courier staff.");
                    }
                    break;


                case 9:
                    System.out.println("Exiting Courier Management System.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
