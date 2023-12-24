package bullscows;

import java.util.ArrayList;
import java.util.Random;



public class CodeGenerator {

    int seed;
    private Random random;
    //private char[] charSpace= {0,1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private ArrayList<Character> charSpace;

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
        random.setSeed(seed);
    }

    public CodeGenerator(int seed) {
        this.seed = seed;
        this.random = new Random(seed);
        this.charSpace = new ArrayList<Character>();

        //initialise array
        for (char ch = '0'; ch <= '9'; ch++) {
            charSpace.add(ch);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            charSpace.add(ch);
        }
    } //constructor

    static String genSecretCodeOld(int desiredLength) {
        StringBuilder code = new StringBuilder();
        while (code.length() < desiredLength) {
            Random random = new Random();
            String pseudoRandomNumber = String.valueOf(random.nextInt());
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

    public String genSecretCode(int desiredLength, int numUniqueCharacters) {
        ArrayList<Character> charSet = new ArrayList<Character>(charSpace);
        StringBuilder code = new StringBuilder();
        while (code.length() < desiredLength) {
            int dice = this.random.nextInt(numUniqueCharacters - code.length());
            code.append(charSet.get(dice));
            charSet.remove(dice);
        }
        String bs;
        if (desiredLength <= 10) {
            bs = "0-" + charSpace.get(numUniqueCharacters - 1);
        } else {
            bs = "0-9, a-" + charSpace.get(numUniqueCharacters - 1);
        }

        System.out.println("The secret is prepared: %s (%s).".formatted("*".repeat(code.length()),bs));
        return code.toString();

    }
}
/*
new code generator

random int between 0 and numUniqueCharacters clamp that by the arraylist length - current built code length
so that a value larger than the array lists length is wrapped around, and we don't slide down adding uniques

simply append this character to a StringBuilder code
and remove this index from the list
bam, all uniques,




 */