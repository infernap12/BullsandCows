package bullscows;

import java.util.Scanner;

public class Main {

//    private static int turn = 0;
    private static String secretCode = "9305";
    private static Scanner scanner = new Scanner(System.in);
//    private static Scanner scanner = new Scanner("""
//        6
//        000000
//        111111
//        222222
//        333333
//        444444
//        555555
//        666666
//        777777
//        888888
//        999999""");
    private static StringBuilder output = new StringBuilder("Grade: ");
    public static void main(String[] args) {
        System.out.println("Please, enter the secret code's length:");
        secretCode = genSecretCode(getLength());
        Game();
        //System.out.println("The random secret number is %s.".formatted(secretCode));
    }

    private static int getLength() {
        int nextInt = scanner.nextInt();
        if (nextInt > 10) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            System.exit(0);
        }
        return nextInt;
    }

    private static String genSecretCode(int desiredLength) {
        StringBuilder code = new StringBuilder();
        while (code.length() < desiredLength) {
         String pseudoRandomNumber = String.valueOf(System.nanoTime());
            outer:
            for (int i = 0; i < pseudoRandomNumber.length() && code.length() < desiredLength; i++) {
                char c = pseudoRandomNumber.charAt(pseudoRandomNumber.length() - 1 - i);
                if (code.isEmpty()) {
                    if (c != '0') {
                        code.append(c);
                    }
                    continue;
                }
                for (int j = 0; j < code.length(); j++) {
                    if ((c == code.charAt(j))) {
                        continue outer;
                    }

                }
                code.append(c);
            }
        }
        return code.toString();
    }

    /*
    while code isnt long enough >
    gen some data

    iterate the data for i < the length of data && code.length < length
        iterate the codebuilder for the length of code
     */

    private static void Game() {
        System.out.println("Okay, let's start a game!");


        int bull = 0;
        while (bull != secretCode.length()) {
            bull = 0;
            int cow = 0;
            int turn = 0;
            turn++;
            System.out.println("Turn %d:".formatted(turn));
            String guess = String.valueOf(scanner.next());

            for (int i = 0; i < guess.length(); i++) {  //iterate the guess

                for (int j = 0; j < secretCode.length(); j++) {

                    if (guess.charAt(i) == secretCode.charAt(j)) {
                        if (j == i) {
                            bull++;
                        } else {
                            cow++;
                        }
                        break;
                    }

                }
            }
            System.out.println("Grade: %d bulls and %d cows".formatted(bull, cow));
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }
}
// use two arrays to compare, input and secret code (or use .charat() dummy) or maybe char[] //investigate

// use string builder for output

/*
double fori
 */