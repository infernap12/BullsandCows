package bullscows;

import java.util.Scanner;

public class Main {
    private static String secretCode = "9305";

    private static final Scanner scanner = ModeDetector.detectMode().equals("Check") ? new Scanner(System.in) : new Scanner("""
        4
        16
        1a34
        b354
        93b4
        """);

    public static void main(String[] args) {
        System.out.println("Please, enter the secret code's length:");
        int length = getLength();
        CodeGenerator gen = new CodeGenerator(25565);
        int numUniqueCharacters = getNumUniqueChars(length);
        secretCode = gen.genSecretCode(length,numUniqueCharacters);
        Game();
    }

    private static int getLength() {
        int input = scanner.nextInt();
        if (input > 36) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            System.exit(0);
        }
        return input;
    }

    private static int getNumUniqueChars(int length) {
      int input = scanner.nextInt();
        if (input <= length) {
            System.out.println("Error: can't generate a secret number with a unique character set less than the length.");
            System.exit(0);
        }
        return input;
    }
    private static void Game() {
        System.out.println("Okay, let's start a game!");

        int turn = 0;
        int bull = 0;
        while (bull != secretCode.length()) {
            bull = 0;
            int cow = 0;
            turn++;
            System.out.printf("Turn %d:%n", turn);
            String guess = String.valueOf(scanner.nextLine());

            for (int i = 0; i < guess.length(); i++) {  //iterate the guess

                for (int j = 0; j < secretCode.length(); j++) { //for each iterate of guess, iterate the code

                    if (guess.charAt(i) == secretCode.charAt(j)) { //if wherever we are matches,
                        if (j == i) { // if we happen to be in alignment
                            bull++; //that's a bull
                        } else {
                            cow++; // if not, that's a cow
                        }
                        break; //move to next character in the guess string
                    }

                }
            }
            System.out.printf("Grade: %d bulls and %d cows%n", bull, cow);
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }

}