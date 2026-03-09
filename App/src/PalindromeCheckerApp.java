import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string or phrase: ");
        String original = scanner.nextLine();

        String cleaned = original.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindrome = true;
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Original: " + original);
        System.out.println("Normalized: " + cleaned);
        if (isPalindrome && !cleaned.isEmpty()) {
            System.out.println("Result: It is a palindrome!");
        } else {
            System.out.println("Result: It is NOT a palindrome.");
        }

        scanner.close();
    }
}
