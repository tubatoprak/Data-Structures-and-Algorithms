import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

import java.io.*;

/**
 *  class for menu
 *  the program starts working here
 */
public class Menu  {

    String output = "C:\\Users\\TOPRAK\\Desktop\\hw6\\src\\product.txt";
    String tempFile = "C:\\Users\\TOPRAK\\Desktop\\hw6\\src\\temp.txt";
    String userFile = "C:\\Users\\TOPRAK\\Desktop\\hw6\\src\\users.txt";
    String csvFile = "C:\\Users\\TOPRAK\\Desktop\\hw6\\src\\e-commerce-samples.csv";

    FileInputStream myObj;
    {
        try {
            myObj = new FileInputStream(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Scanner choice = new Scanner(System.in);
    ArrayList<Trader> tradersname = new ArrayList<>();
    LinkedList<Customer> customername = new LinkedList<>();
    Queue<String> orderlist =  new LinkedList<>();

    /**
     * for  menu
     * @throws Exception If the file is not found
     */
    public void menus() throws Exception {
        FileWriter fw = new FileWriter(output); //write to txt
        Scanner sc = new Scanner(new File(csvFile));
        FileWriter usersFile = new FileWriter(userFile); //write to txt
        sc.useDelimiter(",");
        int ids = 0;
        while (sc.hasNext()) // read csv
        {
            if(ids == 0){
                sc.nextLine();
            }else
                fw.write(sc.next());  //write to txt
            ids++;
        }
        sc.close();
        fw.close();
        Scanner myReader = new Scanner(myObj);
        ids = 10000000;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            int flag = 0;
            char comma = ';';
            for (var i = 0; i < data.length(); i++) {
                if (data.charAt(i) == comma){
                    flag ++;
                }
                if(flag == 6){
                    String name = data.substring(i+1).trim();
                    boolean flag2 = true;
                    for (int k = 0; k < tradersname.size(); k++) {
                        String temp = tradersname.get(k).getName();
                        if(temp.equals(name)){
                            flag2 =false;
                        }
                    }
                    if (flag2){
                        tradersname.add(new Trader(name, String.valueOf(ids), String.valueOf(ids)));
                        ids++;
                    }
                    i = data.length();
                }
            }
        }
        myReader.close();
        myObj.close();
        usersFile.write("Users    Id         Password   Trader Name"+"\n");
        for (int i = 0; i < tradersname.size(); i++) {
            usersFile.write(tradersname.get(i).toString()+"\n");
        }
        boolean menus = true;
        while(menus){
            System.out.println("welcome to e-shopping");
            System.out.println("1- Login Trader");
            System.out.println("2- Login Customer");
            System.out.println("3- New Customer");
            System.out.println("4 - Exit Program");
            System.out.print("Please Choice enter: ");
            int  choice1 = choice.nextInt();
            switch (choice1) {
                case 1: {
                    int exit3 = 0;
                    while (exit3 == 0) {
                        System.out.println("--- Login Trader---");
                        System.out.print("Please enter id: ");
                        choice.nextLine();
                       String enterid = choice.nextLine();
                        System.out.print("Please enter Password: ");
                        String enterpassword = choice.nextLine();
                        for (int i = 0; i < tradersname.size(); i++) {
                            if (tradersname.get(i).getId().equals(enterid) && tradersname.get(i).getPassword().equals(enterpassword)) {
                                exit3 = 0;
                                while (exit3 == 0) {
                                    System.out.println("1- Add Product");
                                    System.out.println("2- Remove Product");
                                    System.out.println("4 - Exit Program");
                                    System.out.print("Please Choice enter: ");
                                    int choice2 = choice.nextInt();
                                    if (choice2 == 1)
                                        tradersname.get(i).add();
                                    else if (choice2 == 2) {
                                        tradersname.get(i).remove();

                                    } else if (choice2 == 3) {
                                    } else if (choice2 == 4) {
                                        exit3 = 1;
                                    } else {
                                        System.out.println("incorrect choice ");
                                    }
                                }
                            }
                        }

                    }
                }break;
                case 2: {
                    System.out.println("--- Login Customer---");
                    System.out.print("Please enter id: ");
                    choice.nextLine();
                    String enterid = choice.nextLine();

                    System.out.print("Please enter Password: ");
                    String enterpassword = choice.nextLine();

                    for (int i = 0; i < customername.size(); i++) {
                        if (customername.get(i).getId().equals(enterid) && customername.get(i).getPassword().equals(enterpassword)) {
                            int exit3 = 0;
                            while (exit3 == 0) {
                                System.out.println("1- order Product");
                                System.out.println("2- Search Product");
                                System.out.println("3 - Exit Program");
                                System.out.print("Please Choice enter: ");
                                int choice2 = choice.nextInt();
                                if (choice2 == 1) {
                                    customername.get(i).order();
                                } else if (choice2 == 2) {
                                } else if (choice2 == 3) {
                                    exit3 = 1;
                                } else {
                                    System.out.println("incorrect choice ");
                                }
                            }
                            i = tradersname.size();
                        }
                    }
                }break;
                case 3: {
                    System.out.println("Please enter customer name");
                    choice.nextLine();
                    String name = choice.nextLine();
                    System.out.println("Please enter customer password");
                    String pass = choice.nextLine();
                    customername.add(new Customer(name, String.valueOf(ids),pass));
                    usersFile.write(customername.get(customername.size()-1).
                            toString()+"\n");
                    System.out.println("Your user id: "+ ids);
                    ids++;
                }break;
                case 4: {
                        menus = false;
                }break;
                default:
                    System.out.println("İncorrect Choice: ");
            }
        }
        usersFile.close();
    }

}
