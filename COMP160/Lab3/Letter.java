import java.util.Scanner;


/**
 * Lab 3, COMP160, 2019
 * no output as the main does not call upon the method that is printing lines.
 */

public class Letter{
    private static String yours = "Yours sincerely";
    private static String sign = "Mr Albert Agnew Esq.\nHuman Resources Manager\nButtery Baps Unlimited\nwww.bb.co.nz";
    public static void main(String [] args){
        int junior = 25000;     // standard pay rate for Junior employee
        int intermediate = 35000;  // standard pay rate for Intermediate employee
        int senior = 50000;    // standard pay rate for Senior employee]
        String name; //defined string variable
        Scanner scan = new Scanner(System.in); //defined input reading(scanner)
        System.out.println("Enter the applicant's name:");//ask for input
        name = scan.nextLine();//uses the scanner to get input, and allocate it to name
        jobOffer();
        jobOffer("Chief Cook");
        jobOffer("CEO");
        jobOffer("Henry Hall", "Bean Counter", senior);
        jobOffer(name, "Bean Counter", junior);
       
    } // end method
   
    /** displays a job offer for Bottle Washer at $25K */
    public static void jobOffer(){
      System.out.println("Dear applicant\nI wish to offer you the position of Bottle Washer.\nThe pay rate will be $25000 per annum.");
      signature();
    } // end method
    /**Displays a job offer with variable title*/
    public static void jobOffer (String jobTitle) {
      System.out.println("Dear applicant\nI wish to offer you the position of " + jobTitle + ".\nThe pay rate will be $25000 per annum.");       
      signature();
    } // end method
    /**Displays a job offer with variable title & pay rate*/
    public static void jobOffer (String jobTitle, int payRate) {
      System.out.println("Dear applicant,\nI wish to offer you the position of " + jobTitle + ".\nThe pay rate will be $" + payRate + " per annum.");
      signature();
    } // end method
    /**Displays a job offer with variable name, title & pay rate*/
    public static void jobOffer (String applicant, String jobTitle, int payRate) {
      System.out.println("Dear " + applicant + ",\nI wish to offer you the position of " + jobTitle + ".\nThe pay rate will be $" + payRate + " per annum.");
      signature();
    } // end method
    
    private static void signature() {
      System.out.println(yours + "\n" + sign + "\n");
    }// end method
   
} // end class
