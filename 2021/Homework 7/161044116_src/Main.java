import java.util.NavigableSet;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //1.part
        NavigableSet<Integer> navl = new AVLTree<>();
        navl.add(100);
        navl.add(50);
        navl.add(150);
        System.out.println(navl.toString());

        NavigableSet<Integer> ns = new SkipList<>();
        ns.add(20);
        ns.add(9);
        ns.add(100);
        ns.add(45);
        System.out.println(ns.toString());
        System.out.println("delete 9: ");
        ns.remove(9);
        System.out.println(ns.toString());

        //2.part
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(100);
        tree.add(50);          //        100      this tree is avl
        tree.add(150);        //        /    \
        tree.add(25);        //      50       150
        tree.add(75);       //      /  \      /  \
        tree.add(125);     //      25  75    125  175
        tree.add(175);    //           / \         \
        tree.add(65);    //           65  85       180
        tree.add(85);   //
        tree.add(180);
        if (tree.isavl(tree)) System.out.println("Tree is AVL Tree");
        else
            System.out.println("Tree is not AVL Tree");
        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.add(100);      //     100  this tree is not avl
        tree2.add(50);      //     /
        tree2.add(10);     //     50
                          //     /
                         //     10
        if (tree2.isavl(tree2)) System.out.println("Tree is AVL Tree");
        else
            System.out.println("Tree is not AVL Tree");


        //3.part
        int size1 = 10000;
        int size2 = 20000;
        int size3 = 40000;
        int size4 = 80000;

        BinarySearchTree<Integer>[][] bst = new BinarySearchTree[4][10];
        RedBlackTree<Integer>[][] rbt = new RedBlackTree[4][10];
        BTree<Integer>[][] bt = new BTree[4][10];
        SkipList<Integer>[][] sl = new SkipList[4][10];
        TwoThreeTree<Integer>[][] ttt = new TwoThreeTree[4][10];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                bst[i][j] = new BinarySearchTree<>();
                rbt[i][j] = new RedBlackTree<>();
                bt[i][j] = new BTree<>(4);
                sl[i][j] = new SkipList<>();
                ttt[i][j] = new TwoThreeTree<>();

            }
        }
        Random rand = new Random();
        Integer[][] size10000 = new Integer[10][10000];
        Integer[][] size20000 = new Integer[10][20000];
        Integer[][] size40000 = new Integer[10][40000];
        Integer[][] size80000 = new Integer[10][80000];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < size1; j++)
                size10000[i][j] = rand.nextInt();
            for (int j = 0; j < size2; j++)
                size20000[i][j] = rand.nextInt();
            for (int j = 0; j < size3; j++)
                size40000[i][j] = rand.nextInt();
            for (int j = 0; j < size4; j++)
                size80000[i][j] = rand.nextInt();
        }

        long start = System.currentTimeMillis();
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < size1; k++) { //10.000
                bst[0][j].add(size10000[j][k]);
                rbt[0][j].add(size10000[j][k]);
                bt[0][j].add(size10000[j][k]);
                sl[0][j].add(size10000[j][k]);
                ttt[0][j].add(size10000[j][k]);
            }
            for (int k = 0; k < size2; k++) {  //20.000
                bst[1][j].add(size20000[j][k]);
                rbt[1][j].add(size20000[j][k]);
                bt[1][j].add(size20000[j][k]);
                sl[1][j].add(size20000[j][k]);
                ttt[1][j].add(size20000[j][k]);
            }
            for (int k = 0; k < size3; k++) {  //40.000
                bst[2][j].add(size40000[j][k]);
                rbt[2][j].add(size40000[j][k]);
                bt[2][j].add(size40000[j][k]);
                sl[2][j].add(size40000[j][k]);
                ttt[2][j].add(size40000[j][k]);
            }
            for (int k = 0; k < size4; k++) {  //80.000
                bst[3][j].add(size80000[j][k]);
                rbt[3][j].add(size80000[j][k]);
                bt[3][j].add(size80000[j][k]);
                sl[3][j].add(size80000[j][k]);
                ttt[3][j].add(size80000[j][k]);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Total Time" + (end - start));

        Integer[] arr100 = new Integer[100];
        for (int i = 0; i < arr100.length; i++) {
            arr100[i] = rand.nextInt();
        }
        long startTime;
        long endtime;
        int time = 0;
        System.out.println("------Binary Search Tree -------");
        System.out.println("10000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                bst[0][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("10000 (average) : "+time/10);

        System.out.println("20000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                bst[1][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("20000 (average) : "+time/10);

        System.out.println("40000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                bst[2][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("40000 (average) : "+time/10);

        System.out.println("80000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                bst[3][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("80000 (average) : "+time/10);

        System.out.println("------Red Black Tree -------");
        System.out.println("10000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                rbt[0][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("10000 (average) : "+time/10);

        System.out.println("20000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                rbt[1][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("20000 (average) : "+time/10);

        System.out.println("40000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                rbt[2][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("40000 (average) : "+time/10);

        System.out.println("80000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                rbt[3][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("80000 (average) : "+time/10);
        System.out.println("------BTree Tree -------");
        System.out.println("10000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                bt[0][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("10000 (average) : "+time/10);

        System.out.println("20000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                bt[1][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("20000 (average) : "+time/10);

        System.out.println("40000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                bt[2][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("40000 (average) : "+time/10);

        System.out.println("80000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                bt[3][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("80000 (average) : "+time/10);

        System.out.println("------Skiplist Tree -------");
        System.out.println("10000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                sl[0][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("10000 (average) : "+time/10);

        System.out.println("20000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                sl[1][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("20000 (average) : "+time/10);

        System.out.println("40000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                sl[2][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("40000 (average) : "+time/10);

        System.out.println("80000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                sl[3][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("80000 (average) : "+time/10);

        System.out.println("------2 3 Tree -------");
        System.out.println("10000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                ttt[0][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("10000 (average) : "+time/10);

        System.out.println("20000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                ttt[1][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("20000 (average) : "+time/10);
        System.out.println("40000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                ttt[2][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("40000 (average) : "+time/10);

        System.out.println("80000");
        time = 0;
        for (int j = 0; j <10 ; j++) {
            startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                ttt[3][j].add(arr100[i]);
            endtime =   System.nanoTime();
            System.out.println((endtime - startTime) + " nanotimes");
            time +=(endtime - startTime);
        }
        System.out.println("80000 (average) : "+time/10);
    }
}
