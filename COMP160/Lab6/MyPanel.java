import javax.swing.*;
import java.awt.*;
/**  
 * MyPanel.java
 * Lab 6, COMP160 2019
 * Make our own version of a JPanel class
 */
public class MyPanel extends JPanel {
    private int SIZE = 300;
    /** constructor for MyPanel. Don't worry for now how this method works. */
    public MyPanel(){
        setPreferredSize(new Dimension(SIZE,SIZE));  // set size of JPanel
        JFrame frame = new JFrame();                 // create JFrame object
        frame.getContentPane().add(this);            // add JPanel object to JFrame object
        frame.pack();                                // wrap ("pack") JFrame object around JPanel object
        frame.setVisible(true);                      // set visible
    }
    /** Method sets background colour and x axis location of frame.
      * Don't worry how it workks for now, just now how to call it */
    public void decorate (Color shade, int xPos){
      setBackground(shade);                          // set background colour
      getRootPane().getParent().setLocation(xPos, 0);  // set x-position, y-position is 0 
    }

  /**  Make our own paintComponent method */
  public void paintComponent(Graphics g) {
    super.paintComponent(g); // draws the basic JPanel
    int MID = 100;
    g.fillRoundRect(MID-50, 50, 100, 130, 30, 30); // train body in default colour (Color.black)
    g.drawLine(MID-55, 220, MID-20, 170); // left track
    g.drawLine(MID+55, 220, MID+20, 170); // right track
    g.drawLine(MID-55, 210, MID+55, 210); //  track sleeper
    g.drawLine(MID-50, 200, MID+50, 200); //  track sleeper
    g.drawLine(MID-45, 190, MID+45, 190); //  track sleeper

    g.setColor(Color.white); // change colour
    g.fillRoundRect(MID-15, 55, 40, 10, 8, 8); // destination screen
    g.fillRoundRect(MID-40, 70, 80, 45, 15, 15); // front screen
    
    g.setColor(Color.yellow);
    g.fillOval(MID-35, 140, 20, 20); // left light
    g.fillOval(MID+15, 140, 20, 20);  // right light
    
    g.setColor(Color.red);
    g.drawString("HOME", MID-15, 65);  // destination text
    
  }//end paintComponent

}//end class
