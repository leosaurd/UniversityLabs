package week11;

import java.util.*;

/**
 * A class that generates a deck of cards, based on stdin OR command line input,
 * and lets the user manipulate the arrangement based on columns and rows. Error
 * prompts allow for continuation.
 * 
 * @author Kane Colvin, Tane Carney & Samuel Ng
 *
 */
public class CP implements CardPile {
    /**
     * The original deck of cards. Unchangeable unless being replaced
     * with a new deck of cards. Represented using integer array.
     */
    private int[] original;
    /**
     * The deck of cards to be arranged and manipulated. Represented using
     * integer array.
     */
    private int[] deck;
    /**
     * The only specifications allowed. Represented using String array.
     */
    private static final String[] VALUES = {
        "TL",
        "BL",
        "TR",
        "BR",
        "LT",
        "LB",
        "RT",
        "RB" };
    /**
     * A list used by the accessiblePiles method to store String representations
     * of possible unique orderings of a pile.
     */
    private ArrayList<String> piles;
    /**
     * A constant for the accessiblePiles method.
     */
    private static final int MAXSIZE = 1000;
    /**
     * A constant for the randInt method.
     */
    private static final int RANDMAX = 8;

    /**
     * Main method, to begin the program and view location of input.
     * 
     * @param args are the arguments from the command line.
     */
    public static void main(String[] args) {

        CP cards = new CP();

        if (args.length > 1) {
            if (Integer.parseInt(args[0]) < 0
                || Integer.parseInt(args[1]) < 0) {
                throw new CardPileException("Values not positive.");
            }
        }
        switch (args.length) {
            case 0:
                Scanner scan = new Scanner(System.in);
                while (scan.hasNextLine()) {
                    cards.performAction(scan.nextLine());
                }
                break;
            case 1:
                throw new CardPileException("Cannot have one input.");
            case 2:
                cards.load(Integer.parseInt(args[0]));
                cards.printAll(Integer.parseInt(args[1]));
                break;
            default:
                cards.load(Integer.parseInt(args[0]));
                for (int i = 2;; i++) {
                    cards.printDeck(cards.getPile(), 0);
                    if (i == args.length) {
                        break;
                    }
                    cards.transform(Integer.parseInt(args[1]), args[i]);
                }
        }
    }

    /**
     * Method to print out how many transforms all the commands would take to
     * return to it's original form.
     * 
     * @param rows The length of a row to determine the order.
     */
    public void printAll(int rows) {
        for (String value : VALUES) {
            System.out.println(value + " " + count(rows, value));
        }
    }

