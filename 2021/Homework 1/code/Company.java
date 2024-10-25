import java.util.Scanner;

public class Company {
    /**
     * @param  input of user
     *  @param  ChairsModel number of chair model
     * @param  DeskModel number of chair model
     * @param  MeetingTModel number of Meeting Model
     * @param  BookCasesModel number of BookCases Model
     * @param  CabinetModel number of CabinetModel
     * @param choice2 To get string type input from the user
     * @param inputcolor input furniture color from the user
     * @param color to know the colors of the products
     * @param models to know the models of the products
     */
    String[] color = {"Walnut", "White", "Acacia", "Black", "Oak",};
    String[] models = {"1", "2", "3", "4", "5", "6", "7","8","9","10","11","12"};
    Scanner myObj = new Scanner(System.in);
    String  inputcolor ="";
    int input= 0;
    int ChairsModel = 7;
    int DeskModel = 5;
    int MeetingTModel = 10;
    int BookCasesModel = 12;
    int CabinetModel = 12;
    String choice2 ="";
    /**
     * @param  chairProduct allocates space for chair-product storage in memory
     * @param  DeskProduct  allocates space for desk-product storage in memory
     * @param   MeetingTProduct allocates space for meeting table-product storage in memory
     * @param   BookCasesProduct allocates space for bookcases-product storage in memory
     * @param   CabinetProduct allocates space for office cabinet-product storage in memory
     * @param   employee to store branch employees
     * @param   numberofemployees number of employees working in branch
     *
     */
    String[][] chairProduct = new String[50][2];
    String[][] DeskProduct = new String[50][2];
    String[][] MeetingTProduct = new String[50][2];
    String[] BookCasesProduct = new String[20];
    String[] CabinetProduct = new String[20];
    Employee[] employee = new Employee[10];
    int numberofemployees = 0;

