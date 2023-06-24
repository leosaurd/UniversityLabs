public class A{ protected int i, y;
  public A (int i){ this(i, 10);
  }
  public A (int i, int j){ this.i = i;
    y = i / j * j; 
  }
  public String showRounded(){ 
    return ("i is above " + y);
} 
}