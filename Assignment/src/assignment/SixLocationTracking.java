package assignment;
import java.util.*;

public class SixLocationTracking {

    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String[]> courierRoutes = new HashMap<>();
        courierRoutes.put(1, new String[]{"New York Warehouse", "New Jersey", "Philadelphia", "Baltimore", "Washington D.C."});
        courierRoutes.put(2, new String[]{"Chicago Hub", "Springfield", "St. Louis", "Kansas City", "Denver"});
        courierRoutes.put(3, new String[]{"San Francisco Hub", "San Jose", "Fresno", "Bakersfield", "Los Angeles Distribution Center"});

        System.out.print("Enter Courier ID to track: ");
        int courierId = scanner.nextInt();

        if (!courierRoutes.containsKey(courierId)) {
            System.out.println("Courier ID not found.");
            return;
        }

        String[] route = courierRoutes.get(courierId);
        int currentIndex = 0;
        String currentLocation = route[currentIndex];
        String destination = route[route.length - 1];

        System.out.println("Tracking Courier ID " + courierId + "...");
        while (!currentLocation.equals(destination)) {
            System.out.println("Current Location: " + currentLocation);
            currentIndex++;
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Tracking interrupted");
            }
            currentLocation = route[currentIndex];
        }

        System.out.println("Current Location: " + currentLocation);
        System.out.println("Courier has reached the destination.");

        scanner.close();
    }
}
