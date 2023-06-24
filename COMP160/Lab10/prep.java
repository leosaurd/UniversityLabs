public class prep {
  public static void main(String[] args){
    int a = 20;
    int b = 8;
    int c = 2;
    System.out.println(true?7:8);//7
    System.out.println(false?7:8);//8
    System.out.println((a<b)?a+c:a-c);
    if (a > 0)
      System.out.print(a);
    else if (a > 10)
      System.out.print(a+1);
  }
}