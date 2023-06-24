package week04;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Iain Hewson modified by Samuel Ng
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        final int[][] valid = { 
            { 1, 4, 5, 10, 11 }, 
            { 2, 6, 8 }, 
            { 3, 9, 12 }, 
            { 7 } 
        };
    }

    /**
     * This is a method to check if the array values are from 1 to n.
     * 
     * @param t is the 2 dimensional array input.
     *
     * @return true or false depending on if the conditions are true.
     */
    public static boolean isSetOf1toN(int[][] t) {
    
        int arrsize = 0;
        for (int[] a : t){
            arrsize += a.length;
        }
        boolean[] arrsort = new boolean[arrsize];
        
        for (int[] a : t){
            for (int b : a) {
                if(b>arrsize || arrsort[b-1]){
                    return false;
                } else {
                    arrsort[b-1] = true;
                }
            }
        }
        
        for(boolean a : arrsort){
            if(!a){
                return false;
            }
        }
        return true;
    }

    /**
     * This is a method to check if array column values increase.
     * 
     * @param t is the 2 dimensional array input.
     *
     * @return true or false depending on the conditions.
     */
    public static boolean columnValuesIncrease(int[][] t) {
        for (int a = 1; a<t.length; a++){
            for (int b = 0; b<t[a].length; b++){
                if(t[a-1][b] > t[a][b]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This is a method to check if array row lengths decrease.
     * 
     * @param t is the input 2 dimensional array.
     *
     * @return true or false depending on the conditions.
     */
    public static boolean rowLengthsDecrease(int[][] t) {
        int c = t[0].length;
        for (int[] a : t) {
            if (a.length <= c) {
                c = a.length;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * This is a method to check if the values in rows increase.
     * 
     * @param t is the input 2 dimensional array.
     *
     * @return true or false depending on conditions.
     */
    public static boolean rowValuesIncrease(int[][] t) {
        for (int[] a : t) {
            for (int i=1; i<a.length;i++) {
                if(a[i-1]>a[i]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t) {
        if(rowValuesIncrease(t) && rowLengthsDecrease(t)){
            if(columnValuesIncrease(t) && isSetOf1toN(t)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

}
