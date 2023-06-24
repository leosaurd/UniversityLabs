public class Average{
      public static void main(String[]args){
          int [] [] table = {{1,2,3},{4,5,6},{7,8}};//given code for a 2dimensional array(3 rows, 3 columns)
          double sum = 0;//to total the sum
          int count = 0;//to keep track of which row's length(due to row 3 having different length)
        for(int[] a : table){
          for (int b : a){
            sum += (double)b;//cast b to double to add to sum(because average tends to have decimal values)
            System.out.print(b + " ");
          }
          System.out.println("\tAverage : " + sum/(table[count].length));//Print the average
          sum = 0;//reset sum for next row
          count += 1;//increase count for next row
        }
          
      }
}