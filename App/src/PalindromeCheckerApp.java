import java.util.*;

interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : clean.toCharArray()) stack.push(ch);

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());

        return clean.equals(reversed.toString());
    }
}

class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left++) != clean.charAt(right--)) return false;
        }
        return true;
    }
}

class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCheck(String input) {
        return strategy.isPalindrome(input);
    }
}

// Main Application
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.print("Enter string: ");
        String text = scanner.nextLine();

        System.out.println("Select Strategy: 1. Stack 2. Two-Pointer");
        int choice = scanner.nextInt();

        if (choice == 1) {
            context.setStrategy(new StackStrategy());
            System.out.println("Using Stack Strategy...");
        } else {
            context.setStrategy(new TwoPointerStrategy());
            System.out.println("Using Two-Pointer Strategy...");
        }

        boolean result = context.executeCheck(text);
        System.out.println("Is Palindrome: " + result);

        scanner.close();
    }
}
