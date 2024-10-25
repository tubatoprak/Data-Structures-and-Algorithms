import java.util.Scanner;
public class Main {
    /**
     * @author Tuba Toprak
     * @since 5/3/2022
     * @param args main
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nIf you do not want to enter the length of the street, enter 0 \nPlease enter street lenght: ");
       // int inp = input.nextInt();
        int inp = 0;
        if(inp > 0){
            Street street = new Street(inp);
            street.driver_menu();
            street.display_skyline();
        }
        else {
            Street street = new Street(55);
            street.driver();
            //street.driver_menu();//If the user wants to work with the street in the pdf,she/he should open this comment line.
            street.display_skyline();
        }
    }
}
