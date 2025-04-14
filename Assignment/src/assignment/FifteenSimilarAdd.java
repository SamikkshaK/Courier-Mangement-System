package assignment;

public class FifteenSimilarAdd {

    
    public static int getSimilarityScore(String address1, String address2) {
        address1 = address1.toLowerCase().replaceAll("[^a-z0-9 ]", "");
        address2 = address2.toLowerCase().replaceAll("[^a-z0-9 ]", "");

        String[] words1 = address1.split(" ");
        String[] words2 = address2.split(" ");

        int common = 0;
        for (String word1 : words1) {
            for (String word2 : words2) {
                if (word1.equals(word2)) {
                    common++;
                    break;
                }
            }
        }

        return (int) (((double) common / Math.max(words1.length, words2.length)) * 100); // return similarity percentage
    }

    
    public static void findSimilarAddresses(String[] addresses, int threshold) {
        for (int i = 0; i < addresses.length; i++) {
            for (int j = i + 1; j < addresses.length; j++) {
                int score = getSimilarityScore(addresses[i], addresses[j]);
                if (score >= threshold) {
                    System.out.println("Similar Addresses Found (" + score + "% match):");
                    System.out.println(" - " + addresses[i]);
                    System.out.println(" - " + addresses[j]);
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] addressList = {
            "123 Main Street, New York",
            "123 Main St., New York",
            "456 Elm Street, Los Angeles",
            "123 Main Street, NY",
            "789 Oak Avenue, Chicago",
            "123 Main Street New York"
        };

        int similarityThreshold = 70; 
        findSimilarAddresses(addressList, similarityThreshold);
    }
}
