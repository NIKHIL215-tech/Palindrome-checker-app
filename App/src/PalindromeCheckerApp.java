import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        char[] charArray = input.toCharArray();

        boolean isPalindrome = checkPalindrome(charArray);

        if (isPalindrome) {
            System.out.println("Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is not a palindrome.");
        }

        scanner.close();
    }

    public static boolean checkPalindrome(char[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (Character.toLowerCase(arr[start]) != Character.toLowerCase(arr[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
