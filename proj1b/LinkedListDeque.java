public class LinkedListDeque<T> implements Deque<T> {
    private class IntNode {
        T item;
        IntNode next;
        IntNode prev;

        IntNode(T i, IntNode n, IntNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private IntNode sentinel;
    private int size;

    public LinkedListDeque() {
        //sentinel has only one pointer which points to the array.
        size = 0;
        sentinel = new IntNode(null, null, null);
    }

    @Override
    public void addFirst(T item) {
        IntNode fir = new IntNode(item, sentinel, sentinel);
        if (size == 0) {
            sentinel.next = fir;
            sentinel.prev = fir;
        } else { //original node -> sentinel remains
            sentinel.next.prev = fir; //fir <- original node(sentinel.next) (fixing1)
            fir.next = sentinel.next; //fir -> original node
            sentinel.next = fir; //sentinel -> fir
        }
        size += 1;
    }

    @Override
    public void addLast(T item) {
        IntNode las = new IntNode(item, sentinel, sentinel);
        if (size == 0) {
            sentinel.next = las;
            sentinel.prev = las;
        } else {
            las.prev = sentinel.prev; //original last node <- las
            sentinel.prev.next = las; //las -> sentinel
            sentinel.prev = las;
        }
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        if (size < 0) {
            size = 0;
        }
        return size;
    }

    @Override
    public void printDeque() {
        int i = 0;
        IntNode duplicate = sentinel;
        while (i < size) {
            duplicate = duplicate.next;
            T val = duplicate.item;
            System.out.print(val);
            System.out.print(" ");
            i += 1;
        }
        System.out.println();
//        System.out.println(this.size());
    }

    @Override
    public T removeFirst() {
        if (sentinel.next == null) {
            return null;
        } else {
            T store = sentinel.next.item;
            if (size == 1) {
                sentinel.next = null;
                sentinel.prev = null;
            } else {
                sentinel.next = sentinel.next.next;
                sentinel.next.prev = sentinel;
            }
            size -= 1;
            return store;
        }
    }

    @Override
    public T removeLast() {
        if (sentinel.prev == null) {
            return null;
        } else {
            T store = sentinel.prev.item;
            if (size == 1) {
                sentinel.next = null;
                sentinel.prev = null;
            } else {
                sentinel.prev = sentinel.prev.prev;
                sentinel.prev.next = sentinel;
            }
            size -= 1;
            return store;
        }
    }

    @Override
    public T get(int index) {
        int i = 0; //initialization
        IntNode track;
        track = sentinel.next;
        while (i < index) {
            track = track.next;
            i += 1;
        }
        return track.item;
    }

    private IntNode helpRecursive(int index) {
        IntNode track = sentinel.next; //track the first node
        if (index == 0) {
            return track;
        }
        track = track.next;
        return this.helpRecursive(index - 1).next;
    }

    public T getRecursive(int index) {
        IntNode tracked = helpRecursive(index);
        return tracked.item;
    }

}