    /**
     * addEmployee() This method is to add employees to branches
     * After entering the name of the employee, it records it in the system.
     */
    public  void addEmployee(){
        System.out.print("Please enter Employee name: ");
        choice2 = myObj.nextLine();
        employee[numberofemployees] = new Employee();
        this.employee[numberofemployees].setName(choice2);
        System.out.println("Process Completed.Employee added to branch");
        numberofemployees += 1;
    }
    /**
     *  to print the employee in the branch
     */
    public void printemployee(){
        for (int i = 0; i < numberofemployees; i++) {
            System.out.println(i+1 +" "+ employee[i].getName());
        }
    }
    /**
     *   to delete the employee in the branch
     */
    public void deleteEmploye(){
        System.out.print("Please enter Employee name: ");
        choice2 = myObj.nextLine();
        for (int i = 0; i < numberofemployees; i++) {
            if(employee[i].getName().equals(choice2)) {
                System.out.println("Process Completed.Employee delete to branch");
                numberofemployees -=1;
            }

        }
    }
    /**
     *  to place products in branch
     *  fills product arrays. branches start with this full.
     */
    public void fillCompany() {
        int temp = -1;
        for (int i = 0,j = 0; i < 35; i++,j++) {
            if((i % 7) == 0) {
                temp += 1;
                j= 0;
            }
            this.chairProduct[i][0] = color[temp];
            this.chairProduct[i][1] = this.models[j];
        }
        temp = -1;
        for (int i = 0,j = 0; i < 20; i++,j++) {
            if((i % 5) == 0) {
                temp += 1;
                j= 0;
            }
            this.DeskProduct[i][0] = color[temp];
            this.DeskProduct[i][1] = this.models[j];
        }
        temp = -1;
        for (int i = 0,j = 0; i < 40; i++,j++) {
            if((i % 10) == 0) {
                temp += 1;
                j= 0;
            }
            this.MeetingTProduct[i][0] = color[temp];
            this.MeetingTProduct[i][1] = this.models[j];
        }
        if (BookCasesModel >= 0) System.arraycopy(this.models, 0, this.BookCasesProduct, 0, BookCasesModel);
        if (CabinetModel >= 0) System.arraycopy(this.models, 0, this.CabinetProduct, 0, CabinetModel);
    }
    /**
     * overrring method
     */
    public void menu() {}
    /**
     *  to print the chair in the branch
     */
    public void chairprint(){
        System.out.println("--Chairs in stock--");
        for (int i = 0; i < this.chairProduct.length; i++){
            if (chairProduct[i][0] != null) {
                System.out.println(i+1+"-)" + this.chairProduct[i][0]+ " color " + this.chairProduct[i][1]+ ".Model Chair  ");
            }
        }
    }
    /**
     * to print the desk in the branch
     */
    public void deskPrint(){
        System.out.println("--Desk in stock--");
        for (int i = 0; i < this.DeskProduct.length; i++){
            if (DeskProduct[i][0] != null) {
                System.out.println(i+1+"-)" + this.DeskProduct[i][0]+ " color " + this.DeskProduct[i][1]+ ".Model Desk ");
            }
        }}
    /**
     * to print the meeting tables in the branch
     */
    public void meetingTprint(){
        System.out.println("--Meeting Tables in stock--");
        for (int i = 0; i <  this.MeetingTProduct.length; i++) {
            if (MeetingTProduct[i][1] != null) {
                System.out.println(i+1+"-)" + this.MeetingTProduct[i][0] + " color " + this.MeetingTProduct[i][1] + ".Model Meeting Table ");
            }
        }
    }
    public void bookcasesprint(){
        System.out.println("--Bookcases in stock--");
        for (int i = 0; i < this.BookCasesProduct.length; i++) {
            if (BookCasesProduct[i] != null) {
                System.out.println(i+1+"-)" + this.BookCasesProduct[i] + ".Model BookCase ");
            }
        }
    }
    /**
     * to print the office cabinet in the branch
     */
    public void cabinetsprint(){
        System.out.println("-- Office Cabinet in stock--");
        for (int i = 0; i < this.CabinetProduct.length; i++) {
            if (CabinetProduct[i] != null) {
                System.out.println(i+1+"-)" + this.CabinetProduct[i] + ".Model Office Cabinet ");
            }
        }}
    /**
     *   to delete the chair product in the branch
     */
    public void deleteChairproduct(int index) {
        for (int i = index; i < chairProduct.length - 1; i++) {
            chairProduct[i][0] = chairProduct[i + 1][0];
            chairProduct[i][1] = chairProduct[i + 1][1];
        }
    }
    /**
     *  to add the chair product in the branch
     */
    public void addChairproduct() {
        for (int i = 0; i < chairProduct.length; i++) {
            if (chairProduct[i][0] == null) {
                System.out.print("Please Enter color: ");
                inputcolor = myObj.nextLine();
                while (!inputcolor.equals("Walnut")&&  !inputcolor.equals("White") && !inputcolor.equals("Acacia")&& !inputcolor.equals("Black") &&  !inputcolor.equals("Oak")) {
                    System.out.print("Error..Please re-enter color (Walnut,Oak,White,Acacia,Black): ");
                    inputcolor = myObj.nextLine();
                }
                this.chairProduct[i][0] = inputcolor;
                System.out.print("Please Enter model number: ");
                input = myObj.nextInt();
                while (input > ChairsModel) {
                    System.out.print("Error..Please re-enter model number(1-7): ");
                    input = myObj.nextInt();
                }
                this.chairProduct[i][1] = this.models[input-1];
                i = chairProduct.length;
            }
        }
        System.out.println("---New Stok---");
        chairprint();
    }
    /**
     *  to delete the desk product in the branch
     */
    public void deleteDeskproduct(int index){
        for (int i = index; i < DeskProduct.length-1; i++) {
            DeskProduct[i][0] = DeskProduct[i+1][0];
            DeskProduct[i][1] = DeskProduct[i+1][1];
        }
    }
    /**
     * to add the desk product in the branch
     */
    public void addDeskproduct(){
        for (int i = 0; i < DeskProduct.length; i++) {
            if (DeskProduct[i][0] == null) {
                System.out.print("Please Enter color: ");
                inputcolor = myObj.nextLine();
                while (!inputcolor.equals("Walnut")&&  !inputcolor.equals("White") && !inputcolor.equals("Acacia")&& !inputcolor.equals("Black")) {
                    System.out.print("Error..Please re-enter color (Walnut,White,Acacia,Black): ");
                    inputcolor = myObj.nextLine();
                }
                this.DeskProduct[i][0] = inputcolor;
                System.out.print("Please Enter model number: ");
                input = myObj.nextInt();
                while (input > DeskModel) {
                    System.out.print("Error..Please re-enter model number(1-5): ");
                    input = myObj.nextInt();
                }
                this.DeskProduct[i][1] = this.models[input-1];
                i = DeskProduct.length;
            }
        }
        System.out.println("---New Stok---");
        deskPrint();
    }
    /**
     * to delete the meeting table product in the branch
     */
    public void deleteMeetingTproduct(int index){
        for (int i = index; i < MeetingTProduct.length-1; i++) {
            MeetingTProduct[i][0] = MeetingTProduct[i+1][0];
            MeetingTProduct[i][1] = MeetingTProduct[i+1][1];
        }
    }
    /**
     *  to ADD the meeting table product in the branch
     */
    public void addMeetingTproduct(){
        for (int i = 0; i < MeetingTProduct.length; i++) {
            if (MeetingTProduct[i][0] == null) {
                System.out.print("Please Enter color: ");
                myObj.nextLine();
                inputcolor = myObj.nextLine();
                while (!inputcolor.equals("Walnut")&&  !inputcolor.equals("White") && !inputcolor.equals("Acacia")&& !inputcolor.equals("Black")) {
                    System.out.print("Error..Please re-enter color (Walnut,White,Acacia,Black): ");
                    inputcolor = myObj.nextLine();
                }
                this.MeetingTProduct[i][0] = inputcolor;
                System.out.print("Please Enter model number: ");
                input = myObj.nextInt();
                while (input > MeetingTModel) {
                    System.out.print("Error..Please re-enter model number(1-5): ");
                    input = myObj.nextInt();
                }
                this.MeetingTProduct[i][1] = this.models[input-1];
                i = MeetingTProduct.length;
            }
        }
        System.out.println("---New Stok---");
        meetingTprint();

    }
    /**
     * to delete the bookcase product in the branch
     */
    public void deleteBookCasesproduct(int index){
        if (BookCasesProduct.length - 1 - index >= 0)
            System.arraycopy(BookCasesProduct, index + 1, BookCasesProduct, index, BookCasesProduct.length - 1 - index);
    }
    /**
     *  to add the bookcase product in the branch
     */
    public void addbookCasesproduct(){
        for (int i = 0; i < BookCasesProduct.length; i++) {
            if (BookCasesProduct[i] == null) {
                System.out.print("Please Enter model number: ");
                input = myObj.nextInt();
                while (input > BookCasesModel) {
                    System.out.print("Error..Please re-enter model number(1-12): ");
                    input = myObj.nextInt();
                }
                this.BookCasesProduct[i] = this.models[input - 1];
                i = BookCasesProduct.length;
            }
        }
    }
    /**
     *  to delete the office cabinet product in the branch
     */
    public void deleteCabinetproduct(int index){
        if (CabinetProduct.length - 1 - index >= 0)
            System.arraycopy(CabinetProduct, index + 1, CabinetProduct, index, CabinetProduct.length - 1 - index);
    }
    /**
     *  to add the office cabinet product in the branch
     */
    public void addCabineproduct(){
        for (int i = 0; i < CabinetProduct.length; i++) {
            if (CabinetProduct[i] == null) {
                System.out.print("Please Enter model number: ");
                input = myObj.nextInt();
                while (input > CabinetModel) {
                    System.out.print("Error..Please re-enter model number(1-12): ");
                    input = myObj.nextInt();
                }
                this.CabinetProduct[i] = this.models[input - 1];
                i = CabinetProduct.length;
            }
        }

    }

}

