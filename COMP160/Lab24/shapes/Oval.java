package shapes;

import java.awt.*;
/**Class to generate an Oval*/
public class Oval extends Shape{
  /**Constructor to modify values to an oval*/
  public Oval(){
    height = (width * 4);
    y = randomRange(0, 400 - height);
  }
  /**Create the Oval*/
  public void display(Graphics g){
    g.setColor(colour);
    g.fillOval(x, y, width, height);
  }
}