import edu.princeton.cs.algs4.Queue;
//test suits:
import org.junit.Test;
import static org.junit.Assert.*;

public class MergeSort {
    /**
     * Removes and returns the smallest item that is in q1 or q2.
     *
     * The method assumes that both q1 and q2 are in sorted order, with the smallest item first. At
     * most one of q1 or q2 can be empty (but both cannot be empty).
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      The smallest item that is in q1 or q2.
     */
    private static <Item extends Comparable> Item getMin(
            Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // Peek at the minimum item in each queue (which will be at the front, since the
            // queues are sorted) to determine which is smaller.
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // Make sure to call dequeue, so that the minimum item gets removed.
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    /** Returns a queue of queues that each contain one item from items. */
    private static <Item extends Comparable> Queue<Queue<Item>>
            makeSingleItemQueues(Queue<Item> items) {
        Queue<Queue<Item>> queofQ = new Queue<Queue<Item>>();
        for (Item q : items){
            Queue<Item> child = new Queue<Item>();
            child.enqueue(q);
            queofQ.enqueue(child);
        }
        return queofQ;
    }

    /**
     * Returns a new queue that contains the items in q1 and q2 in sorted order.
     *
     * This method should take time linear in the total number of items in q1 and q2.  After
     * running this method, q1 and q2 will be empty, and all of their items will be in the
     * returned queue.
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      A Queue containing all of the q1 and q2 in sorted order, from least to
     *              greatest.
     *
     */
    private static <Item extends Comparable> void fillup(Queue<Item> toconsider, Queue<Item> toreturn){
        while (!toconsider.isEmpty()){
            Item left = toconsider.dequeue();
            toreturn.enqueue(left);
        }
    }
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(
            Queue<Item> q1, Queue<Item> q2) { //merge
        Queue<Item> merged = new Queue<Item>();
        while (!(q1.isEmpty() || q2.isEmpty())) {
<<<<<<< HEAD
            Item smaller = q1.peek();
            Item bigger = q2.peek();
            int compare = smaller.compareTo(bigger);
            if (compare > 0) {
               q2.dequeue();
               merged.enqueue(bigger);
            } else {
                q1.dequeue();
                merged.enqueue(smaller);
            }
=======
            Item smaller = q1.dequeue();
            Item bigger = q2.dequeue();
            int compare = smaller.compareTo(bigger);
            if (compare > 0) {
                Item temp = smaller;
                smaller = bigger;
                bigger = smaller;
            }
            merged.enqueue(smaller);
            merged.enqueue(bigger);
>>>>>>> 606ebdb (pq local test passed)
        }

        fillup(q1, merged);
        fillup(q2, merged);

        return merged;
    }

    /** Returns a Queue that contains the given items sorted from least to greatest. */
    public static <Item extends Comparable> Queue<Item> mergeSort(
            Queue<Item> items) {
<<<<<<< HEAD
        if (items.size() == 0) {
            return null;
        }

=======
//        if (items.size() == 1) {
//            return items;
//        }
//
>>>>>>> 606ebdb (pq local test passed)
        Queue<Queue<Item>> tosort = makeSingleItemQueues(items);
        Queue starter = tosort.dequeue();
        while (!tosort.isEmpty()){
            Queue remaining = tosort.dequeue();
            starter = mergeSortedQueues(starter, remaining);
        }
        return starter;
    }

<<<<<<< HEAD

    @Test
    public void TestMergesort(){
=======
    public static void main(String[] args) {
>>>>>>> 606ebdb (pq local test passed)
        Queue<String> students = new Queue<String>();
        students.enqueue("Alice");
        students.enqueue("Vanessa");
        students.enqueue("Ethan");
<<<<<<< HEAD
        students.enqueue("Bob");
        students.enqueue("Samantha");
        System.out.println("original queue:  " + students);
        System.out.println("after sorting:  " + MergeSort.mergeSort(students));

    }

    @Test
    public void TestMergesortWithNumbers(){
        Queue<Integer> grades = new Queue<Integer>();
//        grades.enqueue(4);
//        grades.enqueue(4);
//        grades.enqueue(1);
//        grades.enqueue(9);
//        grades.enqueue(0);
//        grades.enqueue(5);
        System.out.println("original queue:  " + grades);
        System.out.println("after sorting:  " + MergeSort.mergeSort(grades));
=======
        System.out.println("original queue:  " + students);
        System.out.println("after sorting:  " + MergeSort.mergeSort(students));

>>>>>>> 606ebdb (pq local test passed)
    }
}
