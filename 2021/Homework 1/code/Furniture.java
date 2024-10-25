
import java.util.Scanner;


public class Furniture extends Company {
    /**
     * @param exit1  exit to main menu
     * @param exit2 to exit  nested menu
     * @param choice1 to get integer data from the user
     * @param choice2 to get string data from the user
     * @param choicestore the id of the branch chosen to make a transaction
     * @param Branches  number of all branches
     * @param nameBranch  to name the branches
     * @param nameofBranches the array that stores the names of the branches
     * @param store  the array class that stores branches
     * @param customers the array class that stores customers
     * @param  admin  define admin
     * @param customernumber number customers
     *
     */
    Scanner myObj = new Scanner(System.in);
    int exit1 = 0;
    int exit2 = 0;
    int choice1 = 0;
    int choicestore = 0;
    String choice2;
    int choice;
    int exit3 = 0;
    int Branches = 0;
    char nameBranch ='A';
    String[] namesofBranchs = new String[10];
    Company[] store = new Company[10];
    Customer[]  customers = new Customer[10];
    Administrator admin = new Administrator();
    int customernumber = 0;

    /**
     * Constructor
     * this constoructor
     * This constructor starts by creating 4 branches and an online branch.
     * branches are created and named.
     */

    public Furniture() {
        for (int i = 0; i < 5; i++) {
            store[i] = new Company();
            store[i].fillCompany();
            if(i == 4)namesofBranchs[i] = "Online";
            else
                namesofBranchs[i] = String.valueOf(nameBranch);
            nameBranch += 1;
            Branches  += 1;
        }
    }

    /**
     * This method is the menu system created for the user to use interactively.
     */
    @Override
    public void menu() {
        while (exit1 == 0){
            System.out.println("---Welcome Furniture Store---");
            System.out.println("1) Admin Login");
            System.out.println("2) Employee Login");
            System.out.println("3) Customer Login");
            System.out.println("4) Exit Furniture Store");
            System.out.print("Please Choice enter: ");
            choice = myObj.nextInt();

            switch (choice) {
                case 1:
                    exit3 = 0;
                    while (exit3 == 0) {
                        System.out.println("---Admin Panel---");
                        System.out.println("1) Adding Branch");
                        System.out.println("2) Removing Branch");
                        System.out.println("3) Adding Branch Employee");
                        System.out.println("4) Removing Branch Employee");
                        System.out.println("5) Look/Edit Product ");
                        System.out.println("6) Look Branch");
                        System.out.println("7) Look Employee in Branches");
                        System.out.println("8) Go Back <-- ");
                        System.out.print("Please Choice enter: ");
                        choice1 = myObj.nextInt();
                        if (choice1 == 1) {
                            try {
                                store[Branches] = new Company();
                                store[Branches].fillCompany();
                                namesofBranchs[Branches] = String.valueOf(nameBranch);
                                nameBranch += 1;
                                Branches += 1;
                                System.out.println("Congratulations on your " + (Branches) + ". store");
                            } catch (ArrayIndexOutOfBoundsException  e) {
                                System.out.println("Store capacity exceeded.");
                            }
                        }
                        else if (choice1 == 2) {
                            printMyStore();
                            System.out.print("Please enter the shop number you want to delete. ");
                            choice1 = myObj.nextInt();
                            choice1 -= 1;
                            if (choice1 < Branches + 1) {
                                for (int i = choice1; i < Branches; i++) {
                                    store[i] = store[i + 1];
                                    namesofBranchs[i] = namesofBranchs[i + 1];
                                }
                                Branches -= 1;
                            } else {
                                System.out.println("Error..Incorrect Choice..");
                            }
                            System.out.println("Branch Removed..");
                            printMyStore();
                        } else if (choice1 == 3) addBranchEmployee();
                        else if (choice1 == 4) removeBranchEmployee();
                        else if (choice1 == 5) lookProduct();
                        else if (choice1 == 6) printMyStore();
                        else if (choice1 == 7) lookemployee();
                        else if (choice1 == 8) exit3 = 1;
                        else {
                            System.out.println("Incorrect Choice..");
                        }
                    }
                break;
                case 2:
                    exit3 = 0;
                    while (exit3 == 0) {
                        System.out.println("---Employee Panel---");
                        System.out.println("1) Look Product");
                        System.out.println("2) Remove Product");
                        System.out.println("3) Add Product");
                        System.out.println("4) Look Customer İnfo ");
                        System.out.println("5) Create New Customer ");
                        System.out.println("6) Go Back <-- ");
                        System.out.print("Please Choice enter: ");
                        choice1 = myObj.nextInt();
                        if (choice1 == 1) {
                            lookProduct();
                        } else if (choice1 == 2) {
                            remove_product();
                        } else if (choice1 == 3) {
                            add_product();
                        } else if (choice1 == 4) {
                            customerinfo();
                        } else if (choice1 == 5) {
                            createcustomer();
                        } else if (choice1 == 6) {
                            exit3 = 1;
                        } else {
                            System.out.println("Incorrect entry");
                        }
                    }
                break;
                case 3 :
                    exit3 = 0;
                    while (exit3 == 0) {
                        System.out.println("---Customer Panel---");
                        System.out.println("1) Sign Up");
                        System.out.println("2) Sign In");
                        System.out.println("3) Back");
                        System.out.print("Please Choice enter: ");
                        choice1 = myObj.nextInt();
                        if (choice1 == 1) {
                            createcustomer();
                            System.out.println("Please go back and log in to the system. ");
                        }
                        if (choice1 == 2) {
                            exit2 = 0;
                            int temp = 0;
                            if (controlLogin())
                                while (exit2 == 0) {
                                    System.out.println("----------Welcome--------");
                                    System.out.println("1-) Look at Branches");
                                    System.out.println("2-) Do the Shopping ");
                                    System.out.println("3-) My previous purchases");
                                    System.out.println("4-) Look In Branch");
                                    System.out.println("5-) My Info");
                                    System.out.println("6-) Logout");
                                    System.out.print("Please enter your choice: ");
                                    temp = myObj.nextInt();
                                    if (temp == 1) printMyStore();
                                    else if (temp == 2) customers[choice1 - 1].doShopping(store[choicestore]);
                                    else if (temp == 3) customers[choice1 - 1].MyShopping();
                                    else if (temp == 4) lookProduct();
                                    else if (temp == 6) exit2 = 1;
                                    else if (temp == 5) customerinfo();
                                    else {
                                        System.out.println("Incorrect Choice...");
                                    }
                                }
                        }
                        if (choice1 == 3) {
                            exit3 = 1;
                        }
                    }
                break;
                case 4: exit1 = 1;
                break;
            }
        }
    }

