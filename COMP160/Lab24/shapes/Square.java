package shapes;

import java.awt.*;
/**Square class to display a Square*/
public class Square extends Shape{
  /**Constructs and display the square*/
  public void display(Graphics g){
    g.setColor(colour);
    g.fillRect(x, y, width, height);
  }
}