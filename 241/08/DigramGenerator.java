package week08;

import java.util.*;
import java.io.*;

/**
 * A word generator that utilizes a set of commonly following letters to create
 * random words.
 * 
 * @author Samuel
 *
 */
public class DigramGenerator implements WordGenerator {
    /**
     * A random instance to be initialized and used.
     */
    private Random random;
    /**
     * A blank string to store the value from a file.
     */
    private String s = "";
    /**
     * An array of string to store multiple lines from a file.
     */
    private String[] a = new String[maxLines()];

    /**
     * A constructor that initializes random for usage.
     * 
     * @param r is the Random variable to be initialized.
     */
    public DigramGenerator(Random r) {
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
            Scanner sc = new Scanner(new File("continuations.txt"));
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
     * A method to generate a word based upon the most commonly following
     * letters.
     * 
     * @param n as the length of the word.
     * @return ret as the word.
     */
    public String nextWord(int n) {
        readStr();
        readStrArr();

        int rand = random.nextInt(s.length());
        char fir = s.charAt(rand);

        String ret = "" + fir;

        int dex;

        for (int i = 1; i < n; i++) {
            dex = (fir - 'a');
            String temp = a[dex];
            rand = random.nextInt(temp.length());
            ret += temp.charAt(rand);
            fir = temp.charAt(rand);
        }

        return ret;
    }
/**
 * The method that reads a single line on a file into the string. 
 * Actually overkill, its just a line. 
 */
    public void readStr() {
        try {
            Scanner sc = new Scanner(new File("first-letters.txt"));
            while (sc.hasNext()) {
                s += sc.next();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Well, thats an error!");
            e.printStackTrace();
        }
    }
/**
 * The method that reads the next variable into a String Array.
 */
    public void readStrArr() {
        try {
            Scanner sc = new Scanner(new File("continuations.txt"));
            for (int i = 0; sc.hasNext(); i++) {
                a[i] = sc.next();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Well, thats an error!");
            e.printStackTrace();
        }
    }

}
