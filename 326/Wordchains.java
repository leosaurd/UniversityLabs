import java.util.*;


public class Wordchains {
    //First, generate HashMap to store values and "next" values.
    //Second, generate "next" values from HashMap(acting as dictionary)? Or generate as requested?
    //Ensure the above uses a measuring form; ie, character to determine weight?
    //Use those to determine which word should be next(Simulate BFS)
    //Ensure start and end words match lengths, and there are viable pathways(IE, Him->Ham->Hat->Fat)
    //Build the string if any pathway checks out; generation of optimal paths should be via String Array
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] placeholder = {"a", "b", "c"};
        HashMap<String, String[]> hm = new HashMap<String, String[]>();
        while(sc.hasNext()){
            hm.put(sc.next().toLowerCase(), placeholder);
        }
        for(Map.Entry<String, String[]> entry : hm.entrySet()){
            System.out.print(entry.getKey()+": ");
            for(int i = 0; i < entry.getValue().length; i++){
                System.out.print(entry.getValue()[i] + " ");
            }//check if you can pull out char value diffs on words in hashmap?
            //Sort the word alphabetically, seeing if diff.length==1 matches? 
            System.out.println();
        }
    }
}
