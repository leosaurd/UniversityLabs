package week09;

/**
 * A Insertion sort implementation which is able to be observed through its
 * Sorter superclass.
 *
 * @author Iain Hewson && Samuel Ng 2955262
 */
public class InsertionSort extends Sorter {

    /**
     * Create a new InsertionSort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public InsertionSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class).
     */
    public void sortNums() {
        
        comparisons = 0;
        int dex;
        for (i = 1; i < nums.length; ++i) {
            dex = nums[i];
            j = i - 1;
            while (j >= 0 && nums[j] > dex) {
                nums[j + 1] = nums[j];
                j = j - 1;
                update();
                comparisons++;
            }
            nums[j + 1] = dex;
        }
        
    }
}
