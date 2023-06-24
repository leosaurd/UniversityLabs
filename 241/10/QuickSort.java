package week10;

/**
 * A quick sort implementation which is able to be observed through its Sorter
 * superclass.
 *
 * @author Iain Hewson && Samuel Ng 
 */
public class QuickSort extends Sorter {

    /**
     * Create a new SillySort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public QuickSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class).
     */
    public void sortNums() {
        // int i, j, comparisons, and nums[] are all protected datafields in
        // the superclass Sort so we can use them without declaring them
        quickSort(0, nums.length - 1);
    }

    /**
     * Starting recursive method for quick sort algorithm.
     * 
     * @param left  is start of array(ie position 0).
     * @param right is end of array(ie length-1).
     */
    private void quickSort(int left, int right) {
        if (left < right) {
            int p = partition(left, right);
            quickSort(left, p);
            quickSort(p + 1, right);
        }
        comparisons++;
        update();

    }

    /**
     * supporting partition method for quickSort.
     * 
     * @param left  is the position 0 of the array.
     * @param right is the length-1 position of the array.
     * @return hole is an integer based on the hole left behind by the pivot.
     */
    private int partition(int left, int right) {
        int pivot = nums[left];
        int hole = left;
        i = left + 1;
        j = right;
        while (true) {
            comparisons++;
            update();
            while (j > hole && nums[j] >= pivot) {
                j--;
            }
            if (j == hole) {
                break;
            }
            nums[hole] = nums[j];
            hole = j;
            while (i < hole && nums[i] < pivot) {
                i++;
            }
            if (i == hole) {
                break;
            }
            nums[hole] = nums[i];
            hole = i;
        }
        nums[hole] = pivot;
        return hole;
    }
}
