package assignment;

import java.util.Scanner;

public class TwoSwitchcase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter parcel weight in kg: ");
        int weight = scanner.nextInt();

        String category;

        switch (weight / 10) {
            case 0:
            case 1:
                category = "Light";
                break;
            case 2:
            case 3:
            case 4:
                category = "Medium";
                break;
            default:
                category = "Heavy";
        }

        System.out.println("Parcel category: " + category);
        scanner.close();
    }
}
