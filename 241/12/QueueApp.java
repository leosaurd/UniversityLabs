package week12;

import java.util.Scanner;

/**
 * An application class to make use of TwoStackQueue with stdin input.
 * 
 * @author Samuel Ng 2955262
 *
 */
public class QueueApp {
    /**
     * The main method to function with the supporting class. Makes use of
     * String array and switch cases.
     * 
     * @param args is the arguments from command line, not used currently.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TwoStackQueue<String> ex = new TwoStackQueue<String>();
        while (sc.hasNextLine()) {
            String[] text = sc.nextLine().split(" ");
            switch (text[0]) {
                case "a":
                    for (int i = 1; i < text.length; i++) {
                        ex.add(text[i]);
                    }
                    break;
                case "c":
                    ex.clear();
                    break;
                case "d":
                    ex.debug();
                    break;
                case "g":
                    if (!ex.isEmpty()) {
                        System.out.println(ex.get());
                    }
                    break;
                case "p":
                    System.out.println(ex.toString());
                    break;
                case "r":
                    if (!ex.isEmpty()) {
                        System.out.println(ex.remove());
                    }
                    break;
                case "s":
                    if (!ex.isEmpty()) {
                        System.out.println(ex.size());
                    }
                    break;
                default:
                    System.out.println("Invalid char");
            }
        }
        sc.close();
    }

}
