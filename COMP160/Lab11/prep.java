public class prep {
  public static void main(String[] args) {
    String text = "Green Tea is yums";
    int first = text.indexOf('b');
    int second = text.indexOf('e', (text.indexOf('e') + 1));
    System.out.println(first + " " + second);
    int i = 0, count = 0;
    while (i < text.length()){
      if(text.charAt(i) == ' ')
      count += 1;
      i++;
    }
    System.out.println(count);
  }
}