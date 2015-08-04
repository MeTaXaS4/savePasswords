package savepasswords;

import java.util.Random;

/**
 *password random generator
 *   a class created by
 *       MeTaXaS4
 *   metaxas4@gmail.com
 */
public class genPassword {
    static final int sizeOfPassword=14;
    static char[] symbols = {'~', '!', '@', '#', '$', '%', '&', '*', '(', ')', '{', '}', '|', '[', ']', '<', '>'};
    static char[] uppercaseLetters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static char[] lowercaseLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    static char[] strongPassword = new char[sizeOfPassword];

    public static void shuffle() {
        Random randomNumber = new Random();
        for (int i = 0; i < sizeOfPassword; i++) {
            int randomPosition = randomNumber.nextInt(sizeOfPassword);
            char temp = strongPassword[i];
            strongPassword[i] = strongPassword[randomPosition];
            strongPassword[randomPosition] = temp;
        }
    }

    public static String generate() {
        Random randomNumber = new Random();
        int[] randomSizes=new int[3];
        randomSizes[0]=randomNumber.nextInt(sizeOfPassword);
        randomSizes[1]=randomNumber.nextInt(sizeOfPassword-randomSizes[0]);
        randomSizes[2]=randomNumber.nextInt(sizeOfPassword-randomSizes[0]-randomSizes[1]);

        for (int i = 0; i < sizeOfPassword; i++) {
            if (i < randomSizes[0] ) {
                strongPassword[i] = symbols[randomNumber.nextInt(symbols.length)];
            } else if (i < (randomSizes[0]+randomSizes[1])) {
                strongPassword[i] = uppercaseLetters[randomNumber.nextInt(uppercaseLetters.length)];
            } else if (i < (randomSizes[0]+randomSizes[1]+randomSizes[2])) {
                strongPassword[i] = lowercaseLetters[randomNumber.nextInt(lowercaseLetters.length)];
            } else {
                strongPassword[i] = numbers[randomNumber.nextInt(numbers.length)];
            }
        }
        shuffle();
        String returningString = new String(strongPassword);
        return returningString;
    }

    public static void main(String[] args) {
        System.out.println(generate());
    }
}
