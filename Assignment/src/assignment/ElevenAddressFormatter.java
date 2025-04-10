package assignment;

import java.util.Scanner;

public class ElevenAddressFormatter {

    public static String capitalizeWords(String input) {
        String[] words = input.trim().toLowerCase().split(" ");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                           .append(word.substring(1))
                           .append(" ");
            }
        }

        return capitalized.toString().trim();
    }

    public static boolean isValidZip(String zip) {
        return zip.matches("\\d{6}");
    }

    public static String formatAddress(String street, String city, String state, String zip) {
        if (!isValidZip(zip)) {
            return "Invalid ZIP code. Must be 6 digits.";
        }

        String formattedStreet = capitalizeWords(street);
        String formattedCity = capitalizeWords(city);
        String formattedState = capitalizeWords(state);

        return formattedStreet + ", " + formattedCity + ", " + formattedState + " - " + zip;
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter Street: ");
        String street = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.print("Enter State: ");
        String state = sc.nextLine();

        System.out.print("Enter ZIP Code: ");
        String zip = sc.nextLine();

        String formattedAddress = formatAddress(street, city, state, zip);
        System.out.println("\nFormatted Address:");
        System.out.println(formattedAddress);
    }
}

