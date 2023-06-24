/** 
 * Calculator.java
 * 
 * Lab 19, COMP160,  2019
 * 
 * A calculator class - for SIMPLE calculations like 5 + 20 =
 * Large inputs will overload int, should convert to long 
 */


public class Calculator {  
  
  private long currentInput;          //current input
//  private int previousInput;         // previous input
  private long result;            // result of calculation
  private String lastOperator = "";  // keeps track of the last operator entered
  
  
  /** New digit entered as integer value i - moves currentInput 1 decimal place to the left and adds i in "one's column" 
  @param i a digit */
  public void inDigit(int i) {
    currentInput = (currentInput * 10) + i;
  }
  
  
  /** Operator entered  + - or *   
  @param op an operator symbol, one of + - * */
  public void inOperator(String op) {
    if (lastOperator == "-")//if the previous value is negative(ie, -6 + 9) it will alter the value accordingly
      currentInput *= -1;
    result += currentInput;      // save the new input as previous to get ready for next input
    currentInput = 0;
    lastOperator = op;                 // remember which operator was entered
  } 
  
  
   /** Equals operation sets result to + - or * currentInput (depending on lastOperator) or just sets result if there was no operator, while resetting current input */
  public void inEquals() {
    if (lastOperator.equals("+")) {
      result += currentInput;
    } else if (lastOperator.equals("-")) { 
      result -= currentInput;
    } else if (lastOperator.equals("*"))  {
      result *= currentInput;
    } 
    else if(currentInput != 0)
      result = currentInput;
    currentInput = 0;
    lastOperator = "";       // reset last operator to "nothing"
  }
  
  
  /** Clear operation */
  public void inClear() {
    currentInput = 0;
    //previousInput = 0;
    result = 0;
    lastOperator = "";
  } 
  
  /** returns the current result 
  @return the current result as a string*/
  public String getResult() {  
    return Long.toString(result);  //converts int to String
  }
  
  /** returns the previous input value
  @return the previous input as a string */
//  public String getPreviousInput() {
//    return Integer.toString(previousInput);
//  }
  /** returns the current input value 
  @return the current input as a string */
  public String getCurrentInput() {
    return Long.toString(currentInput);
  }
  
}  

