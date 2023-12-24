package bullscows;

import static bullscows.InputUtils.*;

public class Main {
    static String secretCode = "9305";

    public static void main(String[] args) {
        System.out.println("Please, enter the secret code's length:");
        int length = 0;
        int numUniqueCharacters = 0;
        try {
            length = getLength();
            numUniqueCharacters = getNumUniqueChars(length);
        } catch (NumberFormatException e) {
            System.out.println("Error: \"abc 0 -7\" isn't a valid number.");
            System.exit(0);
        }
        CodeGenerator gen = new CodeGenerator(25565);
        secretCode = gen.genSecretCode(length,numUniqueCharacters);
        Game();
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
            String guess = getGuess();

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