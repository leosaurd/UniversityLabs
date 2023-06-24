import java.util.*;

public class HarmoniousNumbers {

    public static void main(String[] args) {
        //Map is simply just to prevent repeated values.
        HashMap<Integer, Integer> l = new HashMap<Integer, Integer>(2000000);
        for (int i = 1; i <= 2000000; i++) {
            int a = getDivisorSum(i);
            int b = getDivisorSum(a);
            if (b == i && !l.containsKey(b) && !l.containsKey(a) && b != a) {
                l.put(b, a);
                l.put(a, b);
                System.out.println(b + " " + a);
            }
        }
    }
    // Code taken from:
    // https://www.geeksforgeeks.org/find-divisors-natural-number-set-1/
    // and modified by me.
    public static int getDivisorSum(int n) {
        int sum = 0;//for amicable numbers, change this to 1.(adding 1, basically).
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                if (n / i == i) {
                    sum += i;
                } else {
                    sum += (i + n / i);
                }
        }
        return sum;
    }
}
