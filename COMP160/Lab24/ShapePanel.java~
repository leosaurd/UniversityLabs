import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


/**ShapePanel class that creates a two panels, a interactive one and a viewable one */
public class ShapePanel extends JPanel{
  
  
  private JPanel controlPanel = new JPanel();
  private JButton addShape = new JButton("Add Shape");
  private JTextField showNum = new JTextField(2);
  private JLabel countLabel = new JLabel("Count");
  private DrawingPanel drawPanel = new DrawingPanel();
  private Shape[] shapes = new Shape[20];
  private int count = 0;
  
  /** Constructor that defines the shape/layout of the ShapePanel*/
  public ShapePanel(){
    ButtonListener bl = new ButtonListener();
    addShape.addActionListener(bl);
    showNum.setText(Integer.toString(count));
    controlPanel.setPreferredSize(new Dimension(100, 400));
    controlPanel.add(addShape);
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
   /** Listener to let the usesr interact with the JButton, and thus utilize the interactive panel*/
   public class ButtonListener implements ActionListener{
     /**When action is performed, if it matches certain event*/
     public void actionPerformed(ActionEvent e){
       if(e.getSource() == addShape){
         if (count < shapes.length){
         shapes[count] = new Shape();
         count++;
         }
         showNum.setText(Integer.toString(count));
         repaint();
       }
     }
   }
}