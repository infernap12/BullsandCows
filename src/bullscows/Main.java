package bullscows;

import java.util.Scanner;

public class Main {

//    private static int turn = 0;
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
        //System.out.println("The random secret number is %s.".formatted(secretCode));
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

    /*
    while code isn't long enough >
    gen some data

    iterate the data for i < the length of data && code.length < length
        iterate the codeBuilder for the length of code
     */

    private static void Game() {
        System.out.println("Okay, let's start a game!");

        int turn = 0;
        int bull = 0;
        while (bull != secretCode.length()) {
            bull = 0;
            int cow = 0;
            turn++;
            System.out.println("Turn %d:".formatted(turn));
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
            System.out.println("Grade: %d bulls and %d cows".formatted(bull, cow));
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }

}
// use two arrays to compare, input and secret code (or use .charAt() dummy) or maybe char[] //investigate

// use string builder for output

/*
The new maximum length for the code is 36. charSet max 36, codeLength max 36
length of the secret word may not match the number of possible characters in the secret code
request input twice: secret code length ,possible characters. //
 */