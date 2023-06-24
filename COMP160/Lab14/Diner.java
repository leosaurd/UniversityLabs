import java.awt.*;
//import to utilize graphics & color

public class Diner{
  private int x, y;
  private String name;
  private int seatNum;
  private Color colour;
  private final int DIAMETER = 50;
  
  public Diner(int x, int y, String name, int seatNum){//Constructor, sets color depending on even/odd, sets the values for the class
    if(seatNum%2 == 0)
      colour = Color.white;
    else
      colour = Color.gray;
    this.x = x;
    this.y = y;
    this.name = name;
    this.seatNum = seatNum;
  }
  
  public void draw(Graphics g){//sets color for each diner(even or odd), colors in, sets font, draws string
    g.setColor(this.colour);
    g.fillOval(x, y, DIAMETER, DIAMETER);
    g.setFont(new Font("Courier", Font.PLAIN, 8));
    g.setColor(Color.black);
    g.drawString(Integer.toString(seatNum), x+24, y+10);
    g.drawString(name, x+2, y+25);
    
  }
}