import java.text.DecimalFormat;

public class TriangleApp{
  public static void main(String[] args){
    Triangle test = new Triangle();
    System.out.println(test.getPerimeter());
    DecimalFormat format = new DecimalFormat("#.##");
    System.out.println(format.format(test.getPerimeter()));
    Triangle a = new Triangle(0,3,3,4,1,9,"A");
    System.out.println(format.format(a.getPerimeter()));
  }
}