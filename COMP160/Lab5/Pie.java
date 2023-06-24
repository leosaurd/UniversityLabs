import javax.swing.*;
import java.awt.*;
/**
 Pie.java
 Support class provided for Part 2, Lab5, COMP160 2019 
 */
public class Pie extends JPanel{
    /** constructor method, sets up the Pie panel */
  public Pie(){
    setPreferredSize(new Dimension(300,300));
    setBackground(Color.white);
  }
 
    
    /** all drawing code goes in the paint method, which is called automatically*/
    public void paintComponent (Graphics page){
      
      super.paintComponent(page);
      //your pie chart code goes here - you MUST use local variables as described in the lab book
      final int x = 100, y = 100, w = 100, h = 100, ai = 45;
      
      page.setColor (Color.red);
      page.fillArc(x+4, y-2, w, h, ai*0, ai);
      
      page.setColor (Color.blue);
      page.fillArc(x, y, w, h, ai*1, ai);
      
      page.setColor (Color.black);
      page.fillArc(x, y, w, h, ai*2, ai);
      
      page.setColor (Color.yellow);
      page.fillArc(x, y, w, h, ai*3, ai); 
      
      page.setColor (Color.cyan);
      page.fillArc(x, y, w, h, ai*4, ai);
      
      page.setColor (Color.green);
      page.fillArc(x, y, w, h, ai*5, ai);
      
      page.setColor (Color.red);
      page.fillArc(x, y, w, h, ai*6, ai);
      
      page.setColor (Color.blue);
      page.fillArc(x, y, w, h, ai*7, ai);
    }
}
