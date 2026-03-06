public class UseCase4PalindromeCheckerApp {

    public static void main(String[] args) {

        // Original string
        String word = "radar";

        // Convert string to character array
        char[] chars = word.toCharArray();

        // Two pointers
        int start = 0;
        int end = chars.length - 1;

        boolean isPalindrome = true;

        // Compare characters using two-pointer technique
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is not a Palindrome.");
        }
    }
}