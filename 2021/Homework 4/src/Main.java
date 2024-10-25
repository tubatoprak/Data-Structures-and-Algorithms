/**
 *
 * @author tubatoprak
 *
 *
 */
public class Main {
    // Driver Code
    public static void main(String[] args)
    {
        //problem1
            Heap FirstHeap = new Heap<Integer>();
            Heap SecondHeap = new Heap<Integer>();

            FirstHeap.insert(10);
            FirstHeap.insert(5);
            FirstHeap.insert(6);
            FirstHeap.insert(2);

            SecondHeap.insert(12);
            SecondHeap.insert(7);
            SecondHeap.insert(9);

        System.out.print("First Heap: ");
        FirstHeap.print();
        System.out.print("\nSecond Heap: ");
        SecondHeap.print();
        System.out.println("\ninside the first heap we're searching for the number 22 ");
        System.out.println("Search for  22: "+FirstHeap.search(22)); //problem 1.-> i

        System.out.print("we merge the first heap and the second heap:  ");
        FirstHeap.merge(SecondHeap); //Merge with another heap
        FirstHeap.print();
        System.out.print("\nRemoving ith largest element from the Heap: ");
        FirstHeap.remove(0);
        FirstHeap.print();
        System.out.println("\nset the value (iterator) ");
        System.out.print("we replace the last element with the number 16: ");
        FirstHeap.settall(16);
        FirstHeap.print();
        //problem2
    }

}
