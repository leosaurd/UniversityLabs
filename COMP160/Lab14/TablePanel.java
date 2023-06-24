import javax.swing.*;
import java.awt.*;
//import to utilize JPanel/JFrame
//import to utilize graphics & color
public class TablePanel extends JPanel{
  
  private Diner diner1, diner2, diner3, diner4, diner5, diner6;
  
  public TablePanel(){//Constructor for TablePanel, sets values for diners, sets background color, sets size of JPanel(window)
    diner1 = new Diner(200, 10, "person1", 1);
    diner2 = new Diner(250, 60, "person2", 2);
    diner3 = new Diner(250, 110, "person3", 3);
    diner4 = new Diner(200, 160, "person4", 4);
    diner5 = new Diner(150, 60, "person5", 5);
    diner6 = new Diner(150, 110, "person6", 6);
    setBackground(Color.yellow);
    setPreferredSize(new Dimension(600, 400));
    
  }
  
  public void paintComponent(Graphics g){//Draws the components for diners and rectangle
    super.paintComponent(g);
    diner1.draw(g);
    diner2.draw(g);
    diner3.draw(g);
    diner4.draw(g);
    diner5.draw(g);
    diner6.draw(g);
    g.setColor(Color.magenta);
    g.fillRect(200, 60, 50, 100);
  }
}