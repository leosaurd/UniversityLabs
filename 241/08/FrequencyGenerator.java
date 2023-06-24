package week08;

import java.util.*;
import java.io.*;

/**
 * A class to generate random words using weighted frequencies.
 * 
 * @author Samuel Ng Shan Feng NGSA7956
 *
 */
public class FrequencyGenerator implements WordGenerator {
    /**
     * Random variable to apply randomness.
     */
    private Random random;
    /**
     * array of double, utilizing a method to count the lines in the file.
     */
    private double[] freq = new double[maxLines()];

    /**
     * The constructor for Frequency Generator, where it initializes random.
     * 
     * @param r is the random variable to be initialized.
     */
    public FrequencyGenerator(Random r) {
        random = r;
    }

    /**
     * A method that counts the amount of lines in a file, and returns it as an
     * int.
     * 
     * @return i as integer
     */
    public int maxLines() {
        int i = 0;
        try {
            Scanner sc = new Scanner(new File("letter-frequencies.txt"));

            while (sc.hasNext()) {
                i++;
                sc.next();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Well, thats an error!");
            e.printStackTrace();
        }
        return i;
    }

    /**
     * A method to generate the word with the relevant methods.
     * 
     * @param n as the length of the word
     * @return s as a word.
     */
    public String nextWord(int n) {
        char c = 'a';
        String s = "";
        read();

        for (int i = 0; i < n; i++) {
            c = (char) ('a' + chooseIndex(freq));
            s += c;
        }
        return s;
    }

    /**
     * a method to populate the array with a read file.
     */
    public void read() {
        try {
            Scanner sc = new Scanner(new File("letter-frequencies.txt"));
            for (int i = 0; sc.hasNextDouble(); i++) {
                freq[i] = sc.nextDouble();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Well, thats an error!");
            e.printStackTrace();
        }

    }

    /**
     * the given algorithm to choose an index.
     * 
     * @param a is an array of double that should input the frequencies.
     * @return i as in integer for the index.
     */
    public int chooseIndex(double[] a) {
        read();
        int i = 0;
        double r = random.nextDouble();
        while (r > a[i]) {
            r = r - a[i];
            i++;
        }
        return i;
    }

}
