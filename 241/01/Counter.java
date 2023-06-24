package week01;

import java.util.*;
/**
 *This is a Counter for words and lines through System Input.
 *@author NGSA7956 Samuel Ng
*/
public class Counter{
        /**This is the main method.
         *@param args These are the arguments that pass through the program. 
         */
    public static void main(String[] args){ 
        int lines = 0, words = 0;
        String a = "";
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            a = sc.nextLine();
            if(!a.isEmpty()){
                words += a.split("\\s+").length;
            }
            lines++;
        }
        System.out.println("lines: " + lines);
        System.out.println("words: " + words);
    }
}
