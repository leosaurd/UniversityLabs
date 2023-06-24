import java.util.Scanner;


public class Str {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a sentence");
    String sent = scan.nextLine();
    int count = 0, vowels = 0, conso = 0;
    while (count < sent.length()){
      if (Character.isLetter(Character.toUpperCase(sent.charAt(count))))
      switch(Character.toUpperCase(sent.charAt(count))){
        case 'A':
        case 'E':
        case 'I':
        case 'O':
        case 'U':
          vowels++;
          break;
        default:
          conso++;
          break;
      }
      count++;
    }
    System.out.println("Sentence is: " + sent);
    System.out.println("VowelCount : " + vowels);
    System.out.println("ConsoCount : " + conso);
  }
}