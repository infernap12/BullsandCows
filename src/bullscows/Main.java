package bullscows;

import java.util.Scanner;

public class Main {

//    private static int turn = 0;
    private static String secretCode = "9305";
    private static Scanner scanner = new Scanner(System.in);
    private static StringBuilder output = new StringBuilder("Grade: ");
    public static void main(String[] args) {
        secretCode = genSecretCode(getLength());
        //Game();
        System.out.println("The random secret number is %s.".formatted(secretCode));
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
        int bull = 0;
        int cow = 0;
        String input = String.valueOf(scanner.nextInt());

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == secretCode.charAt(i)) {
                bull++;
                continue;
            }
            for (int j = 0; j < secretCode.length(); j++) {
                if (input.charAt(i) == secretCode.charAt(j)) {
                    cow++;
                }
            }
        }
        if (bull > 0 && cow == 0) {
            output.append("%d bull(s).".formatted(bull));
        }
        else if (cow > 0 && bull == 0) {
            output.append("%d cow(s).".formatted(cow));
        }
        else if (bull > 0 && cow > 0) {
            output.append("%d bull(s) and %d cow(s).".formatted(bull, cow));
        } else {
            output.append("None.");
        }
        output.append(" The secret code is %s.".formatted(secretCode));

        System.out.println(output.toString());
    }
}
// use two arrays to compare, input and secret code (or use .charat() dummy) or maybe char[] //investigate

// use string builder for output

/*
double fori
 */