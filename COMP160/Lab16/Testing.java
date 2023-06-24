import java.util.*;

public class Testing{
  public static void main(String[] args){
    String a = "Hello World, I am a thing";
    
    Scanner sc = new Scanner(a);//Scanner to parse a string
    while(sc.hasNext())//check if has next words
      System.out.println(sc.next().substring(0, 1));//print the next word
  }
}