import java.util.*;


public class IntCounterApp{
  
  public static void main(String[] args){
    IntCounterApp a = new IntCounterApp();
    Scanner scan = new Scanner(System.in);
    for(int i = 0; i < 4; i++){
      System.out.println("Please input target integer:");
      IntCounter one = new IntCounter(a.makeArray());
      one.showTarget(scan.nextInt());
    }
  }
  
  public int[] makeArray(){
    Random rand = new Random();
    int randomNum = rand.nextInt(6) +5;
    int[] randray = new int[randomNum];
    for(int i = 0; i <randray.length;i++)
      randray[i] = rand.nextInt(4) + 1;
    return randray;
  }
}