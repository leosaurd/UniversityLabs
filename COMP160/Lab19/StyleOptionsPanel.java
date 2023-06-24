/**
 StyleOptionsPanel.java      
 adapted from Java Foundations
 Demonstrates the use of check boxes.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StyleOptionsPanel extends JPanel
{
   private JLabel saying;
   private JCheckBox bold, italic;
   private int style = Font.PLAIN;
   private String typeFace = "Helvetica";
   private JRadioButton c = new JRadioButton("Courier");
   private JRadioButton t = new JRadioButton("Times New Roman");
   private JRadioButton h = new JRadioButton("Helvetica");
   ButtonGroup bg = new ButtonGroup();
   //-----------------------------------------------------------------
   //  Sets up a panel with a label, some check boxes and a button group that
   //  control the style of the label's font.
   //-----------------------------------------------------------------
   public StyleOptionsPanel()
   {
      saying = new JLabel ("Say it with style!");
      saying.setFont (new Font (typeFace, style, 20));

      bold = new JCheckBox ("Bold");
      bold.setBackground (Color.cyan);
      italic = new JCheckBox ("Italic");
      italic.setBackground (Color.cyan);

      StyleListener listener = new StyleListener();
      bold.addItemListener (listener);
      italic.addItemListener (listener);
      c.addItemListener(listener);
      t.addItemListener(listener);
      h.addItemListener(listener);
      add (saying);
      add (bold);
      add (italic);
      bg.add(c);
      bg.add(t);
      bg.add(h);
      add (c);
      add (t);
      add (h);
      h.setSelected(true);
      setLayout(new GridLayout(6,1, 4, 4));
      setBackground (Color.cyan);
      setPreferredSize (new Dimension(300, 150));
   }

   //*****************************************************************
   //  Represents the listener for both check boxes.
   //*****************************************************************
   private class StyleListener implements ItemListener
   {
      //--------------------------------------------------------------
      //  Updates the style of the label font style.
      //--------------------------------------------------------------
      public void itemStateChanged (ItemEvent event)
      {
         style = Font.PLAIN;

         if (bold.isSelected())
            style = Font.BOLD;

         if (italic.isSelected())
            style += Font.ITALIC;
         
         if(event.getSource() == c)
           typeFace = "Courier";
         
         else if(event.getSource() == t)
           typeFace = "Times New Roman";
         
         else if(event.getSource() == h)
           typeFace = "Helvetica";

         saying.setFont (new Font (typeFace, style, 20));
      }
   }
}
