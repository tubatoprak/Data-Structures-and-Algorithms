
public class Administrator implements IUser {
    /**
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
}

