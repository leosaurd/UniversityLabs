public class BoxApp{
  public static void main(String[] args){
    Box box1 = new Box();
    box1.setLength(4);
    box1.setHeight(4);
    box1.setWidth(6);
    box1.setOwner("Anna Austin");
    System.out.println("Box 1:\n" + box1.toString());
    
    Box box2 = new Box(3, 4, 5);
    System.out.println("Box 2:\n" + box2.toString());
    
    Box box3 = new Box(5);
    Box box4 = new Box(7);
    
    
    box1.setOwner("Bob Berry");
    
    System.out.println("Box 3:\n" + box3.toString());
    System.out.println("Box 4:\n" + box4);
    
  }
}