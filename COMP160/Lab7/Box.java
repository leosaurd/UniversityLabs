/**
 * Box.java
 * 
 * Lab 7, Comp 160 2019
 * 
 * Stores and displays values about individual Boxes.
 */

public class Box{
  //data field declarations
  private int height, width, length; //Height, Width & Length
  private static String owner; //Owner of Box
  
  /**Constructor to set default values*/
  public Box(){
    height = 0;
    width = 0;
    length = 0;
  }//end constructor
  
  /**Constructor to define a cube*/
  public Box(int same){
    height = same;
    width = same;
    length = same;
  }//end constructor
  
  /**Constructor to define a custom box*/
  public Box(int h, int w, int l){
    height = h;
    width = w;
    length = l;
  }//end constructor
  
  /**Mutator Method to set the height of the box.*/
  public void setHeight(int h){
    height = h;
  }//end method
  
  /**Mutator Method to set the width of the box.*/
  public void setWidth(int w){
    width = w;
  }//end method
  
  /**Mutator Method to set the length of the box.*/
  public void setLength(int l){
    length = l;
  }//end method
 
  /**Method to get the Surface Area of the box.*/
  public int getSurfaceArea(){
    return((height*length)*2 + (height*width)*2 + (length*width)*2);
  }//end method
  
  /**Method to get the Volume of the box.*/
  public int getVolume(){
    return(length*width*height);
  }//end method
  
  /**Method to display the overall status of the box*/
  public String toString(){
    return("Height: " + height + "\nLength: " + length + "\nWidth: " + width + "\nSurface Area: " + this.getSurfaceArea() 
             + "\nVolume: " + this.getVolume() + "\nOwned by: " + this.getOwner());
  }//end method
  
  /**Method to set the owner of all boxes(due to static modifier)*/
  public static void setOwner(String nameIn){
    owner = nameIn;
  }//end method
  
  /**Method to get the Owner of the box*/
  public static String getOwner(){
    return(owner);
  }//end method
}