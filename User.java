import java.util.ArrayList;

public abstract class User {
    protected String userType; // "registered" or "guest"
    protected ArrayList<FilterOptions> filters = new  ArrayList<FilterOptions>();

    /**
     * The user constructor
     */
    public User(){}


    
    /**
     * @param filter to be added to the fliters arrayList
     */
    public void addFilter(FilterOptions filter){
        filters.add(filter) ;
    }

    /**
     * @param filter to be removed to the fliters arrayList
     */
    public void removeFilter(FilterOptions filter){
        filters.remove(filter) ;
    }


    /**
     * Gets the type
     * @return Returns the type of user
     */
    public void filterResults(){
        return;
    }
    
    
    /**
     * Gets the type
     * @return Returns the type of user
     */
    public String getType(){
        return this.userType;
    }
}
