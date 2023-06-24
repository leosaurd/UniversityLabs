/** FilePanel.java
  * Lab 20, COMP160,  2019
  *
  * a JPanel which creates 2 instances of Rectangle objects,
  * stores them in an array, and draws them
  */
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class FilePanel extends JPanel{
  private Rectangle[] drawObjects = new Rectangle [10];
  private int count = 0;
  
  
  /**constructor instantiates 6 Rectangle objects*/
  public FilePanel(){ 
//    drawObjects[count] = new Rectangle(true,Color.red, 0, 0,30,30);
//    count++;
//    drawObjects[count] = new Rectangle(false,Color.blue, 50, 50,30,30);
//    count++;
    String fileName = "LongBadData.txt";//File Name
    boolean tf;
    Color col;
    //Try to do the thing, printing an error in case it is unable to find the file
    try{
      Scanner fileScan = new Scanner(new File(fileName));
      //While the file has a next line, and its count is less than 10(can use drawObjects.length as well)
      while (fileScan.hasNextLine() && count < drawObjects.length){
        String inputLine = fileScan.nextLine();
        if (inputLine.matches("\\d+ \\d+ \\d+ \\d+ \\d+ \\d+")){
          Scanner sc = new Scanner(inputLine);
          int fill = sc.nextInt();
          int c = sc.nextInt();
          int x = sc.nextInt();
          int y = sc.nextInt();
          int a = sc.nextInt();
          int b = sc.nextInt();
          if (fill == 0)
            tf = false;
          else
            tf = true;
          
          if (c == 1)
            col = Color.red;
          else if (c == 2)
            col = Color.blue;
          else if (c == 3)
            col = Color.green;
          else 
            col = Color.black;
          
          drawObjects[count] = new Rectangle(tf, col, x, y, a, b);
          count++;
        }
      }
      
    }//Error catch to print out the error IF it cannot find the file.
    catch (FileNotFoundException e){ 
      System.out.println("File not found. Check file name and location."); 
      System.exit(1);//exit from program if no file to read
    }
    setPreferredSize(new Dimension(300,300));
    setBackground(Color.yellow);
  }
  
  /**each Rectangle will draw itself*/
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    for(int i = 0; i < count; i++){
      drawObjects[i].draw(g);
    }
  }
}