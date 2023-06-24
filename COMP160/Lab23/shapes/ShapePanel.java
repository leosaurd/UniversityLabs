package shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


/**ShapePanel class that creates a two panels, a interactive one and a viewable one */
public class ShapePanel extends JPanel{
  
  private JButton[] panbut = new JButton[] {new JButton("Circle"),new JButton("Square"),new JButton("Oval"),new JButton("Smiley"),new JButton("Swirl"),new JButton("Start"),new JButton("Stop")};
  private JPanel controlPanel = new JPanel();
  private JButton addShape = new JButton("Add Shape");
  private JButton srt = new JButton("Start");
  private JButton stp = new JButton("Stop");
  private JTextField showNum = new JTextField(2);
  private JLabel countLabel = new JLabel("Count");
  private DrawingPanel drawPanel = new DrawingPanel();
  private Shape[] shapes = new Shape[20];
  private int count = 0;
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
    
    showNum.setText(Integer.toString(count));
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
      for(int i = 0; i < count; i++){
        shapes[i].display(g);
      }
      
    }
  }
  /** Listener to let the usesr interact with the JButtons, and thus utilize the interactive panel*/
  public class ButtonListener implements ActionListener{
    /**When action is performed, if it matches certain event*/
    public void actionPerformed(ActionEvent e){     
      if(e.getSource() == timer){
        for (int i = 0; i < count; i++){
          shapes[i].move();
        }
      }
      else{
        JButton button = (JButton) e.getSource();  
        if(count < shapes.length){
          if (button.getText().equals("Circle")){
            shapes[count] = new Circle();
            count++;
          }
          else if (button.getText().equals("Square")){
            shapes[count] = new Square();
            count++;
          }
          else if (button.getText().equals("Oval")){
            shapes[count] = new Oval();
            count++;
          }
          else if (button.getText().equals("Smiley")){
            shapes[count] = new Smiley();
            count++;
          }
          else if (button.getText().equals("Swirl")){
            shapes[count] = new Swirl();
            count++;
          }
        }
        if (button.getText().equals("Start")){
          timer.start();
        }
        else if (button.getText().equals("Stop")){
          timer.stop();
        }
        showNum.setText(Integer.toString(count));
        
      }
      
      
      repaint();
    }
  }
}