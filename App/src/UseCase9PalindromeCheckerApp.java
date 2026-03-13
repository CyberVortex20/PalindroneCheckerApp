import java.util.Scanner;
import java.util.Stack;

class PalindromeChecker {
    public boolean checkPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop())
                return false;
        }

        return true;
    }
}

public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeChecker checker = new PalindromeChecker();

        if (checker.checkPalindrome(input))
            System.out.println("The given string is a Palindrome.");
        else
            System.out.println("The given string is NOT a Palindrome.");

        sc.close();
    }
}