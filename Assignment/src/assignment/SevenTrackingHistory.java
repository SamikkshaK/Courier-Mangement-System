package assignment;
import java.util.*;

public class SevenTrackingHistory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        List<String> trackingHistory = new ArrayList<>();

        System.out.print("Enter number of location updates: ");
        int count = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < count; i++) {
            System.out.print("Enter location update " + (i + 1) + ": ");
            String location = scanner.nextLine();
            trackingHistory.add(location);
        }

        System.out.println("\nTracking History:");
        for (String location : trackingHistory) {
            System.out.println("- " + location);
        }

        scanner.close();
    }
}
