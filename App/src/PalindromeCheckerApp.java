import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean isPalindrome = checkRecursive(input, 0, input.length() - 1);

        if (isPalindrome) {
            System.out.println("Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is not a palindrome.");
        }

        scanner.close();
    }

    public static boolean checkRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (Character.toLowerCase(str.charAt(start)) != Character.toLowerCase(str.charAt(end))) {
            return false;
        }

        return checkRecursive(str, start + 1, end - 1);
    }
}
