package week07;

import java.util.Scanner;
import java.util.function.Function;

/**
 * An implementation of Young's tableau using linked cells.
 *
 * @author Iain Hewson modified by Samuel Ng
 */
public class Tableau {

    /** The smallest value (or root) of this Tableau. */
    private Cell smallest = null;

    /**
     * Adds the given value to this tableau.
     *
     * @param value the value to be added to this tableau.
     */
    public void addValue(Integer value) {
        if (smallest == null) {
            smallest = new Cell(value);
            return;
        }

        Cell c = smallest;// need value to go to below cells constantly

        while (true) {// continue infinitely, because we have two specific
                      // conditions we're looking for.
            value = addToRow(c, value);// check for a pushed value or null

            if (value == null) {// break out if the pushed value is null
                break;
            }

            if (c.below == null) {// since not null, need to check if below is
                                  // null.
                c.below = new Cell(value);// create a new cell with the value if
                // yes.
                c.below.above = c;// link the newly created cell to the above.
                break;// break out.
            }

            c = c.below;// if none of the above are met, go one cell below.
        }

    }

    /**
     * Adds the given value to the row beginning with <code>curr</code>, keeping
     * the row in ascending order. If the value gets added to the end of the row
     * <code>null</code> is returned, otherwise the bumped value is returned.
     *
     * @param curr  the first cell in the current row.
     * @param value the value to be added to the row.
     * @return the bumped value, or null if the value was added to the end of
     *         the row.
     */
    protected Integer addToRow(Cell curr, int value) {
        int ph;
        while (curr != null) {
            if (curr.value > value) {
                ph = curr.value;
                curr.value = value;
                return ph;
            }
            if (curr.right == null) {
                break;
            }
            curr = curr.right;
        }

        curr.right = new Cell(value);
        curr.right.left = curr;
        if (curr.above != null) {
            curr.right.above = curr.above.right;
            if (curr.right.above != null) {
                curr.right.above.below = curr.right;
            }
        }
        if (curr.below != null) {
            curr.right.below = curr.below.right;
            if (curr.right.below != null) {
                curr.right.below.above = curr.right;
            }

        }

        return null;

        /**
         * for (Cell c = curr; c != null; c = c.right) {//while loop viable. if
         * (c.value > value) { ph = c.value; c.value = value; return ph; } if
         * (c.right == null) {// this hurt my brain to type out. c.right = new
         * Cell(value); // creating new cell on right. c.right.left =
         * c;//linking back to left cell. if (c.above != null) { // checking if
         * previous cell above is // not null c.right.above = c.above.right; //
         * since not null, link the //pointer. if (c.right.above != null) {
         * c.right.above.below = c.right; // link if not null. } } if (c.below
         * != null) {// same as above, but for below. c.right.below =
         * c.below.right; if (c.right.below != null) { c.right.below.above =
         * c.right; } } return null; } } return null;
         */
    }

    /**
     * Iterate through every cell in the tableau printing them using the given
     * function.
     *
     * @param f a function which when applied to a cell should return an
     *          integer.
     */
    protected void print(Function<Cell, Integer> f) {
        for (Cell i = smallest; i != null; i = i.below) {
            for (Cell j = i; j != null; j = j.right) {
                System.out.printf("[%2d]", f.apply(j));
            }
            System.out.println();
        }
    }

    /**
     * Entry point of the program. Reads numbers from stdin and adds them to a
     * Tableau. If <code>p</code> is input then the tableau is printed. If
     * <code>c</code> is input then a count of the neighbours of each cell is
     * printed.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        Tableau t = new Tableau();
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            if (input.hasNextInt()) {
                t.addValue(input.nextInt());
            } else {
                String command = input.next();
                if ("p".equals(command)) {
                    t.print(cell -> cell.value);
                } else if ("c".equals(command)) {
                    t.print(cell -> cell.neighbours());
                }
            }
        }
    }

    /**
     * A cell which holds a value and links to neighbouring cells.
     */
    protected static class Cell {
        /** The value held by this cell. */
        int value;
        /** The cell above this cell. */
        Cell above;
        /** The cell below this cell. */
        Cell below;
        /** The cell to the left of this cell. */
        Cell left;
        /** The cell to the right of this cell. */
        Cell right;

        /**
         * Creates a new cell with the given value.
         * 
         * @param value the value contained in this cell.
         */
        Cell(int value) {
            this.value = value;
        }

        /**
         * Returns how many horizontal and vertical (but not diagonal)
         * neighbours this cell has.
         * 
         * @return how many neighbours this cell has.
         */
        int neighbours() {
            int count = left != null ? 1 : 0;
            count += right != null ? 1 : 0;
            count += above != null ? 1 : 0;
            count += below != null ? 1 : 0;
            return count;
        }
    }

}
