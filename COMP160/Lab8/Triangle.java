public class Triangle{
  private int p1x, p1y, p2x, p2y, p3x, p3y;//change to double~
  private String name;
  
  public Triangle(){
    p1x = 0;
    p1y = 0;
    p2x = 3;
    p2y = 0;
    p3x = 3;
    p3y = 4;
  }
  
  public Triangle(int pt1x, int pt1y, int pt2x, int pt2y, int pt3x, int pt3y, String nameIn){
    p1x = pt1x;
    p1y = pt1y;
    p2x = pt2x;
    p2y = pt2y;
    p3x = pt3x;
    p3y = pt3y;
    name = nameIn;
  }
  
  private double CalcSide(int x1, int y1, int x2, int y2){
    return(Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2)));
  }
  
  public double getPerimeter(){
    return(this.CalcSide(p1x, p1y, p2x, p2y) + this.CalcSide(p1x, p1y, p3x, p3y) + this.CalcSide(p2x, p2y, p3x, p3y));
  }
  
  public String getName(){
    return(name);
  }
  
  public double CalcHyp(double a, double b){
    return(Math.sqrt((a*a) + (b*b)));
  }
}
    