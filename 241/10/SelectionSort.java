package week10;

/**
 * A selection sort implementation which is able to be observed through its
 * Sorter superclass.
 *
 * @author Iain Hewson && Samuel Ng 2955262
 */
public class SelectionSort extends Sorter {

    /**
     * Create a new SelectionSort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public SelectionSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class).
     */
    public void sortNums() {
        // int i, j, comparisons, and nums[] are all protected datafields in
        // the superclass Sort so we can use them without declaring them
        comparisons = 0;
        int temp;
        int mindex = 0;//minimum index
        int n = nums.length;// n for array length, following algorithm.
        for (i = 0; i < n - 1; i++) {
            mindex = i;// constantly right shifting min index
            for (j = i + 1; j < n; j++) {
                if (nums[j] < nums[mindex]) {
                    mindex = j;
                }
                comparisons++;
                update();
            }
            temp = nums[mindex];
            nums[mindex] = nums[i];
            nums[i] = temp;
        }
    }
}
