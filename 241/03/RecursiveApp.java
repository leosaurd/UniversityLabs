package week03;

/**
 * This is a program that demonstrates recursion.
 * It uses recursion to get length of a number, or sum of its digits.
 * 
 * @author Samuel Ng NGSA7956
 */
public class RecursiveApp {

    /**
     * This is the value for both sorting, and dividing.
     */
    private static final long NUMBER = 10;

    /**
     * This is a method that gets the length of a number.
     * 
     * @param n is the input number in long.
     * @return returns the length of a number(ie, 257 has length of 3).
     */
    public static long digits(long n) {
        if (n < NUMBER && n > NUMBER*-1) {
            return 1;
        } else {
            return 1 + digits(n / NUMBER);
        }
    }

    /**
     * This is a method to get the Sum of Digits in a number.
     * 
     * @param n is the input number in long.
     * @return returns the sum of digits(ie, 257 = 14).
     */
    public static long sumOfDigits(long n) {
        if (n != 0) {
            return sumOfDigits(n / NUMBER) + (n % NUMBER);
        }
        return (long) 0;
    }
}
