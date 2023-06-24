import java.util.*;

/**
 * Etude 3 - A program to read from input and generate numbers based on a single
 * input.
 * Can be modified to take more than one input, IE: where c = 3, and b = 5.
 * 
 * @author Samuel Ng Shan Feng, 2955262
 *
 */
public class Etude3 {
    /**
     * The main method, which contains various values to be saved.
     * 
     * @param args
     */
    public static void main(String[] args) {
        HashMap<Character, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String[] s;
        String order = "";
        while (sc.hasNextLine()) {
            s = sc.nextLine().split(" ");
            if (!s[0].isEmpty()) {
                map.put(s[0].charAt(0), s[1]);
                order += s[0].charAt(0) + " ";
            } else {
                // regenerate ALL the values to ensure it updates based on real
                // time information.
                for (int i = 0; i < map.size(); i++) {
                    map = updateValues(map, order);
                }
                printMap(map, order);
                map.clear();
                order = "";
                System.out.println();
            }
        }
        for (int i = 0; i < map.size(); i++) {
            map = updateValues(map, order);
        }
        printMap(map, order);
        sc.close();
    }

    /**
     * A method to read through all keys and values, and update accordingly.
     * 
     * @param mp         the hash map to be updated.
     * @param printorder the order in which values should be printed.
     */
    private static HashMap<Character, String> updateValues(
        HashMap<Character, String> mp, String printorder) {
        // For each entry in the hash table

        for (Map.Entry<Character, String> entry : mp.entrySet()) {
            // Here to enhance readability.
            Character key = entry.getKey();
            String value = entry.getValue();
            int max = value.length();
            // for each character in the string associated to the key
            for (int i = 0; i < max; i++) {
                // Check if the hash map has the key
                if (mp.containsKey(value.charAt(i))) {
                    if (mp.get(value.charAt(i)).contains(key.toString())
                        || mp.get(value.charAt(i)).equals("NaN")) {
                        mp.put(key, "NaN");
                        break;
                    }
                    if (!mp.get(value.charAt(i)).matches("\\d+")) {
                        mp.put(key,
                            value.replace(String.valueOf(value.charAt(i)),
                                mp.get(value.charAt(i))));
                    }
                } else {
                    // If it doesn't, check if it is an integer, if not set the
                    // key to NaN and move to next.
                    if (String.valueOf(value.charAt(i)).matches("\\d+")) {
                        break;
                    }
                    mp.put(key, "NaN");
                }
                // don't forget to update the values!
                key = entry.getKey();
                value = entry.getValue();
            }
        }
        return mp;
    }

    private static void printMap(HashMap<Character, String> mp,
        String printorder) {
        // For each entry, update the value based on the new string.
        for (Map.Entry<Character, String> entry : mp.entrySet()) {
            int sum = 0;
            if (!entry.getValue().matches("\\d+")
                && !entry.getValue().equals("NaN")) {
                for (int i = 0; i < entry.getValue().length(); i++) {
                    sum += Integer.parseInt(mp.get(entry.getValue().charAt(i)));
                }
                mp.put(entry.getKey(), Integer.toString(sum));
            }
        }

        // Scanner to print it out in the desired order, rather than hash map's
        // randomized style.
        Character key;

        Scanner sc = new Scanner(printorder);
        while (sc.hasNext()) {
            key = sc.next().charAt(0);
            System.out.println(key + " " + mp.get(key));
        }
        sc.close();
    }
}
