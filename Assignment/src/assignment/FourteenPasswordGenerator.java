package assignment;

import java.util.Random;

public class FourteenPasswordGenerator {

    public static String generatePassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String special = "!@#$%^&*()-_=+<>?/";

        String combined = upper + lower + numbers + special;
        Random random = new Random();

        
        StringBuilder password = new StringBuilder();
        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(special.charAt(random.nextInt(special.length())));

        
        for (int i = 4; i < length; i++) {
            password.append(combined.charAt(random.nextInt(combined.length())));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        int desiredLength = 12; 
        String password = generatePassword(desiredLength);
        System.out.println("Generated Secure Password: " + password);
    }
}
