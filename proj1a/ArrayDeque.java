public class ArrayDeque<T> {
    //misunderstanding: just a python list supporting slicing...
    private T[] items;
    private int size;
    private int arraysize = 8;
    private int arrlimit = 16;
    private double usagefactor;
    private int nextfirst = 0; //act as two pointers
    private int nextlast = 1;

    public ArrayDeque() {
        items = (T[]) new Object[arraysize];
        size = 0;
    }

    private int indexl(int loc) {
        return loc - 1;
    }

    private void sizecheck() {
        int newsize = arraysize;
        usagefactor = (double) size / arraysize;
        if (usagefactor > 0.7) {
            newsize *= 2;
            resize(newsize);

        }

        if (usagefactor <= 0.25 && arraysize >= arrlimit) { //which leads to a question: does array limit matter?
            newsize /= 2;
            resize(newsize);
        }


    }

    private void resize(int newsize) {
        T[] newitems = (T[]) new Object[newsize];
        if (nextlast > nextfirst) { // no extra 1
            int start = bound(nextfirst + 1);
            System.arraycopy(items, start, newitems, 0, size);
        } else {
            int flag = size - nextlast;
            System.arraycopy(items, nextfirst + 1, newitems, 0, flag);
            System.arraycopy(items, 0, newitems, flag, nextlast);
        }
        items = newitems;
        arraysize = newsize;
        nextlast = size;
        nextfirst = arraysize - 1; //update()
    }

    private int bound(int num) { //index
        if (num < 0) {
            num += arraysize;
        } else if (num >= arraysize) {
            num -= arraysize;
        }
        return num;
    }

    public void addFirst(T item) {
        items[nextfirst] = item;
        size += 1;
        nextfirst -= 1; //point to next location
        nextfirst = bound(nextfirst); //check for if it is out of bounds
        sizecheck();
    }

    public void addLast(T item) {
        items[nextlast] = item;
        size += 1;
        nextlast += 1;
        nextlast = bound(nextlast);
        sizecheck();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        if (size < 0) {
            size = 0;
        }
        return size;
    }

    public void printDeque() {
        int i = 0;
        while (i < size()) {
            System.out.print(get(i));
            System.out.print(" ");
            i += 1;
        }
        System.out.println();
    }

    public T removeFirst() {
        int index = bound(nextfirst + 1); //points to the first box: next first <- first
        T temp = items[index];
        items[index] = null;
        nextfirst += 1;
        nextfirst = bound(nextfirst);
        size -= 1;
        sizecheck(); //forget about checking size, which leads to usagefactor unchanged and everything
        return temp;
    }

    public T removeLast() {
        int index = bound(nextlast - 1); //points to the last box: last -> next last
        T temp = items[index];
        items[index] = null;
        nextlast -= 1;
        nextlast = bound(nextlast);
        size -= 1;
        sizecheck();
        return temp;
    }

    public T get(int index) {
//        int validIndex = index + firstBox ; //first = index(0) = next first + 1
        int first = nextfirst + 1;
        int newindex = bound(first + index);
        return items[newindex];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> numbers = new ArrayDeque<Integer>();
        numbers.addFirst(4);
        numbers.printDeque();
        numbers.addLast(3);
        numbers.printDeque();
        numbers.addFirst(1);
        numbers.printDeque();
        numbers.addLast(2);
        numbers.printDeque();
        numbers.addFirst(2);
        numbers.printDeque();
        numbers.addLast(9);
        numbers.printDeque();
//        numbers.addFirst(7);
//        numbers.printDeque();
//        numbers.addLast(8);
//        numbers.printDeque();
//        numbers.addFirst(7);
//        numbers.printDeque();
//        numbers.addLast(8);
//        numbers.printDeque();
//        int j = 0;
//        while (j < 8) {
////            numbers.addLast(1);
//            numbers.addFirst(2);
//            j += 1;
//        }

        int k = 0;
        while (k < 8) {
            System.out.println(numbers.get(k));
            k += 1;
        }

//        int i = 0;
//        while (i < 8) {
//            numbers.removeFirst();
//            numbers.printDeque();
//            i += 1;
//        }
}




}
