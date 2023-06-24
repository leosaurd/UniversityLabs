public class IntCounter{
  private int[] numArray;
  
  public IntCounter(int[] numArray){
    this.numArray = numArray;
    for(int val : numArray)
      System.out.print(val + " ");
  }
  
  public void showTarget(int target){
    for(int i = 0; i<numArray.length; i++)
      if (numArray[i] == target)
      System.out.println("The target was found at index" + i);
  }
}