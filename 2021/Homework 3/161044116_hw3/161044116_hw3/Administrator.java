/**
 * administrator class for admin
 */
public class Administrator implements IUser {
    /**
     *
     * @param name name of admin
     * @param password password of admin
     */
    private String name = "admin";
    private String password = "admin";

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
     * @return pasword
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * overriding method. print info of  admin
     */
    @Override
    public void info() {System.out.println("Name: "+ getName());
    }
    /**
     * to add branch
     */
    protected void addBranch(KWSingleLinkedList<Branch> store, int Branches){
        store.add(new Branch());
        store.get(Branches).fillCompany();
    }
    /**
     * to remove branch
     */
    protected void removeBranch(KWSingleLinkedList<Branch> store, int index){
        store.remove(index);
    }
    /**
     * to add employees to stores
     */
    public void addBranchEmployee(KWSingleLinkedList<Branch> store, int index){
        store.get(index).addEmployee();
    }
    /**
     * to remove employees to stores
     */
    public void  removeBranchEmployee(KWSingleLinkedList<Branch> store, int index){
        store.get(index-1).deleteEmploye();
    }
    /**
     * to look at the employees in the selected branch
     */
    public void lookemployee(KWSingleLinkedList<Branch> store, int choicestore){
        store.get(choicestore-1).printemployee();
    }
}

