package week03;

/**
 * A recursive representation of a tower of blocks. Modified by Student NGSA7956
 * Samuel Ng.
 * 
 * @author Michael Albert
 */
public class Tower {

    /** The top block. */
    private char top;

    /** The rest of the tower. */
    private Tower rest;

    /**
     * Creates a new empty Tower.
     */
    public Tower() {
        this.top = ' ';
        this.rest = null;
    }

    /**
     * Creates a new tower by adding the given block to the top of this tower.
     * 
     * @param block a block to add to the top of this tower.
     * @return a new tower created by adding a block to the top of this tower.
     */
    public Tower add(char block) {
        return new Tower(block, this);
    }

    /**
     * External classes can only create empty towers and manipulate them using
     * public methods, because this constructor is private.
     * 
     * @param top  the top block in this tower
     * @param rest the rest of the tower
     */
    private Tower(char top, Tower rest) {
        this.top = top;
        this.rest = rest;
    }

    /**
     * Returns true if this tower is empty, otherwise false. Empty towers are
     * represented with the top block being a space character.
     * 
     * @return whether the tower is empty or not.
     */
    public boolean isEmpty() {
        return top == ' ';
    }

    /**
     * Recursively counts the height of the tower.
     * 
     * @return returns the total height of the tower.
     */
    public int height() {
        if (!this.isEmpty()) {
            return 1 + rest.height();
        }
        return 0;
    }

    /**
     * Recursively counts the number of a particular character in the tower.
     * 
     * @param c is the character to be counted.
     * @return returns the total count.
     */
    public int count(char c) {
        if (!this.isEmpty()) {
            if (this.top == c) {
                return 1 + rest.count(c);
            } else {
                return 0 + rest.count(c);
            }
        }
        return 0;

    }

    /**
     * Testing toString method for the tower, to see if it is empty or not.
     * @return returns the character if it is not empty, and blank if it is.
     */
    public String toString() {
        if (this.isEmpty()) {
            return "";
        }
        return this.top + " ";
    }
}
