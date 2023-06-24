package week10;

/**
 * A heap sort implementation which is able to be observed through its Sorter
 * superclass.
 *
 * @author Iain Hewson && Samuel Ng
 */
public class HeapSort extends Sorter {

    /**
     * Create a new HeapSort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public HeapSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class).
     */
    public void sortNums() {
        
        int temp;
        i = nums.length/2 - 1;
        j = nums.length - 1;
        
        while(i>=0) {//heapifying process
            siftDown(i, nums.length-1);
            i--;
        }
        
        
        while (j>0) {
            temp = nums[0];
            nums[0] = nums[j];
            nums[j] = temp;

            siftDown(0, j - 1);
            j--;
        }
    }
/**
 * the siftDown method that recursively sifts downwards to sort the array.
 * @param root is the root index
 * @param bot is the bottom limit(since we're sifting down)
 */
    private void siftDown(int root, int bot) {
        comparisons++;
        update();
        int child = root * 2 + 1;
        int child2 = root * 2 + 2;
        int biggest;
        if (child < bot) {
            if (nums[child2] > nums[child]) {
                biggest = child2;
            } else {
                biggest = child;
            }
        } else {
            return;
        }
        
        if(nums[root]>= nums[biggest]) {
            return;
        }
        
        int temp = nums[root];
        nums[root] = nums[biggest];
        nums[biggest] = temp;
        
        siftDown(biggest, bot);
    }
}
