import java.util.*;


public class NewString{
  
  public static void main(String[] args){
    String[] fruits = new String[3];//Create array w limit
    
    Scanner sc = new Scanner(System.in);//Create scanner
    
    for (int a = 0; a<3;a++){//Prompt user 3 times
      System.out.println("Please enter fruit No. " + (a+1));
      fruits[a] = sc.nextLine();
    }
    for (String a : fruits){
      System.out.println("Guess what fruit I am?\t" + a.substring(0, 2) + "\t" + a.length() + " letters");//Initial Question
      String b = sc.nextLine();
      
      while(!b.equals(a)){//Loop if it is wrong
        System.out.println("Try Again");
        System.out.println("Guess what fruit I am?\t" + a.substring(0, 2) + "\t" + a.length() + " letters");
        b = sc.nextLine();
      }
      
      System.out.println("Correct");//Passed by while loop means correct already
      
    }
  }
}