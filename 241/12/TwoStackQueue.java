package week12;

import java.util.Stack;

/**
 * A two stack implementation with left and right stacks to simulate FIFO
 * behavior.
 * 
 * @author Samuel Ng 2955262
 *
 * @param <E> is the Queue parameter.
 */
public class TwoStackQueue<E> implements Queue<E> {
    /**
     * Left stack which is where elements are added to.
     */
    Stack<E> left = new Stack<E>();
    /**
     * Right stack which is where elements are pushed to.
     */
    Stack<E> right = new Stack<E>();

    /**
     * Boolean method to check if the queue(ie, both stacks) are empty.
     * 
     * @return returns true if queue is empty, otherwise false.
     */
    public boolean isEmpty() {
        if (left.isEmpty() && right.isEmpty()) {
            return true;
        }
        return false;

    }

    /**
     * Method to get an integer representing the size of the queue at the
     * moment.
     * 
     * @return returns both the combined value of both stacks.
     */
    public int size() {
        return left.size() + right.size();
    }

    /**
     * Method to get the first element input(ie, last element from the right
     * side).
     * 
     * @return returns the first element input.
     */
    public E get() {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        if (right.isEmpty()) {
            while (left.size() > 0) {
                right.push(left.pop());
            }
        }
        return right.lastElement();
    }

    /**
     * Method to clear the queue completely.
     */
    public void clear() {
        left.clear();
        right.clear();
    }

    /**
     * Method to add items to the queue.
     * 
     * @param item is the element to be added to the queue.
     */
    public void add(E item) {
        left.push(item);
    }

    /**
     * Method to remove and return the first variable loaded in.
     * 
     * @return returns the first variable loaded in.
     */
    public E remove() {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        if (right.isEmpty() && !left.isEmpty()) {
            while (left.size() > 0) {
                right.push(left.pop());
            }
        }

        return right.pop();

    }

    /**
     * Method to get the entire queue in the entered order.
     * 
     * @return returns the queue as a string.
     */
    public String toString() {
        StringBuilder a = new StringBuilder("[");

        for (int i = right.size() - 1; i >= 0; i--) {
            if (a.length() > 1) {
                a.append(", ");
            }
            a.append(right.elementAt(i));
        }

        for (E element : left) {
            if (a.length() > 1) {
                a.append(", ");
            }
            a.append(element);
        }

        return a.toString() + "]";
    }

    /**
     * Method to see both stacks, allowing the observation of both stacks at any
     * given time.
     */
    public void debug() {
        System.out.println(left.toString() + right.toString());
    }

}
