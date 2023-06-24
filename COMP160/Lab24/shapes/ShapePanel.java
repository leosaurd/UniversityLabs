package shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


/**ShapePanel class that creates a two panels, a interactive one and a viewable one */
public class ShapePanel extends JPanel{
  
  private JButton[] panbut = new JButton[] {new JButton("Circle"),new JButton("Square"),new JButton("Oval"),new JButton("Smiley"),new JButton("Swirl"),new JButton("Start"),new JButton("Stop"), new JButton("Remove")};
  private JPanel controlPanel = new JPanel();
  private JButton addShape = new JButton("Add Shape");
  private JButton srt = new JButton("Start");
  private JButton stp = new JButton("Stop");
  private JTextField showNum = new JTextField(2);
  private JLabel countLabel = new JLabel("Remove which?");
  private DrawingPanel drawPanel = new DrawingPanel();
  private ArrayList<Shape> shapes = new ArrayList<Shape>();
 // private int count = 0;
  javax.swing.Timer timer;
  private final int DELAY = 10;
  
  /** Constructor that defines the shape/layout of the ShapePanel*/
  public ShapePanel(){
    ButtonListener bl = new ButtonListener();
    timer = new javax.swing.Timer(DELAY, bl);
    
    for(JButton n : panbut){
      n.addActionListener(bl);
      controlPanel.add(n);
    }
    
    showNum.setText("");
    controlPanel.setPreferredSize(new Dimension(100, 400));
    controlPanel.add(countLabel);
    controlPanel.add(showNum);
    add(controlPanel);
    add(drawPanel);
  }
  
  /**Subclass to determine the viewable panel*/
  public class DrawingPanel extends JPanel{
    /** Constructor that determines the size & color of the viewable panel*/
    public DrawingPanel(){
      setPreferredSize(new Dimension(400, 400));
      setBackground(Color.pink);
    }
    /** Method to draw the components being put in the viewable panel */
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      for(int i = 0; i < shapes.size(); i++){
        shapes.get(i).display(g);
        shapes.get(i).showIndex(g, i+1);
      }
      
    }
  }
  /** Listener to let the usesr interact with the JButtons, and thus utilize the interactive panel*/
  public class ButtonListener implements ActionListener{
    /**When action is performed, if it matches certain event*/
    public void actionPerformed(ActionEvent e){     
      if(e.getSource() == timer){
        for (int i = 0; i < shapes.size(); i++){
          shapes.get(i).move();
        }
      }
      else{
        JButton button = (JButton) e.getSource();  
        if (button.getText().equals("Circle")){
          shapes.add(new Circle());
        }
        else if (button.getText().equals("Square")){
          shapes.add(new Square());
        }
        else if (button.getText().equals("Oval")){
          shapes.add(new Oval());
        }
        else if (button.getText().equals("Smiley")){
          shapes.add(new Smiley());
        }
        else if (button.getText().equals("Swirl")){
          shapes.add(new Swirl());
        }
        else if (button.getText().equals("Start")){
          timer.start();
        }
        else if (button.getText().equals("Stop")){
          timer.stop();
        }
        else if (button.getText().equals("Remove")){
          try{
          int num = Integer.parseInt(showNum.getText());
          shapes.remove(num);
          }
          catch (NumberFormatException a) {
            System.out.println("That's not a number!");
          }
          catch (IndexOutOfBoundsException a) {
            System.out.println("Thats not a valid Index");
          }
        }
        if(shapes.size() == 0)
          showNum.setText("");
        else
        showNum.setText(Integer.toString(shapes.size() - 1));
        
      }
      
      
      repaint();
    }
  }
}