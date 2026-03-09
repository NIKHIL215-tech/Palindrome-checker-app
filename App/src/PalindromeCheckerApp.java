import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a long string to test performance: ");
        String input = scanner.nextLine();

        long startIterative = System.nanoTime();
        boolean res1 = checkIterative(input);
        long endIterative = System.nanoTime();
        long durationIterative = endIterative - startIterative;

        long startStack = System.nanoTime();
        boolean res2 = checkStack(input);
        long endStack = System.nanoTime();
        long durationStack = endStack - startStack;

        System.out.println("\n--- Performance Results ---");
        System.out.println("Iterative (Two-Pointer): " + durationIterative + " ns");
        System.out.println("Stack-Based Approach:  " + durationStack + " ns");

        double difference = (double) durationStack / durationIterative;
        System.out.printf("The Iterative approach was %.2fx faster than the Stack approach.%n", difference);

        scanner.close();
    }

    public static boolean checkIterative(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }

    public static boolean checkStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) stack.push(ch);
        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }
}
