import java.util.Scanner;

/***
 * the automation system itself
 */
public class Furniture extends Branch {
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
     * @param  MAX_NUMBER The number of elements in each ArrayList should be less than MAX_NUMBER.
     */
    Scanner myObj = new Scanner(System.in);
    int k  = 0;//online m
    int exit1 = 0;
    int exit2 = 0;
    int choice1 = 0;
    int choicestore = 0;
    String choice2;
    int choice;
    int exit3 = 0;
    int Branches = 0;
    char nameBranch ='A';
    int MAX_NUMBER = 2;

    KWArrayList<String> namesofBranchs = new KWArrayList<>() ;
    KWSingleLinkedList<Branch> store = new KWSingleLinkedList<>();
    KWArrayList<Customer> customers = new KWArrayList<>();
    KWArrayList<Administrator> admin = new KWArrayList<>();
    /**
     * Constructor
     * this constoructor
     * This constructor starts by creating 4 branches and an online branch.
     * branches are created and named.
     */

    public Furniture() {
        admin.add(new Administrator());
        for (int i = 0; i < 5; i++) {
            store.add(new Branch());
            store.get(i).fillCompany();
            if(i == 4)namesofBranchs.add( "Online");
            else
                namesofBranchs.add( String.valueOf(nameBranch));
            Branches++;
            nameBranch += 1;
            k = 4;
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
                case 1 : {
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
                                admin.get(0).addBranch(store, Branches);
                                namesofBranchs.add( String.valueOf(nameBranch));
                                nameBranch += 1;
                                Branches += 1;
                                System.out.println("Congratulations on your " +Branches + ". store");
                        }
                        else if (choice1 == 2) {
                            printMyStore();
                            System.out.print("Please enter the shop number you want to delete. ");
                            choice1 = myObj.nextInt();
                            choice1 -= 1;
                            if (choice1 < Branches + 1) {
                                admin.get(0).removeBranch(store,choice1);
                                if (Branches - choice1 >= 0)
                                    System.arraycopy(namesofBranchs, choice1 + 1, namesofBranchs, choice1, Branches - choice1);
                                Branches -= 1;
                            } else {
                                System.out.println("Error..Incorrect Choice..");
                            }
                            System.out.println("Branch Removed..");
                            printMyStore();
                        } else if (choice1 == 3) {
                            printMyStore();
                            System.out.print("Please select a branch to add employee: ");
                            int  choice4 = myObj.nextInt();
                            while(choice4 > Branches || choice4 == k || choice4 < 1 ){
                                System.out.println("Incorrecct Choice or  Cannot add employee to online store. ");
                                System.out.print("Please select a branch to add employee: ");
                                choice4 = myObj.nextInt();
                            }
                            admin.get(0).addBranchEmployee(store,choice4-1);
                            printEmployee(choice4);
                        }
                        else if (choice1 == 4) {
                            printMyStore();
                            System.out.print("Please select a branch to delete employee: ");
                            int choice4 = myObj.nextInt();
                            while(choice4 > Branches || choice4 == k || choice4 < 1 ){
                                System.out.println("Incorrecct Choice or  Cannot add employee to online store. ");
                                System.out.print("Please select a branch to add employee: ");
                                choice4 = myObj.nextInt();
                            }
                            if(store.get(choice4-1).employee.size() == 0) System.out.println("There are no employee in this branch");
                            else {
                                printEmployee(choice4);
                                admin.get(0).removeBranchEmployee(store,choice4);
                            }
                        }
                        else if (choice1 == 5) lookProduct();
                        else if (choice1 == 6) printMyStore();
                        else if (choice1 == 7) {
                            printMyStore();
                            System.out.print("Enter the store number : ");
                            choicestore = myObj.nextInt();
                            while (choicestore > Branches || choicestore < 1) {
                                System.out.println("Incorrect  Choice..");
                                System.out.print("Enter the store number : ");
                                choicestore = myObj.nextInt();
                            }
                            admin.get(0).lookemployee(store,choicestore);
                        }
                        else if (choice1 == 8) exit3 = 1;
                        else {
                            System.out.println("Incorrect Choice..");
                        }
                    }
                }break;
                case 2 : {
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
                }break;
                case 3 : {
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
                            int temp;
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
                                    else if (temp == 2) {
                                        for ( k = 0; k < Branches + 1 ; k++) {
                                            if (namesofBranchs.get(k).equals("Online"))
                                                break;
                                        }
                                        customers.get(choice1 - 1).doShopping(store.get(k));
                                    }
                                    else if (temp == 3) customers.get(choice1 - 1).MyShopping();
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
                }break;
                case 4 : exit1 = 1;
                break;
                default:
                    System.out.println("Incorrect entry");
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
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == choice1) {
                System.out.print("Please Your Password: ");
                myObj.nextLine();
                choice2 = myObj.nextLine();
                if (customers.get(choice1 - 1).getPassword().equals(choice2)) {return true;}
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
        int select;
        select = myObj.nextInt();
        while (select > 5 || select < 1){
            System.out.println("Incorrect Choice..");
            System.out.print("Please select the product: ");
            select = myObj.nextInt();
        }
        if (select == 1){store.get(choicestore-1).chairprint();}
        else if (select == 2){store.get(choicestore-1).deskPrint();}
        else if (select == 3){store.get(choicestore-1).meetingTprint();}
        else if (select == 4){store.get(choicestore-1).bookcasesprint();}
        else {store.get(choicestore-1).cabinetsprint();}
    }
    /**
     * to view branches
     */
    public void printMyStore(){
        for (int i = 1; i < Branches+1; i++){System.out.println(i + "-)"+" "+ namesofBranchs.get(i-1) +" Store");}
    }
    /**
     * To add products to branches
     */
    public void add_product(){
        selectProduct();
        choice1 = myObj.nextInt();
        if (choice1 == 1)store.get(choicestore-1).addChairproduct();
        else if(choice1 == 2){store.get(choicestore-1).addDeskproduct();}
        else if(choice1 == 3){store.get(choicestore-1).addMeetingTproduct();}
        else if(choice1 == 4){store.get(choicestore-1).addbookCasesproduct();}
        else if(choice1 == 5){store.get(choicestore-1).addCabineproduct();}
        else {System.out.println("Wrong Choice.Product could not be added.");}
    }
    /**
     * To delete products to branches
     */
    public  void remove_product(){
        selectProduct();
        choice1 = myObj.nextInt();
        if (choice1 == 1){
            store.get(choicestore-1).chairprint();
            System.out.print("Enter the number of the product you want to delete: ");
            choice1 = myObj.nextInt();
            choice1-=1;
            store.get(choicestore-1).deleteChairproduct(choice1);
            store.get(choicestore-1).chairprint();
        }
        else if(choice1 == 2){
            store.get(choicestore-1).deskPrint();
            System.out.print("Enter the number of the product you want to delete: ");
            choice1 = myObj.nextInt();
            choice1-=1;
            store.get(choicestore-1).deleteDeskproduct(choice1);
            store.get(choicestore-1).deskPrint();
        }
        else if(choice1 == 3){
            store.get(choicestore-1).meetingTprint();
            System.out.print("Enter the number of the product you want to delete: ");
            choice1 = myObj.nextInt();
            choice1-=1;
            store.get(choicestore-1).deleteMeetingTproduct(choice1);
            store.get(choicestore-1).meetingTprint();
        }
        else if(choice1 == 4){
            store.get(choicestore-1).meetingTprint();
            System.out.print("Enter the number of the product you want to delete: ");
            choice1 = myObj.nextInt();
            choice1-=1;
            store.get(choicestore-1).deleteMeetingTproduct(choice1);
            store.get(choicestore-1).meetingTprint();
        }
        else if(choice1 == 5){
            store.get(choicestore-1).cabinetsprint();
            System.out.print("Enter the number of the product you want to delete: ");
            choice1 = myObj.nextInt();
            choice1-=1;
            store.get(choicestore-1).deleteCabinetproduct(choice1);
            store.get(choicestore-1).cabinetsprint();
        }
        else {System.out.println("Wrong Choice.Product could not be deleted.");}
    }
    /**
     * to view customers' information
     */
    public void customerinfo(){
        System.out.print("Enter id: ");
        choice1 = myObj.nextInt();
        while (choice1 > customers.size()){
            System.out.println("Wrong entry re-enter id: ");
            choice1 = myObj.nextInt();
        }
        customers.get(choice-1).info();
    }
    /**
     * to create new customer
     */
    public void createcustomer(){
        customers.add(new Customer());
        System.out.print("Please Enter your name: ");
        myObj.nextLine();
        choice2 =myObj.nextLine();
        customers.get(customers.size()-1).setName(choice2);
        System.out.print("Please Enter your e-mail: ");
        choice2 =myObj.nextLine();
        customers.get(customers.size()-1).setEmail(choice2);
        System.out.print("Please Enter your Password: ");
        choice2 =myObj.nextLine();
        customers.get(customers.size()-1).setPassword(choice2);
        customers.get(customers.size()-1).setId(customers.size());
        System.out.println("You Are Now a Registered User and Your id : "+customers.get(customers.size()-1).getId());
    }
    /**
     *shows the employees in the branch
     * @param select  branch id
     */
    public void printEmployee(int select){
        System.out.println("******Employees In Branch*********");
        for (int i = 0; i < store.get(select-1).employee.size() ; i++) {
            System.out.println(i+1 +".Employee: "+ store.get(select-1).employee.get(i).getName());
        }
    }
}