    /**
     * A method that prints out each card on a line divided by a space and if
     * given a row parameter will print out each row on a new line.
     *
     * @param cards A string representing the name of the deck we will print.
     * @param row   The length of each row of cards.
     *
     */
    protected void printDeck(int[] cards, int row) {
        if (row != 0 && cards.length % row != 0) {
            System.out.println("Row length must be a factor of pile size.");
            return;
        }
        if (row == 0) {
            for (int value : cards) {
                System.out.print(value + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < cards.length; i++) {
                if (i > 0 && i % row == 0) {
                    System.out.println();
                }
                System.out.print(cards[i] + " ");
            }
            System.out.println();
        }
    }

    /**
     * A method that uses switch to determine which action will be performed,
     * based on letters and integers.
     *
     * @param actions A string containing the actions to be performed.
     */
    protected void performAction(String actions) {
        if (actions == null || actions.length() == 0) {
            System.out.println("No values entered.");
            return;
        }
        if (!(actions.charAt(0) == 'l' || actions.charAt(0) == 'L')
            && original == null) {
            System.out.println("Array not initialized. Follow I/O guidelines.");
            return;
        }
        Scanner scan = new Scanner(actions);
        try {
            switch (scan.next().charAt(0)) {
                case 'c':
                    System.out.println(count(scan.nextInt(), scan.next()));
                    break;
                case 'l':
                    load(scan.nextInt());
                    // Initialized here incase user wishes to count accessible
                    // piles
                    piles = new ArrayList<String>();
                    break;
                case 'P':
                    printDeck(deck, scan.nextInt());
                    break;
                case 'p':
                    printDeck(deck, 0);
                    break;
                case 'L':
                    String[] numberString = actions.split(" ");
                    int[] temp = new int[numberString.length - 1];
                    for (int i = 1; i < numberString.length; i++) {
                        temp[i - 1] = Integer.parseInt(numberString[i]);
                    }
                    load(temp);
                    break;
                case 't':
                    transform(scan.nextInt(), scan.next());
                    break;
                case 'Z':
                    int rowLength = scan.nextInt();
                    System.out.println(accessiblePiles(rowLength));
                    break;
                default:
                    System.out.println("Invalid Action Character.");
            }
        } catch (NoSuchElementException e) {
            scan.close();
            System.out.println("Invalid entry, refer to I/O guidelines.");
        }
        scan.close();
    }

    /**
     * Initializes the given array as an array of Integer.
     * 
     * @param cards The Integer array to be initialized in our class.
     */
    public void load(int[] cards) {
        this.original = cards;
        deck = original.clone();
    }

    /**
     * Initializes the array based on the size given, as an array of Integer.
     * 
     * @param n The size of the deck of cards to be initialized.
     */
    public void load(int n) {
        if (n < 0) {
            throw new CardPileException("Pile size cannot be negative.");
        }
        original = new int[n];
        for (int i = 0; i < n; i++) {
            original[i] = i + 1;
        }
        deck = original.clone();
    }

    /**
     * A method to return a copy of the deck of cards in its current state.
     * 
     * @return deck An array of Integer that represents the deck in it's current
     *         state.
     */
    public int[] getPile() {
        return deck.clone();
    }

    /**
     * A method to transform the 'deck' of cards based on specifications.
     * 
     * @param rowLength The length of a given row in the arrangement.
     * @param spec      The specification of which location and order the cards
     *                  should be transformed by.
     */
    public void transform(int rowLength, String spec) {
        if (!Arrays.asList(VALUES).contains(spec)) {
            throw new CardPileException("Invalid specification.");
        }
        if (rowLength <= 0 || original.length % rowLength != 0) {
            throw new CardPileException("Invalid Row Length.");
        }
        int shiftRow = 1;// iterate right
        int shiftCol = rowLength;// iterate down
        int start = startPos(rowLength, spec);
        if (spec.contains("R")) {
            shiftRow *= -1;// iterate left
        }
        if (spec.contains("B")) {
            shiftCol *= -1;// iterate up
        }
        if ((spec.charAt(0) == 'T' || spec.charAt(0) == 'B') && rowLength > 1) {
            iter(start, shiftRow, shiftCol);// column iteration
            return;
        }
        iter(start, shiftCol, shiftRow);// row iteration
    }

    /**
     * Iterator method to traverse the arrangement of cards with given
     * specifications, utilizing shifter variables to iterate in the four given
     * directions.
     * 
     * @param start      The starting position of the iteration.
     * @param shiftStart The shift value to change starting position for
     *                   iteration.
     * @param iterDir    The shift value that iterates.
     */
    private void iter(int start, int shiftStart, int iterDir) {
        int[] tempdeck = getPile();
        int shift = start;// value to be shifted
        for (int i = 0; i < tempdeck.length; i++) {
            deck[i] = tempdeck[shift];
            shift += iterDir;
            if (shift >= tempdeck.length || shift < 0
                || (shift + shiftStart) == start) {
                start += shiftStart;
                shift = start;
            }
        }
    }

    /**
     * A supplementary method to find the starting position specified by
     * transform.
     * 
     * @param rowLength The length of the row, used in calculations to get an
     *                  accurate starting position.
     * @param spec      The factor of where the starting point should be,
     *                  represented by a string.
     * @return start An integer that is set to the starting position specified
     *         by spec.
     */
    private int startPos(int rowLength, String spec) {
        if (spec.equals("BR") || spec.equals("RB")) {
            return (original.length - 1);
        }
        if (spec.equals("TR") || spec.equals("RT")) {
            return (rowLength - 1);
        }
        if (spec.equals("BL") || spec.equals("LB")) {
            return (original.length - rowLength);
        }
        return 0;
    }

    /**
     * A method that returns the number of transformations before the deck
     * returns to its original arrangement.
     * 
     * @param rowLength The length a row should have.
     * @param spec      The specification of where and in which order
     *                  transformations should happen.
     * @return i The amount of iterations the loop has performed.
     */
    public int count(int rowLength, String spec) {
        int i = 1;
        transform(rowLength, spec);
        while (!Arrays.equals(original, deck)) {
            transform(rowLength, spec);
            i++;
        }
        return i;
    }

    /**
     * Supplementary method that calculates how many unique permutations
     * of the deck we can access. Not reccomended for numbers larger than
     * 12, can be called multiple times with the same different factors of pile
     * size
     * in order to get a more accurate count for larger numbers. When this
     * method
     * returns the same number repeateadly then no more accessible piles are
     * possible.
     * 
     * @param rowLength The length of the rows to be evaluated.
     * 
     * @return An integer representing the accessible pile orderings
     *         NOTE: not accurate for piles over 9, must be called
     *         multiple times.
     */
    private int accessiblePiles(int rowLength) {
        // using random to select a random specification for transform
        Random rand = new Random();
        // stores unique orderings in an Array List
        // Max increments of i chosen for accurate accessible piles
        for (int i = 0; i < deck.length * MAXSIZE; i++) {
            int index = rand.nextInt(RANDMAX);
            transform(rowLength, VALUES[index]);
            if (!piles.contains(Arrays.toString(deck))) {
                piles.add(Arrays.toString(deck));
            }
        }
        return piles.size();
    }
}
