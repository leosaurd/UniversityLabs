public class Customer {
  String name;
  boolean child, student, booked;
  
  public Customer(String nameIn, int age, boolean studentIn){
    name = nameIn;
    student = studentIn;
    if (age >= 5 && age <= 16)
      child = true;
    
  }
  
  public String getName(){
    return name;
  }
  
  public boolean isChild(){
    return child;
  }
  
  public boolean isStudent(){
    return student;
  }
  
  public boolean isBooked(){
    return booked;
  }
  
  public void setBooked(String a){
    if(a.equals("Y") || a.equals("y"))
      booked = true;
    else 
      booked = false;
  }
  
}