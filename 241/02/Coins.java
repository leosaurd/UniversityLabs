package week02;
/**
 * This is a Class that uses Array of Boolean to show coin flips.
 * It has several interactive methods.
 * @author NGSA7956 Samuel Ng Shan Feng
 */
public class Coins{
    /**
     * This is a boolean that uses true to represent HEADS.
     */
    public static final boolean HEADS = true;
    /**
     * This is a boolean that uses false to represent TAILS.
     */
    public static final boolean TAILS = false;
    /**
     * This is the array where coin flips are stored.
     */
    private boolean[] coins;
    /**
     * This is the main class, where testing for the various methods are done.
     *
     * @param args is a String Array
     */
    public static void main(String[] args) {
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        Coins c = new Coins(10);
        System.out.println(c.countHeads());
        System.out.println(c.toString());
        System.out.println(c.countRuns());
    }
    /**
     * This is a constructor which lets you create the boolean array directly.
     * @param coins is a Array of Boolean.
     */
    public Coins(boolean[] coins) {
        this.coins = coins;
    }
    /**
     * This is a constructor which uses a String to create the boolean array.
     * It generates the array based on H's in the String.
     * @param c is a input String.
     */
    public Coins(String c) {
        boolean[] coins = new boolean[c.length()];
        for(int a = 0; a < c.length(); a++){
            if(c.charAt(a) == 'H'){
                coins[a] = HEADS;
            }else{
                coins[a] = TAILS;
            }
        }
        this.coins = coins;
    }
    /**
     * This is a constructor which uses a integer to create the boolean array.
     * It uses randomized numbers to generate Heads or Tails.
     * @param length is an input integer.
     */
    public Coins(int length) {
        boolean[] coins = new boolean[length];
        for(int a = 0; a<length;a++){
            if(Math.round(Math.random()) == 1){
                coins[a] = HEADS;
            }else{
                coins[a] = TAILS;
            }
        }
        this.coins = coins;
    }
    /**
     * This is a method that counts the HEADS within the array. 
     * @return int count
     */
    public int countHeads() {
        int count = 0;
        for(boolean b : this.coins) {
            if(b){
                count++;
            }
        }
        return(count);
    }
    /**
     * This is a method that  counts the different 'sets' of consecutive flips.
     * @return int count
     */
    public int countRuns(){
        int count = 1;
        boolean a = this.coins[0];
        for(int b = 0; b<this.coins.length; b++){
            if(a != this.coins[b]){
                count++;
                a=this.coins[b];
            }
        }
        return count;
    }
    /**
     * This is the toString method.
     * It displays the flips in Heads, and Tails using H and T respectively.
     * @return String a
     */
    public String toString() {
        String a = "";
        for (boolean b : this.coins) {
            if(b) {
                a += "H";
            }else{
                a += "T";
            }
        }
        return a;
    }
}
