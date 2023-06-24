public class B extends A{ 
  public String s;
  public B(String s, int x){ super(x * 2);
    this.s = s;
  }
  public String getS(){
    return s; }
}