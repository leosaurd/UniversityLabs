import javax.swing.*;
/*Traffic App COMP160 LAB 18
 */
public class TrafficApp{
  public static void main(String[] args){
    TrafficLightPanel tlp = new TrafficLightPanel();//create new traffic light panel
    JFrame frame = new JFrame();//create new frame
    frame.add(tlp);//add traffic light panel to frame
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//make frame only close if we click on close
    frame.pack();//add items(ButtonPanels etc) into frame
    frame.setVisible(true);//make frame visible
  }
}