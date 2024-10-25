import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * for customer info class
 */
public class Customer extends Menu{
    String name;
    String  id;
    String password;
    /**
     * Creates a new object
     * @param name The  new name
     * @param id The  new id
     * @param  password new password
     * @throws  for the wrong parameter
     */
    public Customer(String name, String id, String password) throws IOException {
        this.name = name;
        this.id = id;
        this.password = password;
    }
    /**
     * Retrieves the name
     * @return The name
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name
     * @param name The new name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Retrieves the id
     * @return The id
     */
    public String getId() {
        return id;
    }
    /**
     * Sets the id
     * @param id The new id
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer: "+ id+"   "+password+"   "+name ;
    }
    /**
     * Retrieves the password
     * @return The password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Sets the password
     * @param password The new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * so that the customer can place an order
     * @throws FileNotFoundException If the file is not found
     */
    public void order () throws FileNotFoundException {
        Scanner myReader = new Scanner(myObj);
        System.out.println("Please enter  product id for order: ");
        String enterid = choice.nextLine();
        while(enterid.length() != 16){
            System.out.println("Please enter product id(16 digits): ");
            enterid = choice.nextLine();
        }
        System.out.println("okey1");
        boolean flag= false;
        int count = 0;
        while (myReader.hasNextLine() && !flag) {
            String data = myReader.nextLine();
            String tempdata = data.substring(0,16).trim();
            if(tempdata.equals(enterid)){
                flag = true;
                break;
            }
            count++;
        }
        myReader.close();
        System.out.println("okey2");
        System.out.println("count" + count);
        myObj = new FileInputStream(output);
        Scanner bc = new Scanner(myObj);
        int temploop = 0;
        System.out.println("okey3");
        while (bc.hasNextLine())
        {
            if(temploop == (count)){
                System.out.println("okey4");
                orderlist.add("order: "+ bc.nextLine());
            }
            temploop+=1;
        }
        bc.close();
        System.out.println("burdayım");
        while(!orderlist.isEmpty()) {
            System.out.println(orderlist.poll());
        }

    }
}
