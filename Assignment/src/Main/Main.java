package Main;

import dao.CourierServiceDb;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CourierServiceDb dbService = new CourierServiceDb();

        
        System.out.println("DELIVERY HISTORY for TRK1001:");
        List<String> history = dbService.getDeliveryHistory("TRK1001");
        if (history.isEmpty()) {
            System.out.println("No delivery history found.");
        } else {
            for (String record : history) {
                System.out.println(record);
            }
        }

        
        System.out.println("\nSHIPMENT STATUS REPORT:");
        Map<String, Integer> statusReport = dbService.getShipmentStatusReport();
        if (statusReport.isEmpty()) {
            System.out.println("No shipment data available.");
        } else {
            statusReport.forEach((status, count) -> System.out.println(status + ": " + count));
        }

        
        System.out.println("\nREVENUE REPORT:");
        double revenue = dbService.getTotalRevenue();
        System.out.println("Total Revenue: " + revenue);
    }
}
