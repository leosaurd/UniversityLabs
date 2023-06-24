import javax.swing.*;
/**
 PieApp.java
 Application class provided for Part 2, Lab5, COMP160 2019 
 */
public class PieApp extends JFrame{
  
  /** creates an instance of Pie called chart1 and places it on a JFrame object */
  public static void main(String[]args){
    JFrame frame = new JFrame("Pie Chart"); 
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    Pie chart1 = new Pie();
    frame.getContentPane().add (chart1);
    frame.pack();
    frame.setVisible(true);
  }
}