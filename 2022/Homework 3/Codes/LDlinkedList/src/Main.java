import java.util.Scanner;
public class Main {
    /**
     * @author Tuba Toprak
     * @since 5/3/2022
     * @param args main
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nIf you do not want to enter the length of the street, enter 0 \nPlease enter street lenght: \n");
       // int inp = input.nextInt();
        int inp = 0;
        if(inp > 0){
            Street street = new Street(inp);
            street.driver_menu();
            street.display_skyline();
        }
        else {
            long start1 = System.nanoTime();
            Street street = new Street(55);
            street.driver();
            //street.driver_menu();//If the user wants to work with the street in the pdf,she/he should open this comment line.
            street.display_skyline();
            long end2 = System.nanoTime();
            System.out.println("Experimental Running Time: "+(end2-start1)+" nano times\n");
        }
        different_size_scenarios();
    }
    /**
     * Calculates the runing time of data of different sizes.
     */
    public static void different_size_scenarios(){
        LDLinkedList<Integer> small = new LDLinkedList<>();
        LDLinkedList<Integer> middle = new LDLinkedList<>();
        LDLinkedList<Integer> large = new LDLinkedList<>();
        System.out.println("--LDLinkedlist Different Size Scenarios---");
        /////////////////////////////////////////////////
        long start1 = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            small.add(i);
        }
        long end1 = System.nanoTime();
        System.out.println("Small Size: "+ (end1-start1));

        /////////////////////////////////////////////////
        long start2 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            middle.add(i);
        }
        long end2 = System.nanoTime();
        System.out.println("Middle Size: "+ (end2-start2));

        ////////////////////////////////////////////////
        long start3 = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            large.add(i);
        }
        long end3 = System.nanoTime();
        System.out.println("Large Size: "+ (end3-start3));
    }
}

