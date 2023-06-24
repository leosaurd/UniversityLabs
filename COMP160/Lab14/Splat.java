import javax.swing.*;
//import to utilize JPanel/JFrame
public class Splat{
  
  public static void main(String[] args){
    TablePanel test = new TablePanel();
    JFrame frame = new JFrame();
    frame.add(test);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
  
}