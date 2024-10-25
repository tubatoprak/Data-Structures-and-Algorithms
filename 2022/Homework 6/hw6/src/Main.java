import java.util.Random;
public class Main {

    public static void main(String[] args) {
        //---------------------------------------------------------------------Part 1
        HashTableChain<Integer,Integer> hash = new HashTableChain<>();
        hash.put(3,7);
        System.out.println(hash.toString());
        hash.put(12,4);
        System.out.println(hash.toString());
        hash.put(13,4);
        System.out.println(hash.toString());
        hash.put(25,8);
        System.out.println(hash.toString());
        hash.put(23,8);
        System.out.println(hash.toString());
        hash.put(51,6);
        System.out.println(hash.toString());
        hash.remove(25);
        System.out.println(hash.toString());

        HashTableChain<Integer,Integer> hash_chaining = new HashTableChain<>();
        int size =100;

        while (size<= 10000) {
            System.out.println("------------Chaining technique for hashing ("+size+")------------");
            long start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                hash_chaining.put(i, i + 3);
            }
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time of Put Method: " + time + " nano");

            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                hash_chaining.remove(i);
            }
            end = System.nanoTime();
            time = end - start;
            System.out.println("Time of Remove Method: " + time + " nano");
            size = size * 10;
        }




        // ------------------------------------------------------------------ Part2
        Random rand = new Random();

        Integer[] quick1 = new Integer[100];
        Integer[] quick2 = new Integer[1000];
        Integer[] quick3 = new Integer[10000];

        Integer[] merge1 = new Integer[100];
        Integer[] merge2 = new Integer[1000];
        Integer[] merge3 = new Integer[10000];
                                                   //to empirical experiment
        long time_merge1 = 0;
        long time_merge2 = 0;
        long time_merge3 = 0;

        long time_quick1 = 0;
        long time_quick2 = 0;
        long time_quick3 = 0;


        int temp = 0;
        System.out.print( "\n----Theoretical Result ----");
        while (temp < 1001) {

            int number;
            for (int i = 0; i < 100; ++i) {
                number = rand.nextInt(10000);
                quick1[i] = number;
                merge1[i] = number;
            }
            for (int i = 0; i < 1000; ++i) {
                number = rand.nextInt(10000);
                quick2[i] = number;
                merge2[i] = number;
            }
            for (int i = 0; i < 10000; ++i) {
                number = rand.nextInt(10000);
                quick3[i] = number;
                merge3[i] = number;
            }

            ///////////////////////////////////////////////////////////  100 items
            long start = System.nanoTime();
            QuickSort.sort(quick1);
            long end = System.nanoTime();
            long time = end - start;
            time_quick1 =time_quick1 + time;
            if(temp == 0) System.out.println("\nQuick Sort (100): " + time + " nano");

            start = System.nanoTime();
            MergeSort.sort(merge1);
            end = System.nanoTime();
            time = end - start;
            time_merge1 =time_merge1 + time;
            if(temp == 0) System.out.println("Merge Sort (100): " + time + " nano");


            /////////////////////////////////////////////////////////////1000 items
            start = System.nanoTime();
            QuickSort.sort(quick2);
            end = System.nanoTime();
            time = end - start;
            time_quick2 =time_quick2 + time;
            if(temp == 0) System.out.println("Quick Sort (1000): " + time + " nano");

            start = System.nanoTime();
            MergeSort.sort(merge2);
            end = System.nanoTime();
            time = end - start;
            time_merge2 = time_merge2 + time;
            if(temp == 0) System.out.println("Merge Sort (1000): " + time + " nano");

            /////////////////////////////////////////////////////////////10000 items
            start = System.nanoTime();
            QuickSort.sort(quick3);
            end = System.nanoTime();
            time = end - start;
            time_quick3 = time_quick3 + time;
            if(temp == 0) System.out.println("Quick Sort (10000): " + time + " nano");

            start = System.nanoTime();
            MergeSort.sort(merge3);
            end = System.nanoTime();
            time = end - start;
            if(temp == 0) System.out.println("Merge Sort (10000): " + time + " nano");
            time_merge3 = time_merge3 + time;
            temp++;
        }
        System.out.println( "\n----Empirical Result ----\n" +
                            " Merge Sort (100): "+(time_merge1/1000)+" nano\n" +
                            " Quick Sort (100): "+(time_quick1/1000)+" nano\n" +
                            " Merge Sort (1000): "+(time_merge2/1000)+" nano\n" +
                            " Quick Sort (1000): "+(time_quick2/1000)+" nano\n" +
                            " Merge Sort (10000): "+(time_merge3/1000)+" nano\n" +
                            " Quick Sort (10000): "+(time_quick3/1000)+" nano\n" );
    }

}
