package assignment;
import java.util.Scanner;

public class NineParcelTracking {

    public static void main(String[] args) {
        String[][] trackingData = {
            {"TRK1001", "In Transit"},
            {"TRK1002", "Out for Delivery"},
            {"TRK1003", "Delivered"},
            {"TRK1004", "In Transit"},
            {"TRK1005", "Delivered"}
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Tracking Number: ");
        String inputTracking = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < trackingData.length; i++) {
            if (trackingData[i][0].equalsIgnoreCase(inputTracking)) {
                found = true;
                String status = trackingData[i][1];

                if (status.equalsIgnoreCase("In Transit")) {
                    System.out.println("Parcel is currently in transit.");
                } else if (status.equalsIgnoreCase("Out for Delivery")) {
                    System.out.println("Parcel is out for delivery.");
                } else if (status.equalsIgnoreCase("Delivered")) {
                    System.out.println("Parcel has been delivered.");
                } else {
                    System.out.println("Unknown status.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Tracking number not found.");
        }

        scanner.close();
    }
}
