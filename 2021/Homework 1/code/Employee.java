
public class Employee implements IUser{
    /**
     * @param name name of employee
     * @param password password of employee
     */
    private  String name ;
    private final String password = "employee";

    /**
     * constructor  for polymorphism
     */

    public Employee() {
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @return password
     */
    @Override
    public String getPassword() {
        return password;
    }
    /**
     * overriding method. print info of  employee
     */
    @Override
    public void info() {
        System.out.println("Name: "+ getName());
    }
}
