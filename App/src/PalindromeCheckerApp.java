import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String original = scanner.nextLine();

        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }

        if (original.equalsIgnoreCase(reversed)) {
            System.out.println("Result: '" + original + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + original + "' is not a palindrome.");
        }

        scanner.close();
    }
}
