import java.util.Scanner;

public class Anagram{
  public static void main(String[] args){
    
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Enter first phrase:");
    String phrase = scan.nextLine();
    System.out.println("Enter second phrase:");
    String secphrase = scan.nextLine();
    
    String empt_1 = "", empt_2 = "";
    String lphrase = phrase.toLowerCase();
    String lsecphrase = secphrase.toLowerCase();
    
    for(char c = 'a'; c <= 'z'; c++){
      for (int count = 0; count < lphrase.length(); count++){
        if (c == lphrase.charAt(count)){
          empt_1 += c;
        }
      }
      for (int count = 0; count < lsecphrase.length(); count++){
        if (c == lsecphrase.charAt(count)){
          empt_2 += c;
        }
      }
    }
    System.out.println(empt_1 + " are the letters of " + lphrase + " in order.\n" + empt_2 + " are the letters of " + lsecphrase + " in order.");
    
    if (empt_1.equals(empt_2))
      System.out.println(phrase + " is an anagram of " + secphrase);
  }
}