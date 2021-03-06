import edu.princeton.cs.algs4.Queue;
//test suits
import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSort {
    /**
     * Returns a new queue that contains the given queues catenated together.
     * <p>
     * The items in q2 will be catenated after all of the items in q1.
     */
    private static <Item extends Comparable> Queue<Item> catenate(Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> catenated = new Queue<Item>();
        if (q1 == null) {
            return q2;
        }
        if (q2 == null) {
            return q1;
        }
        for (Item item : q1) {
            catenated.enqueue(item);
        }
        for (Item item : q2) {
            catenated.enqueue(item);
        }
        return catenated;
    }

    /**
     * Returns a random item from the given queue.
     */
    private static <Item extends Comparable> Item getRandomItem(Queue<Item> items) {
        int pivotIndex = (int) (Math.random() * items.size());
        Item pivot = null;
        // Walk through the queue to find the item at the given index.
        for (Item item : items) {
            if (pivotIndex == 0) {
                pivot = item;
                break;
            }
            pivotIndex--;
        }
        return pivot;
    }

    /**
     * Partitions the given unsorted queue by pivoting on the given item.
     *
     * @param unsorted A Queue of unsorted items
     * @param pivot    The item to pivot on
     * @param less     An empty Queue. When the function completes, this queue will contain
     *                 all of the items in unsorted that are less than the given pivot.
     * @param equal    An empty Queue. When the function completes, this queue will contain
     *                 all of the items in unsorted that are equal to the given pivot.
     * @param greater  An empty Queue. When the function completes, this queue will contain
     *                 all of the items in unsorted that are greater than the given pivot.
     */
    private static <Item extends Comparable> void partition(
            Queue<Item> unsorted, Item pivot,
            Queue<Item> less, Queue<Item> equal, Queue<Item> greater) {
<<<<<<< HEAD
        while (!unsorted.isEmpty()) {
            Item tocomp = unsorted.dequeue();
            int cmp = tocomp.compareTo(pivot);
            if (cmp < 0) {
=======
        while (!unsorted.isEmpty()){
            Item tocomp = unsorted.dequeue();
            int cmp = tocomp.compareTo(pivot);
            if (cmp < 0){
>>>>>>> 606ebdb (pq local test passed)
                less.enqueue(tocomp);
            } else if (cmp > 0) {
                greater.enqueue(tocomp);
            } else {
                equal.enqueue(tocomp);
            }
        }
    }

    /**
     * Returns a Queue that contains the given items sorted from least to greatest.
     */
    public static <Item extends Comparable> Queue<Item> quickSort(
            Queue<Item> items) {
<<<<<<< HEAD
        if (items.size() <= 1) {
=======
        if (items.size() == 1) {
>>>>>>> 606ebdb (pq local test passed)
            return items;
        }
        Item pivot = getRandomItem(items);
        Queue<Item> left = new Queue<Item>();
        Queue<Item> right = new Queue<Item>();
        Queue<Item> equal = new Queue<Item>();
        partition(items, pivot, left, equal, right);
//        items = quickSort(left) + quickSort(equal) + quickSort(right);
<<<<<<< HEAD

        items = quickSort(left);
        Queue<Item> remained = catenate(equal, quickSort(right));
=======
        items = quickSort(left);
        Queue<Item> remained = catenate(quickSort(equal), quickSort(right));
>>>>>>> 606ebdb (pq local test passed)
        items = catenate(items, remained);
        return items;
    }

<<<<<<< HEAD
    @Test
    public void TestQuickSort() {
        Queue<String> students = new Queue<String>();
//        students.enqueue("Alice");
//        students.enqueue("Vanessa");
//        students.enqueue("Ethan");
//        students.enqueue("Bob");
//        students.enqueue("Samantha");

        System.out.println("original queue:  " + students);
        System.out.println("after sorting:  " + quickSort(students));
    }

    @Test
    public void TestQuickSortWithNumbers(){
        Queue<Integer> grades = new Queue<Integer>();
        grades.enqueue(4);
        grades.enqueue(4);
        grades.enqueue(1);
        grades.enqueue(9);
        grades.enqueue(0);
        grades.enqueue(5);
        System.out.println("original queue:  " + grades);
        System.out.println("after sorting:  " + QuickSort.quickSort(grades));
=======
    public static void main(String[] args) {
        Queue<String> students = new Queue<String>();
        students.enqueue("Alice");
        students.enqueue("Vanessa");
        students.enqueue("Ethan");
        System.out.println("original queue:  " + students);
        System.out.println("after sorting:  " + quickSort(students));

>>>>>>> 606ebdb (pq local test passed)
    }
}
