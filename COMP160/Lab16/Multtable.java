public class Multtable{
  
  public static void main(String[] args){
    
    int[][] table = new int[12][12];//Array just BIG enough(12x12)
    
    
    for (int a = 1; a < 13; a++){//Fill the array with numbers
      for(int b = 1; b < 13; b++){
        table[a-1][b-1] = a*b;//-1 to account for 1 number offset(position 0,0 gets value 1)
      }
    }
    
    
    for(int[] c : table){//print out using nested for-each loop)
      for(int d : c){
        System.out.print(d + "\t");
      }
      System.out.println();
    }
  }
}