    /**
     * This method checks that the id and password entered by the user match.
     * @return returns true if entries are true or returns false
     */
    boolean  controlLogin() {
        System.out.print("Please Your Shopping id: ");
        choice1 = myObj.nextInt();
        for (int i = 0; i < customernumber; i++) {
            if (customers[i].getId() == choice1) {
                System.out.print("Please Your Password: ");
                myObj.nextLine();
                choice2 = myObj.nextLine();
                if (customers[choice1 - 1].getPassword().equals(choice2)) {return true;}
            }
        }
        System.out.println("User not Found");
        return false;
    }

    /**
     * for the user to access the products
     */
    public void selectProduct() {
        printMyStore();
        System.out.print("Enter the store number : ");
        choicestore = myObj.nextInt();
        while (choicestore > Branches || choicestore < 1) {
            System.out.println("Incorrect  Choice..");
            System.out.print("Enter the store number : ");
            choicestore = myObj.nextInt();
        }
        System.out.println("1-) Chair");
        System.out.println("2-) Desk");
        System.out.println("3-) Meeting Table");
        System.out.println("4-) Bookcase");
        System.out.println("5-) Office Cabinet");
        System.out.print("Please select the product: ");
    }

    /**
     * for the user to look the products
     */
    public  void lookProduct() {
        selectProduct();
        int select = 0;
        select = myObj.nextInt();
        while (select > 5 || select < 1){
            System.out.println("Incorrect Choice..");
            System.out.print("Please select the product: ");
            select = myObj.nextInt();
        }
        if (select == 1){store[choicestore-1].chairprint();}
        else if (select == 2){store[choicestore-1].deskPrint();}
        else if (select == 3){store[choicestore-1].meetingTprint();}
        else if (select == 4){store[choicestore-1].bookcasesprint();}
        else if (select == 5){store[choicestore-1].cabinetsprint();}
        else { System.out.println("Wrong Choice");}
    }
    /**
     * to view branches
     */
    public void printMyStore(){
        for (int i = 1; i < Branches+1; i++){System.out.println(i + "-)"+" "+ namesofBranchs[i-1] +" Store");}
    }
    /**
     * To add products to branches
     */
    public void add_product(){
        selectProduct();
        choice1 = myObj.nextInt();
        if (choice1 == 1)store[choicestore-1].addChairproduct();
        else if(choice1 == 2){store[choicestore-1].addDeskproduct();}
        else if(choice1 == 3){store[choicestore-1].addMeetingTproduct();}
        else if(choice1 == 4){store[choicestore-1].addbookCasesproduct();}
        else if(choice1 == 5){store[choicestore-1].addCabineproduct();}
        else {System.out.println("Wrong Choice.Product could not be added.");}
    }

