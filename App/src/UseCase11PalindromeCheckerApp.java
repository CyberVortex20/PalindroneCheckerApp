import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class UseCase13PalindromeCheckerApp {

    public static boolean stackPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++)
            stack.push(str.charAt(i));

        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) != stack.pop())
                return false;

        return true;
    }

    public static boolean dequePalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++)
            deque.addLast(str.charAt(i));

        while (deque.size() > 1)
            if (deque.removeFirst() != deque.removeLast())
                return false;

        return true;
    }

    public static boolean twoPointerPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        input = input.replaceAll("\\s+", "").toLowerCase();

        long start1 = System.nanoTime();
        boolean result1 = stackPalindrome(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = dequePalindrome(input);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean result3 = twoPointerPalindrome(input);
        long end3 = System.nanoTime();

        System.out.println("Stack Method Result: " + result1 + " Time: " + (end1 - start1) + " ns");
        System.out.println("Deque Method Result: " + result2 + " Time: " + (end2 - start2) + " ns");
        System.out.println("Two Pointer Method Result: " + result3 + " Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}