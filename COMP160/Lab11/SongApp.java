
public class SongApp {
  
  public static void main(String[] args){
    
    Song text = new Song("While my guitar gently weeps");
    System.out.println(text.toString());
    text.process();
    Song otext = new Song("Let it be");
    System.out.println(otext.toString());
    otext.process();
    Song ptext = new Song("Penny Lane");
    System.out.println(ptext.toString());
    ptext.process();

  }
  
}