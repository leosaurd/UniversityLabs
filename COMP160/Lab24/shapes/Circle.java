package shapes;

import java.awt.*;
/**Class to generate a Circle*/
public class Circle extends Shape{
  /**Draws a circle*/
  public void display(Graphics g){
    g.setColor(colour);
    g.fillOval(x, y, width, height);
  }
}