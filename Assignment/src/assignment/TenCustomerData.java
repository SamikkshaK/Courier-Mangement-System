package assignment;

public class TenCustomerData {

    public static boolean validate(String data, String detail) {
        switch (detail.toLowerCase()) {
            case "name":
               
                return data.matches("([A-Z][a-z]+)(\\s[A-Z][a-z]+)*");

            case "address":
                
                return data.matches("[\\w\\s.,'-]+");

            case "phone":
                
                return data.matches("\\d{3}-\\d{3}-\\d{4}");

            default:
                return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validate("Samikksha Raj", "name"));          // true
        System.out.println(validate("123 Main Street", "address"));     // true
        System.out.println(validate("123-456-7890", "phone"));          // true
        System.out.println(validate("john@doe", "name"));               // false
        System.out.println(validate("No.12@# Main Rd", "address"));     // false
        System.out.println(validate("1234567890", "phone"));            // false
    }
}

