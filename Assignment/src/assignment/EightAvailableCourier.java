package assignment;

import java.util.Scanner;

class CourierInfo {
    String name;
    int distanceFromWarehouse;
    boolean isAvailable;

    public CourierInfo(String name, int distanceFromWarehouse, boolean isAvailable) {
        this.name = name;
        this.distanceFromWarehouse = distanceFromWarehouse;
        this.isAvailable = isAvailable;
    }
}

public class EightAvailableCourier {

    public static CourierInfo findNearestCourier(CourierInfo[] couriers, int targetDistance) {
        CourierInfo nearest = null;
        int minDifference = Integer.MAX_VALUE;

        for (CourierInfo c : couriers) {
            if (c.isAvailable) {
                int diff = Math.abs(c.distanceFromWarehouse - targetDistance);
                if (diff < minDifference) {
                    minDifference = diff;
                    nearest = c;
                }
            }
        }

        return nearest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CourierInfo[] couriers = {
            new CourierInfo("Ravi Kumar", 10, true),
            new CourierInfo("Meena Joshi", 20, true),
            new CourierInfo("Arjun Singh", 15, false),
            new CourierInfo("Neha Sharma", 25, true)
        };

        System.out.print("Enter your delivery location distance from warehouse: ");
        int userDistance = scanner.nextInt();

        CourierInfo nearest = findNearestCourier(couriers, userDistance);

        if (nearest != null) {
            System.out.println("Nearest available courier is: " + nearest.name + " (Distance: " + nearest.distanceFromWarehouse + ")");
        } else {
            System.out.println("No available courier found near your location.");
        }

        scanner.close();
    }
}
