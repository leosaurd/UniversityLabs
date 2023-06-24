public class Lab3{
private static int n; // this variable is declared outside of any method, so is a data field
public static void main(String[]args){ methodThree();
              methodOne();
              methodTwo();
              methodOne();
              methodOne();
              System.out.println("n is " + n);
              methodThree();
              System.out.println("n is " + n);
}
public static void methodOne(){ n = n * 2;
}
public static void methodTwo(){ n = n + n + n;
}
public static void methodThree(){
n = 2; }
}