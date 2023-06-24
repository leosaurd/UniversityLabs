import java.util.Scanner;


public class Sum {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int count = 0, sum = 0;
    System.out.println("Enter an integer greater than 1");
    int val = scan.nextInt();
    if(val<2)
      System.out.println("Value must not be less than 2");
    else while(count<=val){
      if(count % 2 == 0)
        sum+= count;
      if (count==val)
        System.out.println("Sum of even numbers between 2 and " + val + " inclusive is: " + sum); 
      count++;
    }
  }
}