import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

interface PalindromeStrategy {
    boolean checkPalindrome(String str);
}

class StackStrategy implements PalindromeStrategy {
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

class DequeStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast())
                return false;
        }

        return true;
    }
}

public class UseCase12PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.print("Choose Strategy (1-Stack, 2-Deque): ");
        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1)
            strategy = new StackStrategy();
        else
            strategy = new DequeStrategy();

        if (strategy.checkPalindrome(input))
            System.out.println("The given string is a Palindrome.");
        else
            System.out.println("The given string is NOT a Palindrome.");

        sc.close();
    }
}