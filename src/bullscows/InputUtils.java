package bullscows;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = ModeDetector.detectMode().equals("Check") ? new Scanner(System.in) : new Scanner("""
            6
            5
            1a34
            b354
            93b4
            """);

    static int getLength() {
        int input = Integer.parseInt(scanner.nextLine());
        if (input > 36 || input < 1) {
            System.out.println("Error: Code length must be between 1-36");
            System.exit(0);
        }
        return input;
    }

    static int getNumUniqueChars(int length) {
        int input = Integer.parseInt(scanner.nextLine());
        if (input <= length) {
            System.out.println("Error: can't generate a secret number with a unique character set less than the length.");
            System.exit(0);
        }
        if (input > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }
        return input;
    }

    static String getGuess() {
        String input = scanner.nextLine();
        if (input.length() != Main.secretCode.length()) {
            System.out.println("Error: Guess must be same length as code.");
        }
        return input;
    }
}
