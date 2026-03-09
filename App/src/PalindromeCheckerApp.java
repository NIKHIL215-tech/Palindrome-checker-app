import java.util.Scanner;

class PalindromeService {
    public boolean check(String input) {
        if (input == null || input.isEmpty()) return false;

        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int start = 0;
        int end = cleaned.length() - 1;

        while (start < end) {
            if (cleaned.charAt(start) != cleaned.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PalindromeService service = new PalindromeService();

        System.out.print("Enter text for OO Palindrome Check: ");
        String userInput = scanner.nextLine();

        boolean result = service.check(userInput);

        System.out.println("-----------------------------------");
        if (result) {
            System.out.println("Result: Success! The input is a palindrome.");
        } else {
            System.out.println("Result: Failure! The input is not a palindrome.");
        }
        System.out.println("-----------------------------------");

        scanner.close();
    }
}
