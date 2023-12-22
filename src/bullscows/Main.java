package bullscows;

import java.util.Scanner;

public class Main {

//    private static int turn = 0;
    private static String secretCode = "9305";
    private static Scanner scanner = new Scanner(System.in);
    private static StringBuilder output = new StringBuilder("Grade: ");
    public static void main(String[] args) {
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