    /**
     * To delete products to branches
     */
    public  void remove_product(){
        selectProduct();
        choice1 = myObj.nextInt();
        if (choice1 == 1){
            store[choicestore-1].chairprint();
            System.out.print("Enter the number of the product you want to delete: ");
            choice1 = myObj.nextInt();
            choice1-=1;
            store[choicestore-1].deleteChairproduct(choice1);
            store[choicestore-1].chairprint();
        }
        else if(choice1 == 2){
            store[choicestore-1].deskPrint();
            System.out.print("Enter the number of the product you want to delete: ");
            choice1 = myObj.nextInt();
            choice1-=1;
            store[choicestore-1].deleteDeskproduct(choice1);
            store[choicestore-1].deskPrint();
        }
        else if(choice1 == 3){
            store[choicestore-1].meetingTprint();
            System.out.print("Enter the number of the product you want to delete: ");
            choice1 = myObj.nextInt();
            choice1-=1;
            store[choicestore-1].deleteMeetingTproduct(choice1);
            store[choicestore-1].meetingTprint();
        }
        else if(choice1 == 4){
            store[choicestore-1].meetingTprint();
            System.out.print("Enter the number of the product you want to delete: ");
            choice1 = myObj.nextInt();
            choice1-=1;
            store[choicestore-1].deleteMeetingTproduct(choice1);
            store[choicestore-1].meetingTprint();
        }
        else if(choice1 == 5){
            store[choicestore-1].cabinetsprint();
            System.out.print("Enter the number of the product you want to delete: ");
            choice1 = myObj.nextInt();
            choice1-=1;
            store[choicestore-1].deleteCabinetproduct(choice1);
            store[choicestore-1].cabinetsprint();
        }
        else {System.out.println("Wrong Choice.Product could not be deleted.");}
    }
    /**
     * to view customers' information
     */
    public void customerinfo(){
        System.out.print("Enter id: ");
        choice1 = myObj.nextInt();
        while (choice1 > customernumber){
            System.out.println("Wrong entry re-enter id: ");
            choice1 = myObj.nextInt();
        }
        customers[choice1-1].info();
    }

    /**
     * to create new customer
     */
    public void createcustomer(){
        customers[customernumber] = new Customer();
        System.out.print("Please Enter your name: ");
        myObj.nextLine();
        choice2 =myObj.nextLine();
        customers[customernumber].setName(choice2);
        System.out.print("Please Enter your e-mail: ");
        choice2 =myObj.nextLine();
        customers[customernumber].setEmail(choice2);
        System.out.print("Please Enter your Password: ");
        choice2 =myObj.nextLine();
        customers[customernumber].setPassword(choice2);
        customers[customernumber].setId(customernumber+1);
        System.out.println("You Are Now a Registered User and Your id : "+customers[customernumber].getId());
        customernumber += 1;
    }

    /**
     *shows the employees in the branch
     * @param select  branch id
     */
    public void printEmployee(int select){
        System.out.println("******Employees In Branch*********");
        for (int i = 0; i < store[select-1].numberofemployees ; i++) {
            System.out.println(i+1 +".Employee: "+ store[select-1].employee[i].getName());
        }
    }

    /**
     * shows the employees in the branch
     */
    public  void lookemployee(){
        printMyStore();
        System.out.print("Enter the store number : ");
        choicestore = myObj.nextInt();
        while (choicestore > Branches || choicestore < 1) {
            System.out.println("Incorrect  Choice..");
            System.out.print("Enter the store number : ");
            choicestore = myObj.nextInt();
        }
        store[choicestore-1].printemployee();
    }

    /**
     * to delete workers from the branch
     */
    public void removeBranchEmployee(){
        printMyStore();
        System.out.print("Please select a branch to delete employee: ");
        int choice4 = myObj.nextInt();
        while(choice4 > Branches || choice4 == 5 || choice4 < 1 ){
            System.out.println("Incorrecct Choice or  Cannot add employee to online store. ");
            System.out.print("Please select a branch to add employee: ");
            choice4 = myObj.nextInt();
        }
        if(store[choice4-1].numberofemployees == 0) System.out.println("There are no employee in this branch");
        else {
            printEmployee(choice4);
            store[choice4 - 1].deleteEmploye();
        }

    }

    /**
     * to add workers from the branch
     */
    public void addBranchEmployee(){
        printMyStore();
        System.out.print("Please select a branch to add employee: ");
        int  choice4 = myObj.nextInt();
        while(choice4 > Branches || choice4 == 5 || choice4 < 1 ){
            System.out.println("Incorrecct Choice or  Cannot add employee to online store. ");
            System.out.print("Please select a branch to add employee: ");
            choice4 = myObj.nextInt();
        }
        store[choice4-1].addEmployee();
        printEmployee(choice4);

    }
}
