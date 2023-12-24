package bullscows;

import java.util.ArrayList;
import java.util.Random;



public class CodeGenerator {

    int seed;
    private final Random random;
    //private char[] charSpace= {0,1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private final ArrayList<Character> charSpace;

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
        this.charSpace = new ArrayList<>();

        //initialise array
        for (char ch = '0'; ch <= '9'; ch++) {
            charSpace.add(ch);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            charSpace.add(ch);
        }
    } //constructor

    public String genSecretCode(int desiredLength, int numUniqueCharacters) {
        ArrayList<Character> charSet = new ArrayList<>(charSpace);
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

        System.out.printf("The secret is prepared: %s (%s).%n", "*".repeat(code.length()),bs);
        return code.toString();

    }
}