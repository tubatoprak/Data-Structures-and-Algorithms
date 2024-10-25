
import java.util.Scanner;

public class Customer implements IUser {
    /**
     * @param name name of customer
     * @param password password of customer
     * @param id  of customer
     * @param adres of customer
     * @param myshopping recording of customer purchases
     * @param shoppingnumber the number of purchases made by the customer
     */
    private  String name ;
    private String email;
    private int id;
    private String adres;
    String[] myshopping = new String[100];
    Scanner myObj = new Scanner(System.in);
    private String password;
    private int phone ;
    int shoppingNumber = 0;
    int choice1= 0;
    String choice2 ="";

    /**
     * Constructor
     */
    public Customer() {
    }

    /**
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password  setter password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param name setter e-mail
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param email setter e-mail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param id setter id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param adres setter id
     */
    public void setAdres(String adres) {
        this.adres = adres;
    }

    /**
     *
     * @param phone setter phone
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     *
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @return e-mail
     */
    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    /**
     *
     * @return adres
     */
    public String getAdres() {
        return adres;
    }

    /**
     * @return phone
     */
    public int getPhone() {
        return phone;
    }
    /**
     * this method is for the customer to shop
     *
     */
    public  void doShopping(Company store)
    {
        System.out.println("Please enter  your Adress");
        choice2 =myObj.nextLine();
        this.setAdres(choice2);
        System.out.println("Please enter  your phone");
        choice1 =myObj.nextInt();
        this.setPhone(choice1);
        int temp = 0;
        while(temp == 0) {
            System.out.println("1-) Chair");
            System.out.println("2-) Desk");
            System.out.println("3-) Meeting Table");
            System.out.println("4-) Bookcase");
            System.out.println("5-) Office Cabinet");
            System.out.println("6-) Exit");
            System.out.print("Please select the product: ");
            choice1 = myObj.nextInt();
            while(choice1 < 0 || choice1 > 6) {
                System.out.println("Incorrect Select..");
                System.out.print("Please select the product: ");
                choice1 = myObj.nextInt();
            }
            if (choice1 == 1) {
                store.chairprint();
                System.out.print("Please select the product you want to buy: ");
                choice1 = myObj.nextInt();
                choice1 -= 1;
                while(store.chairProduct[choice1][0] == null){
                    System.out.println("The product was entered incorrectly ");
                    System.out.print("Please select the product you want to buy: ");
                    choice1 = myObj.nextInt();
                }
                myshopping[shoppingNumber] = store.chairProduct[choice1][0] + " color " + store.chairProduct[choice1][1] + ". Model Chair";
                shoppingNumber += 1;
                store.deleteChairproduct(choice1);
                System.out.println("Your shopping has been completed.");
            } else if (choice1 == 2) {
                store.deskPrint();
                System.out.print("Please select the product you want to buy: ");
                choice1 = myObj.nextInt();
                choice1 -= 1;
                while(store.DeskProduct[choice1][0] == null){
                    System.out.println("The product was entered incorrectly ");
                    System.out.print("Please select the product you want to buy: ");
                    choice1 = myObj.nextInt();
                }
                myshopping[shoppingNumber] =store.DeskProduct[choice1][0] + " color " + store.DeskProduct[choice1][1] + ". Model Desk";
                shoppingNumber += 1;
                store.deleteDeskproduct(choice1);
                System.out.println("Your shopping has been completed.");
            } else if (choice1 == 3) {
                store.meetingTprint();
                System.out.print("Please select the product you want to buy: ");
                choice1 = myObj.nextInt();
                choice1 -= 1;
                while(store.MeetingTProduct[choice1][0] == null){
                    System.out.println("The product was entered incorrectly ");
                    System.out.print("Please select the product you want to buy: ");
                    choice1 = myObj.nextInt();
                }
                myshopping[shoppingNumber] = store.MeetingTProduct[choice1][0] + " color " + store.MeetingTProduct[choice1][1] + ". Model Meeting Table";
                shoppingNumber += 1;
                store.deleteMeetingTproduct(choice1);
                System.out.println("Your shopping has been completed.");
            } else if (choice1 == 4) {
                store.bookcasesprint();
                System.out.print("Please select the product you want to buy: ");
                choice1 = myObj.nextInt();
                choice1 -= 1;
                while(store.BookCasesProduct[choice1]== null){
                    System.out.println("The product was entered incorrectly ");
                    System.out.print("Please select the product you want to buy: ");
                    choice1 = myObj.nextInt();
                }
                store.bookcasesprint();
                this.myshopping[shoppingNumber] = store.BookCasesProduct[choice1] + ". Model BookCases";
                shoppingNumber += 1;
                store.deleteBookCasesproduct(choice1);
                System.out.println("Your shopping has been completed.");
            } else if (choice1 == 5) {
                store.cabinetsprint();
                System.out.print("Please select the product you want to buy: ");
                choice1 = myObj.nextInt();
                choice1 -= 1;
                while(store.CabinetProduct[choice1]== null){
                    System.out.println("The product was entered incorrectly ");
                    System.out.print("Please select the product you want to buy: ");
                    choice1 = myObj.nextInt();
                }
                store.cabinetsprint();
                this.myshopping[shoppingNumber] = store.CabinetProduct[choice1] + ". Model Office Cabinet";
                shoppingNumber += 1;
                store.deleteCabinetproduct(choice1);
                System.out.println("Your shopping has been completed.");
            }else if(choice1 == 6){
                temp = 1;
            }else {
                System.out.println("Incorrect Choice");
            }
        }
    }

    /**
     * to print the customer's information on the screen
     */
    @Override
    public void info() {
        System.out.println("Name: "+ getName());
        System.out.println("E-mail: "+ getEmail());
        System.out.println("Shopping Id: "+ getId());
        System.out.println("Adres: " + getAdres());
        System.out.println("Phone: "+ getPhone());
    }

    /**
     * To view the previous purchases of the customer
     */
    public void MyShopping(){
        System.out.println("*******My Previous Orders***********");
        for (int i = 0; i < shoppingNumber; i++){
            System.out.println(i+1+". "+myshopping[i]);
        }System.out.println("***********************************");
    }
}
