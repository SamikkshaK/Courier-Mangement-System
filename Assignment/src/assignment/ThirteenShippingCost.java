package assignment;

import java.util.Scanner;

public class ThirteenShippingCost {

    
    public static int getDistance(String source, String destination) {
        source = source.toLowerCase();
        destination = destination.toLowerCase();

        if (source.equals(destination)) return 0;

        if ((source.equals("chennai") && destination.equals("bangalore")) ||
            (source.equals("bangalore") && destination.equals("chennai")))
            return 350;
        else if ((source.equals("chennai") && destination.equals("mumbai")) ||
                 (source.equals("mumbai") && destination.equals("chennai")))
            return 1330;
        else if ((source.equals("delhi") && destination.equals("mumbai")) ||
                 (source.equals("mumbai") && destination.equals("delhi")))
            return 1450;
        else if ((source.equals("kolkata") && destination.equals("delhi")) ||
                 (source.equals("delhi") && destination.equals("kolkata")))
            return 1500;
        else
            return 1000; 
    }

    
    public static double calculateShippingCost(String source, String destination, double weightKg) {
        int distance = getDistance(source, destination);
        double baseRate = 50.0;
        double ratePerKm = 0.5;
        double ratePerKg = 10.0;

        return baseRate + (distance * ratePerKm) + (weightKg * ratePerKg);
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter source location: ");
        String source = sc.nextLine();

        System.out.print("Enter destination location: ");
        String destination = sc.nextLine();

        System.out.print("Enter weight of the parcel (kg): ");
        double weight = sc.nextDouble();

        double cost = calculateShippingCost(source, destination, weight);

        System.out.printf("Shipping cost from %s to %s for %.2f kg = %.2f\n",
                          source, destination, weight, cost);
    }
}
