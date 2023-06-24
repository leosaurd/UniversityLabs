


public class MyPanelApp {
  public static void main (String[] args){
    MyPanel mp1 = new MyPanel();
    MyPanel mp2 = new MyPanel();
    mp1.decorate(java.awt.Color.blue, 180);
    mp2.decorate(java.awt.Color.red, 500);
  }
}