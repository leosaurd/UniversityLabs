public class Song{
  
  private String songLine;
  
  public Song(String sLine) {
    songLine = sLine;
  }
  
  public String toString() {
    return songLine;
  }
  
  public void process() {
    int len = songLine.length();
    //String firstw = songLine.substring(0, songLine.indexOf(' '));
    //String secondw = songLine.substring(songLine.indexOf(' ')+1, songLine.indexOf(' ', songLine.indexOf(' ')+1));
    if(songLine.indexOf(' ', (songLine.indexOf(' ')+1)) > 0){
      
    String twoWords = songLine.substring(0, songLine.indexOf(' ', (songLine.indexOf(' ')+1) ) ) ;
    String remsent = songLine.substring(songLine.indexOf(' ', (songLine.indexOf(' ')+1) )+1, len );
    String firstlet = remsent.substring(0, 1);
    
    System.out.println(twoWords);
    System.out.println(remsent);
    System.out.println(firstlet);
    }
    System.out.println("Length is " + len);
    System.out.println(songLine.charAt(len-1));
    System.out.println(songLine.toUpperCase());
    System.out.println(songLine.replace(' ', 'x'));
    System.out.println(songLine.indexOf('b'));
    System.out.println(songLine);
  }
}