package week10;

import java.util.Arrays;

/**
 * A merge sort implementation which is able to be observed through its
 * Sorter superclass.
 *
 * @author Iain Hewson && Samuel Ng 2955262
 */
public class MergeSort extends Sorter {
    /**
     * Global variable to create the temporary array needed for merge sort.
     */
    private Integer[] temp;

    /**
     * Create a new SelectionSort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public MergeSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class).
     */
    public void sortNums() {
        // int i, j, comparisons, and nums[] are all protected datafields in
        // the superclass Sort so we can use them without declaring them
        mergeSort(0, nums.length - 1);
    }

    /**
     * the recursive method to begin Merge Sort.
     * 
     * @param left  is the starting point of array.
     * @param right is the end point of array.
     */
    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid + 1, right);
            comparisons++;
            update();
        }
    }

    /**
     * The supplementary method for merge sorting, to merge the arrays back.
     * 
     * @param left is the leftmost value of the array(ie, position 0).
     * @param mid is the middle of the array.
     * @param right is the end of the array.
     */
    private void merge(int left, int mid, int right) {
        temp = Arrays.copyOf(nums, nums.length);
        i = left;
        j = left;
        int k = mid;
        while (i < mid && k <= right) {
            if (temp[i] < temp[k]) {
                nums[j] = temp[i];
                i++;
            } else {
                nums[j] = temp[k];
                k++;
            }
            j++;
        }
        while (i < mid) {
            nums[j++] = temp[i++];
        }
        while (j <= right) {
            nums[j++] = temp[k++];
        }
    }

}
