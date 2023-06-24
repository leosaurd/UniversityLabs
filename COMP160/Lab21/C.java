public class C extends B{ private int x;
  private String a;
  public C (int x, String a, String s){
    super(s, x);
    this.x = x;
    this.a = a;
    s = "Green";
    System.out.println(" x is " + x); 
    System.out.println(" a is " + a); 
    System.out.println(" s is " + super.s); 
    System.out.println(" s is " + getS()); 
    System.out.println(" s is " + s); 
    System.out.println(" y is " + y);
    System.out.println(showRounded());
  }
}