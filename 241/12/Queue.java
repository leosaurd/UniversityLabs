package week12;

/**
 * A first-in-first-out collection of items.
 *
 * @author Iain Hewson
 */
public interface Queue<E> {

    /**
     * Return true if and only if this Queue is empty.
     *
     * @return true if this Queue is empty, otherwise false.
     */
    public boolean isEmpty();

    /**
     * Return the length of this Queue.
     *
     * @return the number of items in this Queue.
     */
    public int size();

    /**
     * Return the item at the front of this Queue.
     *
     * @return the item at the front of this Queue.
     * @throws EmptyQueueException if this Queue is empty.
     */
    public E get();

    /**
     * Make this Queue empty.
     */
    public void clear();

    /**
     * Add an item to the rear of this Queue.
     *
     * @param item the item to be added to the rear of the Queue.
     */
    public void add(E item);

    /**
     * Remove and return the front item of this Queue.
     *
     * @return the item at the front of this Queue.
     * @throws EmptyQueueException if this Queue is empty.
     */
    public E remove();

    /**
     * Return a string representation of this queue ordered from front to back.
     *
     * @return a string representation of this Queue.
     */
    public String toString();
}
