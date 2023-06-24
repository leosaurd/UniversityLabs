package shapes;

import java.util.*;
import java.awt.*;
/** Shape class to determine a random circle in a random position within certain values */
public abstract class Shape{
  
  protected int moveX = 1, moveY = 1, i=1, hue=1;
  protected int x, y, width, height;
  protected Color colour;
  /**Constructor to determine circle*/
  public Shape(){
    width = randomRange(10, 30);
    height = width;
    x = randomRange(0, 400 - width) ;
    y = randomRange(0, 400 - height);
    colour = new Color(randomRange(0, 255), randomRange(0, 255), randomRange(0, 255));
    if(y > 200)
      moveY*=-1;
  }
  /**Random Generator*/
  public int randomRange(int lo, int hi){
    Random rd = new Random();
    hi += 1;
    return(rd.nextInt(hi - lo) + lo);
  }
  /**Moves and pulsates the circles*/
  public void move(){
    if(x<=0 || x >= (400-width))
         moveX *= -1;
    x += moveX;
    if(y<=0 || y >= (400-height))
         moveY *= -1;
    y += moveY;
    
//    if (height == 30 || height == 1)
//      i *=-1;
//    width += i;
//    height += i;
    if (colour.getRed() == 255 || colour.getGreen() == 255 || colour.getBlue() == 255 || colour.getRed() == 0 || colour.getGreen() == 0 || colour.getBlue() == 0)
      hue *= -1;
    colour = new Color(colour.getRed() +hue, colour.getGreen() +hue, colour.getBlue()+hue);
      
  }
  /**Show Index next to the shape*/
  public void showIndex(Graphics g, int i){
    g.setColor(Color.black);
    g.drawString(String.valueOf(i), x, y);
  }
  
  /**Forcing extended classes to have a display method*/
  public abstract void display(Graphics g);
}