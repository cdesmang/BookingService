import java.util.ArrayList;

public abstract class User {
    public String fullName;
    protected String userType;

    protected ArrayList<FilterOptions> filters = new  ArrayList<FilterOptions>();

    /**
     * The user constructor
     */
    public User(String fullName){
        this.fullName = fullName;
    }




    /**
     * Gets the username
     * @return Returns the full name
     */
    public String getFullName(){
        return this.fullName;
    }

    
    /**
     * Gets the type
     * @return Returns the type of user
     */
    public String getType(){
        return this.userType;
    }
}
