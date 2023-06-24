public class LeapYearApp {
  public static void main(String[] args) {
    leapYear(2019);
    leapYear(2020);
    leapYear(1900);
    leapYear(2000);
    leapYear(1565);
  }
  
  public static void leapYear(int year){
    if(year<1582)
      System.out.println(year + ": predates the Gregorian calendar");
    else if((year%4 == 0)){
      if (year%100 == 0 && year%400 != 0)
        System.out.println(year + ": is not a leap year");
      else
        System.out.println(year + ": is a leap year");
    }
    else
      System.out.println(year + ": is not a leap year");
  }
}