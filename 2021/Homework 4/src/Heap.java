import javax.lang.model.type.NullType;
import java.util.Iterator;

public class Heap<E extends Comparable<E>> {
    /**
     *
     * @param to save elements in heap
     */
    public  int[]Heaparray = new int[100];
    /**
     * @param size of heap structure
     */
    public  int size = -1;

    /**
     *
     * @param i location of the element to be added
     * @return location
     */
    public int parent(int i)
    {
        return (i - 1) / 2;
    }
    /**
     *  to settle the heap's arms
     * @param i location of the element to be added
     * @return location
     */
    public int leftChild(int i)
    {
        return ((2 * i) + 1);
    }

    /**
     *  to settle the heap's arms
     * @param i location of the element to be added
     * @return location
     */
    public int rightChild(int i)
    {
        return ((2 * i) + 2);
    }

    /**
     *to settle the heap's arms
     * @param i location of the element to be added
     */
    public void shiftUp(int i)
    {
        while (i > 0 &&
                Heaparray[parent(i)] < Heaparray[i])
        {
            swap(parent(i), i);

            // Update i to parent of i
            i = parent(i);
        }
    }
    /**
     *
     * @param i location of the element to be added
     */
    public void shiftDown(int i)
    {
        int maxIndex = i;

        int l = leftChild(i);

        if (l <= size &&
                Heaparray[l] > Heaparray[maxIndex])
        {
            maxIndex = l;
        }
        int r = rightChild(i);

        if (r <= size &&
                Heaparray[r] > Heaparray[maxIndex])
        {
            maxIndex = r;
        }

        if (i != maxIndex)
        {
            swap(i, maxIndex);
            shiftDown(maxIndex);
        }
    }

    /**
     *  to add items inside the heap
     * @param p element to add
     */
    public void insert(int p) {
        size = size + 1;
        Heaparray[size] = p;
        shiftUp(size);
    }
    /**
     *
     * @return head in heap
     */
    public int extractMax()
    {
        int result = Heaparray[0];
        Heaparray[0] = Heaparray[size];
        size = size - 1;
        shiftDown(0);
        return result;
    }

    /**
     *  to return the leading element in the heap
     * @return the value of the earliest heap
     */
    public int headHeap()
    {
        return Heaparray[0];
    }

    /**
     *  to delete element from heap
     * @param i index to be deleted
     */
    public void remove(int i)
    {
        Heaparray[i] = headHeap() + 1;
        shiftUp(i);
        extractMax();
    }

    /**
     *  to swap the heap
     * @param i element to swap
     * @param j element to swap
     */
    public void swap(int i, int j)
    {
        int temp= Heaparray[i];
        Heaparray[i] = Heaparray[j];
        Heaparray[j] = temp;
    }

    /**
     *  to search elements in heap
     * @param a element to search
     * @return  true if element exists otherwise false
     */
    boolean search(int a ){
        for (int i = 0; i < size+1; i++) {
            if (Heaparray[i] == a)
                return true;
        }
        return false;
    }

    /**
     * function to delete the last element
     */
    public  void remove_largest_element(){
        remove(0);
    }

    /**
     *  to merge two heap structures
     * @param object1 other object to be merge
     */
    public  void merge(Heap object1) {
        while (object1.size != -1) {
            int a = object1.headHeap();
            insert(a);
            object1.remove(0);
        }
    }

    /**
     *to change the last element
     * @param a new element
     */
    public void settall(int a){
        Hiterator<E>  it = Hiterator();
        it.setall(a);
    }

    /**
     * to print the elements in the heap
     */
    public void print() {
       Hiterator<E>  it = Hiterator();
       while(it.hasNext())
            System.out.print(it.next() + " ");
    }

    /**
     *
     * @return iterator
     */
    private Heap<E>.Hiterator<E> Hiterator() {
        return new Hiterator<E>(0);
    }

    /**
     *
     * @param <E> iterator
     */
    public class Hiterator<E> implements  Iterator<Integer> {
        int iter = -1;
        public Hiterator(int i) {
        }

        /**
         *to check if the next element in the heap is
         * @return returns true if the next element is not null
         */
        @Override
        public boolean hasNext() {
            if (iter < size ) {
                iter += 1;
                return true;
            }
            else{
                iter += 1;
                return false;
            }
        }

        /**
         *to access the element in heap
         * @return  returns element
         */
        @Override
        public Integer next(){
            return  Heaparray[iter];

        }

        /**
         * to change the last index element
         * @param a new element to replace the last element
         */
        public void setall(int a ){
           while(hasNext()){}
           Heap.this.remove(iter-1);
           Heap.this.insert(a);
        }
    }
}
