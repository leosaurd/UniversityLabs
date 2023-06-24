public class Test{
  public static void main(String[] args){
    SecondClass s1 = new SecondClass();
    SecondClass s2 = new SecondClass();
    System.out.println(s1.toString());
    System.out.println(s2.toString());
    s1 = s2;
    System.out.println(s1.toString());
    System.out.println(s2.toString());
    s1.val();
    int i = 3;
    System.out.println(Integer.toString(i));
  }
}