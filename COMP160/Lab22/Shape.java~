import java.util.*;
import java.awt.*;
/** Shape class to determine a random circle in a random position within certain values */
public class Shape{
  
  private int x, y, width, height;
  private Color colour;
  /**Constructor to determine circle*/
  public Shape(){
    width = randomRange(10, 30);
    height = width;
    x = randomRange(0, 400) - width;
    y = randomRange(0, 400) - height;
    colour = new Color(randomRange(0, 255), randomRange(0, 255), randomRange(0, 255));
  }
  /**Random Generator*/
  public int randomRange(int lo, int hi){
    Random rd = new Random();
    hi += 1;
    return(rd.nextInt(hi - lo) + lo);
  }
  /**Drawing a circle*/
  public void display(Graphics g){
    g.setColor(colour);
    g.fillOval(x, y, width, height);
  }
}