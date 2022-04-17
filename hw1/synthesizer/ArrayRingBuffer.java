// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;

import java.util.Iterator;


//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;
//    private int capacity;
//    private int fillCount;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }

    public int enring(int index) {
        //first/last reach the end; enqueue and dequeue are independent
        if (index >= capacity) {
            index %= capacity;
        }
        return index;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        rb[last] = x;
        last += 1;
        fillCount += 1;
        last = enring(last);
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        T temp = rb[first];
        rb[first] = null;
        first += 1;
        fillCount += 1;
        first = enring(first);
        return temp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        return rb[first];
    }


    // TODO: When you get to part 5, implement the needed code to support iteration.
    private class itra implements Iterator<T> {
        private int pos;
        public itra() {
            pos = 0;
        }
        public boolean hasNext() {
            return pos < capacity;
        }
        public T next() {
            T returnItem = peek(); // wrong!
            pos += 1;
            return returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new itra();
    }

//    public static void main(String[] args) {
//        ArrayRingBuffer<Integer> arr = new ArrayRingBuffer<Integer>(5);
//        arr.enqueue(4);
//        arr.enqueue(5);
//        arr.dequeue();
//        arr.enqueue(8);
//        arr.enqueue(0);
//        arr.dequeue();
//        arr.enqueue(2);
//        arr.enqueue(9);
//        arr.enqueue(7);
//
//        int i = 0;
//        while(i < 5) {
//            System.out.println(arr.peek());
//            System.out.println(arr.dequeue());
//            i += 1;
//        }
//    }
}
