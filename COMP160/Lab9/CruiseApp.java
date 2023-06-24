/** application class for Customer.java
 * Lab 9 COMP160
 */
import java.util.Scanner;

public class CruiseApp{
   
    public static void main(String[]args){
        //each Customer created with name, age, showed student ID card
        Customer customer1 = new Customer("Aaron Stott",17, true);
        Customer customer2 = new Customer("Betty Adams",17, false);
        Customer customer3 = new Customer("Corin Child",16, true);
        Customer customer4 = new Customer("Doris Stewart",25, true);
        Customer customer5 = new Customer("Edmond Cheyne",12, false);
        Customer customer6 = new Customer("Fiona Chaney",7, false);
        Customer customer7 = new Customer("Ged Still-Child",16, true);
        Customer customer8 = new Customer("Harry Adamson",20, false);
        confirmBooking(customer1);
        confirmBooking(customer2); //and so on
        confirmBooking(customer3);
        confirmBooking(customer4);
        confirmBooking(customer5);
        confirmBooking(customer6);
        confirmBooking(customer7);
        confirmBooking(customer8); 
        
        showBooked(customer1);
        showBooked(customer2);
        showBooked(customer3);
        showBooked(customer4);
        showBooked(customer5);
        showBooked(customer6);
        showBooked(customer7);
        showBooked(customer8);
    }
   
    public static void confirmBooking(Customer a){
      float stp = 56, smp = 30;
      String ans;
      if(a.isChild() || a.isStudent())
        stp *= 0.5;
      else
        stp *= 0.8;
      
      if(a.isChild())
        smp *= 0.5;
      else 
        smp *= 0.9;
      
      Scanner scan = new Scanner(System.in);
      
      System.out.println(a.getName() + "\nTicket Price: $" + stp + "\nMeal price: $" + smp + "\nTotal Price: $" + (stp + smp)); 
      System.out.println("Confirm booking for " + a.getName() + "(Y/N)");
      ans = scan.nextLine();
      a.setBooked(ans);
      if(a.isBooked())
        System.out.println("Booked");
    }
    
    public static void showBooked(Customer a){
      System.out.print(a.getName() + " is ");
      if(!a.isBooked())
        System.out.print("not ");
      System.out.print("booked\n");
    }k
   
}