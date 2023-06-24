public class Test{
  
  
  public static void main(String[] args){
    int[] a = {1, 2, 3};
    int[] b = {4, 5, 6};
    int[][] c = {a, b};
    show(0, 2, c);
    
    for(int d = 0; d<c.length; d++)
      show(d, 0, c);
  }
  
  public static void show (int row, int col, int[][] arr){
    System.out.print(arr[row][col]);
  }
}