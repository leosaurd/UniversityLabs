import javax.swing.*;
/**
 * Snowman.java       From: Lewis, DePasquale & Chase page 971 (page 835 2nd edition)
 * 
 * Demonstrates basic drawing methods and the use of color.
 * 
 */
public class SnowmanApp{
  /** creates  an instance of the Snowman class, puts it on a frame and sets some essential parameters.
    * You do not need to understand how this method works until later in the course*/
  public static void main(String[]args){
    JFrame frame = new JFrame("Snowman"); 
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    SnowmanPanel snowman1 = new SnowmanPanel();
    frame.getContentPane().add (snowman1);
    frame.pack();
    frame.setVisible(true);
  }
}