package assignment;


import java.util.*;

class Courier {
    int courierId;
    String name;
    int maxCapacity;
    int currentLoad;
    int distanceFromPickup;

    public Courier(int courierId, String name, int maxCapacity, int currentLoad, int distanceFromPickup) {
        this.courierId = courierId;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentLoad = currentLoad;
        this.distanceFromPickup = distanceFromPickup;
    }

    public boolean canTakeShipment(int shipmentWeight) {
        return (maxCapacity - currentLoad) >= shipmentWeight;
    }
}

public class FourCourierAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Courier[] couriers = {
            new Courier(1, "Ravi Kumar", 100, 80, 5),
            new Courier(2, "Meena Joshi", 120, 50, 2),
            new Courier(3, "Arjun Singh", 90, 85, 3)
        };

        System.out.print("Enter shipment weight: ");
        int shipmentWeight = scanner.nextInt();

        Courier bestCourier = null;
        int shortestDistance = Integer.MAX_VALUE;

        for (Courier c : couriers) {
            if (c.canTakeShipment(shipmentWeight)) {
                if (c.distanceFromPickup < shortestDistance) {
                    bestCourier = c;
                    shortestDistance = c.distanceFromPickup;
                }
            }
        }

        if (bestCourier != null) {
            System.out.println("Assigned Courier: " + bestCourier.name + " (ID: " + bestCourier.courierId + ")");
        } else {
            System.out.println("No suitable courier available for this shipment.");
        }

        scanner.close();
    }
}
