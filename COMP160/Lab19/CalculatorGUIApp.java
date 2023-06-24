import javax.swing.JFrame;

/** application class for GUI Calculator front-end */

public class CalculatorGUIApp{
  
  /**main method - sets up JFrame*/
  public static void main(String [] args){
    
    
  JFrame frame = new JFrame("Calculator");
    frame.setContentPane(new CalculatorGUIPanel());
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}