/**  
 * Book.java
 * 
 * Lab 6, COMP160  2019
 * 
 * Stores and displays information about an individual Book.
 */
import java.text.NumberFormat;  //for formatting price to 2 decimal places. See L,D&C p.117 Listing 3.4

public class Book{ 
  
//data field declarations 
  private String title;       // book title 
  private int numPages;       // number of pages in book   
  private double price;       // retail price of book   
  
  public Book(String TitleIn, int numPagesin, double Pricein){
    title = TitleIn;
    numPages = numPagesin;
    price = Pricein;
  }
  
  /**sets the value of the data field title to input parameter value*/
  public void setTitle(String t){      
    title = t;      
  } //end method  
  
  public String toString(){
    return("The Book:" + title + " \nhas " + numPages + " pages \nand costs:" + price);
  }
  
  /**sets the value of the data field numPages to input parameter value*/
  public void setPages(int n){      
    numPages = n;      
  } //end method    
  
  /**sets the value of the data field price to input parameter value*/
  public void setPrice(double p){      
    price = p;   
  } //end method  
  
  /**returns the value of the data field title */
  public String getTitle(){      
    return title;      
  } //end method
  
  /**returns the value of the data field numPages */
  public int getNumPages(){      
    return numPages;      
  } //end method
  
  /**returns the value of the data field price */
  public double getPrice(){      
    return price;      
  } //end method
  
  /**displays formatted Book information to the console window */  
  public void displayBook(){     
    NumberFormat fmt = NumberFormat.getCurrencyInstance(); // for formatting price
    System.out.println("The name of the book is " + title); 
    System.out.println("It has " + numPages + " pages."); 
    System.out.println("You can buy this book for " + fmt.format(price));
    System.out.println("**********************************"); 
  } //end method  
  
} //end class

