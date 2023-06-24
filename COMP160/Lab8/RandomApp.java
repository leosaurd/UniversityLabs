/**
 * RandomApp.java
 * Lab 8, Part 2, COMP160  2019
 * Displays a random integer between high and low limits
 * High and low values are typed in by the user.
 */

/**
 * RandomRange.java
 * Lab 8, Part 2, COMP160  2019
 * Contains a single method which returns random integer between high and low parameters.
 */

import java.util.Scanner;

public class RandomApp{
  public static void main(String[] args){ 
    int lo = readInt("Enter lowest value");
    int hi = readInt("Enter highest value");
    RandomRange r = new RandomRange();
    System.out.println("Random integer between " + lo + " and " + hi + " : " + r.randomRange(lo, hi)); 
  }
  
  /** Returns an integer entered by the user
    @param message a prompt to the user
    @return an integer typed by the user*/
    public static int readInt(String message){
      Scanner sc = new Scanner(System.in);
      System.out.println(message);
      return sc.nextInt();
    }
  
}




