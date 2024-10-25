
import java.util.Scanner;

/***
 * customer class for customer
 */
public class Customer implements IUser {
    /**
     * @param name name of customer
     * @param password password of customer
     * @param id  of customer
     * @param adres of customer
     * @param myshopping recording of customer purchases
     */
    private  String name ;
    private String email;
    private int id;
    private String adres;
    KWArrayList<String> myshopping = new KWArrayList<>() ;
    Scanner myObj = new Scanner(System.in);
    private String password;
    private int phone ;
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
     * @param store shopping
     */
    public  void doShopping(Branch store) {
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
                while(store.chairProduct.getcolor(choice1) == null){
                    System.out.println("The product was entered incorrectly ");
                    System.out.print("Please select the product you want to buy: ");
                    choice1 = myObj.nextInt();
                }
                myshopping.add(store.chairProduct.getcolor(choice1) + " color " + store.chairProduct.getmodel(choice1) + ". Model Chair");
                store.deleteChairproduct(choice1);
                System.out.println("Your shopping has been completed.");
            } else if (choice1 == 2) {
                store.deskPrint();
                System.out.print("Please select the product you want to buy: ");
                choice1 = myObj.nextInt();
                choice1 -= 1;
                while(store.DeskProduct.getcolor(choice1) == null){
                    System.out.println("The product was entered incorrectly ");
                    System.out.print("Please select the product you want to buy: ");
                    choice1 = myObj.nextInt();
                }
                myshopping.add(store.DeskProduct.getcolor(choice1)+ " color " + store.DeskProduct.getmodel(choice1) + ". Model Desk");
                store.deleteDeskproduct(choice1);
                System.out.println("Your shopping has been completed.");
            } else if (choice1 == 3) {
                store.meetingTprint();
                System.out.print("Please select the product you want to buy: ");
                choice1 = myObj.nextInt();
                choice1 -= 1;
                while(store.MeetingTProduct.getcolor(choice1) == null){
                    System.out.println("The product was entered incorrectly ");
                    System.out.print("Please select the product you want to buy: ");
                    choice1 = myObj.nextInt();
                }
                myshopping.add(store.MeetingTProduct.getcolor(choice1) + " color " + store.MeetingTProduct.getmodel(choice1) + ". Model Meeting Table");
                store.deleteMeetingTproduct(choice1);
                System.out.println("Your shopping has been completed.");
            } else if (choice1 == 4) {
                store.bookcasesprint();
                System.out.print("Please select the product you want to buy: ");
                choice1 = myObj.nextInt();
                choice1 -= 1;
                while(store.BookCasesProduct.getmodel(choice1) == null){
                    System.out.println("The product was entered incorrectly ");
                    System.out.print("Please select the product you want to buy: ");
                    choice1 = myObj.nextInt();
                }
                store.bookcasesprint();
                myshopping.add(store.BookCasesProduct.getmodel(choice1) + ". Model BookCases");
                store.deleteBookCasesproduct(choice1);
                System.out.println("Your shopping has been completed.");
            } else if (choice1 == 5) {
                store.cabinetsprint();
                System.out.print("Please select the product you want to buy: ");
                choice1 = myObj.nextInt();
                choice1 -= 1;
                while(store.CabinetProduct.getmodel(choice1) == null){
                    System.out.println("The product was entered incorrectly ");
                    System.out.print("Please select the product you want to buy: ");
                    choice1 = myObj.nextInt();
                }
                store.cabinetsprint();
                myshopping.add(store.CabinetProduct.getmodel(choice1) + ". Model Office Cabinet");
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
        for (int i = 0; i < myshopping.size(); i++){
            System.out.println(i+1+". "+myshopping.get(i));
        }System.out.println("***********************************");
    }
}
