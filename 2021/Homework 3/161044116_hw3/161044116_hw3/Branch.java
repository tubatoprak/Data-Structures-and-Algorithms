import java.util.Scanner;

/**
 * branch class  to create a branch object
 */
public class Branch {
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

    HybridList<String> color = new HybridList<>();
    HybridList<String> models = new HybridList<>();
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
     *
     */
    HybridList<String> chairProduct = new HybridList<>();
    HybridList<String> DeskProduct = new HybridList<>();
    HybridList<String> MeetingTProduct = new HybridList<>();
    HybridList<String> BookCasesProduct = new HybridList<>();
    HybridList<String> CabinetProduct = new HybridList<>();
    KWArrayList<Employee> employee = new KWArrayList<>();

    /**
     * addEmployee() This method is to add employees to branches
     * After entering the name of the employee, it records it in the system.
     */
    public  void addEmployee(){
        System.out.print("Please enter Employee name: ");
        choice2 = myObj.nextLine();
        employee.add(new Employee());
        this.employee.get(employee.size()-1).setName(choice2);
        System.out.println("Process Completed.Employee added to branch");
    }
    /**
     *  to print the employee in the branch
     */
    public void printemployee(){
        for (int i = 0; i < employee.size(); i++) {
            System.out.println(i+1 +".employee "+ employee.get(i).getName());
        }
    }
    /**
     *   to delete the employee in the branch
     */
    public void deleteEmploye(){
        System.out.print("Please enter Employee name: ");
        choice2 = myObj.nextLine();
        for (int i = 0; i < employee.size(); i++) {
            if(employee.get(i).getName().equals(choice2)) {
               employee.remove(i);
            }

        }
    }
    /**
     *  to place products in branch
     *  fills product arrays. branches start with this full.
     */
    public void fillCompany() {

        color.add("Walnut",null);
        color.add("White",null);
        color.add("Acacia",null);
        color.add("Black",null);
        color.add("Oak",null);

        for (int i = 0; i < 13; i++) {
            models.add(null,String.valueOf(i+1));
        }

        int temp = -1;
        for (int i = 0,j = 0; i < 35; i++,j++) {
            if((i % 7) == 0) {
                temp += 1;
                j= 0;
            }
            this.chairProduct.add(color.getcolor(temp),models.getmodel(j));
        }
        temp = -1;
        for (int i = 0,j = 0; i < 20; i++,j++) {
            if((i % 5) == 0) {
                temp += 1;
                j= 0;
            }
            this.DeskProduct.add(color.getcolor(temp),models.getmodel(j));
        }
        temp = -1;
        for (int i = 0,j = 0; i < 40; i++,j++) {
            if((i % 10) == 0) {
                temp += 1;
                j= 0;
            }
            this.MeetingTProduct.add(color.getcolor(temp),models.getmodel(j));
        }

        if (BookCasesModel >= 0){
            for (int i = 0; i < BookCasesModel; i++) {
                this.BookCasesProduct.add(null,models.getmodel(i));
            }
        }
        if (CabinetModel >= 0) {
            for (int i = 0; i < CabinetModel; i++) {
                this.CabinetProduct.add(null,models.getmodel(i));
            }
        }
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
        for (int i = 0; i < this.chairProduct.getSize(); i++){
            System.out.println(i+1+"-)" + this.chairProduct.getcolor(i)+ " color " + this.chairProduct.getmodel(i)+ ".Model Chair  ");
        }
    }
    /**
     * to print the desk in the branch
     */
    public void deskPrint(){
        System.out.println("--Desk in stock--");
        for (int i = 0; i < this.DeskProduct.getSize(); i++){
            System.out.println(i+1+"-)" + this.DeskProduct.getcolor(i)+ " color " + this.DeskProduct.getmodel(i)+ ".Model Desk ");
        }}
    /**
     * to print the meeting tables in the branch
     */
    public void meetingTprint(){
        System.out.println("--Meeting Tables in stock--");
        for (int i = 0; i <  this.MeetingTProduct.getSize(); i++) {
            System.out.println(i+1+"-)" + this.MeetingTProduct.getcolor(i) + " color " + this.MeetingTProduct.getmodel(i) + ".Model Meeting Table ");
        }
    }/**
     * to print the bookcases in the branch
     */
    public void bookcasesprint(){
        System.out.println("--Bookcases in stock--");
        for (int i = 0; i < this.BookCasesProduct.getSize(); i++) {
            System.out.println(i+1+"-)" + this.BookCasesProduct.getmodel(i) + ".Model BookCase ");
        }
    }
    /**
     * to print the office cabinet in the branch
     */
    public void cabinetsprint(){
        System.out.println("-- Office Cabinet in stock--");
        for (int i = 0; i < this.CabinetProduct.getSize(); i++) {
                System.out.println(i+1+"-)" + this.CabinetProduct.getmodel(i) + ".Model Office Cabinet ");
        }}
    /**
     *   to delete the chair product in the branch
     */
    public void deleteChairproduct(int index) {
        chairProduct.remove(index);
    }
    /**
     *  to add the chair product in the branch
     */
    public void addChairproduct() {
        System.out.print("Please Enter color: ");
        inputcolor = myObj.nextLine();
        while (!inputcolor.equals("Walnut")&&  !inputcolor.equals("White") && !inputcolor.equals("Acacia")&& !inputcolor.equals("Black") &&  !inputcolor.equals("Oak")) {
            System.out.print("Error..Please re-enter color (Walnut,Oak,White,Acacia,Black): ");
            inputcolor = myObj.nextLine();
        }
        System.out.print("Please Enter model number: ");
        input = myObj.nextInt();
        while (input > ChairsModel) {
            System.out.print("Error..Please re-enter model number(1-7): ");
            input = myObj.nextInt();
        }
        chairProduct.add(inputcolor, models.getmodel(input-1));
        System.out.println("---New Stok---");
        chairprint();
    }
    /**
     *  to delete the desk product in the branch
     */
    public void deleteDeskproduct(int index){
        DeskProduct.remove(index);
    }
    /**
     * to add the desk product in the branch
     */
    public void addDeskproduct(){
        System.out.print("Please Enter color: ");
        inputcolor = myObj.nextLine();
        while (!inputcolor.equals("Walnut")&&  !inputcolor.equals("White") && !inputcolor.equals("Acacia")&& !inputcolor.equals("Black")) {
            System.out.print("Error..Please re-enter color (Walnut,White,Acacia,Black): ");
            inputcolor = myObj.nextLine();
        }
        System.out.print("Please Enter model number: ");
        input = myObj.nextInt();
        while (input > DeskModel) {
            System.out.print("Error..Please re-enter model number(1-5): ");
            input = myObj.nextInt();
        }
        DeskProduct.add(inputcolor, models.getmodel(input-1));
        System.out.println("---New Stok---");
        deskPrint();
    }
    /**
     * to delete the meeting table product in the branch
     */
    public void deleteMeetingTproduct(int index){
        MeetingTProduct.remove(index);
    }
    /**
     *  to ADD the meeting table product in the branch
     */
    public void addMeetingTproduct(){
        System.out.print("Please Enter color: ");
        myObj.nextLine();
        inputcolor = myObj.nextLine();
        while (!inputcolor.equals("Walnut")&&  !inputcolor.equals("White") && !inputcolor.equals("Acacia")&& !inputcolor.equals("Black")) {
            System.out.print("Error..Please re-enter color (Walnut,White,Acacia,Black): ");
            inputcolor = myObj.nextLine();
        }
        System.out.print("Please Enter model number: ");
        input = myObj.nextInt();
        while (input > MeetingTModel) {
            System.out.print("Error..Please re-enter model number(1-5): ");
            input = myObj.nextInt();
        }
        MeetingTProduct.add(inputcolor, models.getmodel(input-1));
        System.out.println("---New Stok---");
        meetingTprint();

    }
    /**
     * to delete the bookcase product in the branch
     */
    public void deleteBookCasesproduct(int index){
        BookCasesProduct.remove(index);
    }
    /**
     *  to add the bookcase product in the branch
     */
    public void addbookCasesproduct(){
        System.out.print("Please Enter model number: ");
        input = myObj.nextInt();
        while (input > BookCasesModel) {
            System.out.print("Error..Please re-enter model number(1-12): ");
            input = myObj.nextInt();
        }
        BookCasesProduct.add(null, models.getmodel(input-1));
        System.out.println("---New Stok---");
        bookcasesprint();
    }
    /**
     *  to delete the office cabinet product in the branch
     */
    public void deleteCabinetproduct(int index){
      CabinetProduct.remove(index);
    }
    /**
     *  to add the office cabinet product in the branch
     */
    public void addCabineproduct(){
        System.out.print("Please Enter model number: ");
        input = myObj.nextInt();
        while (input > CabinetModel) {
            System.out.print("Error..Please re-enter model number(1-12): ");
            input = myObj.nextInt();
        }
        CabinetProduct.add(null,models.getmodel(input-1));
        System.out.println("---New Stok---");
        cabinetsprint();
    }
}

