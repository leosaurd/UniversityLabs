package week06;

import java.util.Scanner;

/**
 * This is a program that will count the String input from System. It will also
 * calculate the average word length, and print out words above that length.
 * Additionally, it will only print average length, if there are input words.
 * 
 * @author Samuel Ng Shan Feng
 *
 */
public class LongWords {
    /**
     * This is the maximum words allowed for the string.
     */
    private final static int MAX_WORDS = 100;

    /**
     * This is the main class that runs the entire program.
     * 
     * @param args is a string array, that was used to store the input Strings.
     */
    public static void main(String[] args) {
        args = new String[MAX_WORDS];

        double avg = 0;
        int count = 0;

        Scanner in = new Scanner(System.in);

        while (in.hasNext() && count != MAX_WORDS) {
            args[count] = in.next();
            avg += args[count].length();
            count++;
        }

        avg = avg / (double) count;

        for (int i = count; i > 0; i--) {
            if (args[i-1].length() > avg) {
                System.out.println(args[i-1]);
            }

        }

        if (!(count == 0)) {
            System.out.println("Average: " + String.format("%.2f", avg));
        }
    }

}
