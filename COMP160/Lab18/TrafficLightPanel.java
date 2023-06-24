import java.awt.*;//Import necessary items
import java.awt.event.*;
import javax.swing.*;



public class TrafficLightPanel extends JPanel{
  private JButton redButton = new JButton("Red");//creating Buttons for interface
  private JButton greenButton = new JButton("Green");
  private JButton amberButton = new JButton("Amber");
  private JLabel lastPressedLabel = new JLabel("Last pressed");//creating Label for interface
  private JPanel buttonPanel = new JPanel();//creating Panel for buttons
  
  /*constructor for TrafficLightPanel, sets the parameters defining the panel*/
  public TrafficLightPanel(){
    ButtonListener l = new ButtonListener();//Implementing Listener
    LightPanel p = new LightPanel();//Implementing Seperate Panel
    redButton.addActionListener(l);//adding listener to buttons
    greenButton.addActionListener(l);
    amberButton.addActionListener(l);
    setSize(200, 300);//set size of trafficlightpanel
    setBackground(Color.blue);//set background of trafficlightpanel
    buttonPanel.setPreferredSize(new Dimension(80,290));//set preferred size of button panel
    buttonPanel.setBackground(Color.white);//set background of button panel
    buttonPanel.add(redButton);//add buttons to button panel
    buttonPanel.add(greenButton);
    buttonPanel.add(amberButton);
    buttonPanel.add(lastPressedLabel);//add label for buttonpanel
    add(buttonPanel);//add buttonpanel to trafficlightpanel
    add(p);//add lightpanel to trafficlightpanel
  }
  
  /*Listener that reacts to a button press*/
  private class ButtonListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
      if(e.getSource() == redButton){
        lastPressedLabel.setText("Red");//set lastpressedlabel's text
        buttonPanel.setBackground(Color.red);//changes buttonpanel's background color
      }
      else if(e.getSource() == amberButton){
        lastPressedLabel.setText("Amber");
        buttonPanel.setBackground(Color.orange);
      }
      else if(e.getSource() == greenButton){
        lastPressedLabel.setText("Green");
        buttonPanel.setBackground(Color.green);
      }
      repaint();//repaints paintComponent
    }
  }
  /*creates a new JPanel called LightPanel that implements graphics to draw ovals*/
  private class LightPanel extends JPanel{
    public LightPanel(){
      setPreferredSize(new Dimension(80, 290));
      setBackground(Color.cyan);
    }
    
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.fillOval(20,10,40,40);//create 3 circles
      g.fillOval(20,70,40,40);
      g.fillOval(20,130,40,40);
      if(lastPressedLabel.getText().equals("Red")){
        g.setColor(Color.red);//set circle colors if lastpressedlabel's text is a certain one
      g.fillOval(20,10,40,40);
      }
      else if(lastPressedLabel.getText().equals("Amber")){
        g.setColor(Color.orange);
      g.fillOval(20,70,40,40);
      }
      else if(lastPressedLabel.getText().equals("Green")){
        g.setColor(Color.green);
      g.fillOval(20,130,40,40);
      }
    }
  }
    
    
}