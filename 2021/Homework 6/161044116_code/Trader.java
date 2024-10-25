import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

/**
 * for Treders info class
 */
public class Trader  extends Menu {
    String name;
    String  id;
    String password;
    /**
     * Creates a new object
     * @param name The  new name
     * @param id The  new id
     * @param  password new password
     * @throws for the wrong parameter
     */
    public Trader(String name, String id, String password) throws IOException {
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
     * Retrieves the id
     * @return The id
     */
    public String getId() {
        return id;
    }
    /**
     * Sets the name
     * @param name The new name
     */
    public void setName(String name) {
        this.name = name;
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
        return "Trader:   "+ id+"   "+password+"   "+name ;
    }

    /**
     * for the trader to add products
     * @throws Exception If the file is not found
     */
    public void add() throws Exception {
        Scanner myReader = new Scanner(myObj);
        System.out.println("Please enter product id: ");
        String enterid = choice.nextLine();
       // String enterid ="SRTEH2FF9KEDEFGF";
        while(enterid.length() != 16){
            System.out.println("Please enter product id(16 digits): ");
            enterid = choice.nextLine();
        }
        boolean flag = true;
        while (myReader.hasNextLine() && flag) {
            String data = myReader.nextLine();
            String tempdata = data.substring(0,16).trim();
           if(tempdata.equals(enterid)){
                flag = false;
                break;
           }
        }
        FileWriter fileWriter = new FileWriter(output,true);
        if(flag){
            fileWriter.write("\n"+enterid+";");
            System.out.println(" Please enter product name ");
            fileWriter.write(enterid = choice.nextLine()+";");
            System.out.println(" Please enter product price ");
            fileWriter.write(enterid = choice.nextInt()+";");
            System.out.println(" Please enter product discounted_price ");
            fileWriter.write(enterid = choice.nextInt()+";");
            choice.nextLine();
            System.out.println(" Please enter product description ");
            fileWriter.write(enterid = choice.nextLine()+";"+ getName());
            fileWriter.write("\n");
            System.out.println("Product added.");
            fileWriter.close();
        }
        else
            System.out.println("There are products in this product ids.");
    }

    /**
     * for the trader to add products
     * @throws Exception If the file is not found
     */
    public void remove() throws Exception {
        Scanner myReader = new Scanner(myObj);
        System.out.print("Please product id: ");
        String enterid = choice.nextLine();
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
        myObj = new FileInputStream(output);
        FileWriter fileWriter = new FileWriter(tempFile);
        FileInputStream tempobj = new FileInputStream(tempFile);
        int temploop = 0;
        Scanner sc = new Scanner(myObj);
        Scanner sc1 = new Scanner(tempobj);
        while (sc.hasNextLine())
        {
            if(temploop == (count)){
                System.out.println("deleted: "+ sc.nextLine());
            }
            else{
                fileWriter.write(sc.nextLine()+"\n");
            }
            temploop+=1;
        }
        FileWriter fw = new FileWriter(output);
        while (sc1.hasNextLine())
        {
                fw.write(sc1.nextLine()+"\n");
            temploop+=1;
        }
        sc.close();
        sc1.close();
        fileWriter.close();
        tempobj.close();
        fw.close();
        File file = new File(tempFile);
        file.delete();

    }

    /**
     * for the trader to see orders
     */
    public void see(){}
}
