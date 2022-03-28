/**
 * Allows interaction between UI and backend classes
 * @author Christina Desmangles
 */
import java.util.ArrayList;

public class FlightSystem {
    private static User currentUser;
    private static Flights flights;
    private static Users users= new Users();

    /**
     * Constructs a new instance of Flightsystem and intializes the current user based on user type (overloaded for different types)
     */
    public FlightSystem(){
        flights = Flights.getInstance();
        currentUser =new GuestUser();
    }
    /**
     * Overloaded constructor version for registered users
     * @param username- registered account username
     * @param password- registered account password
     */
    public FlightSystem (String username, String password){
        flights = Flights.getInstance();
        currentUser= users.searchUser(username, password);
    }
    /**
     * overloaded constructor version for new account creation
     * @param firstName- users first name
     * @param lastName users last name
     * @param username- chosen username
     * @param password - chosen password
     * @param email- users email address
     * @param dob- users email address
     * @param address- users street address
     */
    public FlightSystem(String firstName, String lastName, String username, String password, String email, Date dob, String address) {
         flights = Flights.getInstance();
         currentUser = new RegisteredUser(firstName, lastName, username, password, email, dob, address);
    }

    /**
     * Searches for all relevant flights using data given from user
     * @param dLoc departure location given by user
     * @param aLoc arrival location given by user
     * @param dDate departure date given by user
     * @param aDate arrival date given by user
     * @return  an arraylist showing all possible flights that fit requirements
     */
    public String[] getAllFlights (String[] dLoc,String[] aLoc, Date dDate, Date aDate) {
        String dCity = dLoc[0];
        String dState = dLoc[1];
        String aCity = aLoc[0];
        String aState = aLoc[1];
        ArrayList<Flight> temp = flights.searchFlight(dCity, dState, aCity, aState, dDate, aDate);
        String[]print = toString(temp);
        return print;
    }

     /** Converts flight results to an array that allows user to see all important booking information as well as ability to select the flight(s) they want
     *  @param x- the flight results arraylist
     * @return - Flight results in a string array so that the user can enter which flight(s) they want
     */
    private String[] toString(ArrayList<Flight> x){
        String[] temp= new String[x.size()];
        for (int i = 0; i< x.size(); i++){
            temp[i] = x.get(i).toString();
        }
        return temp;
    }
 
    public int seatingSelction(String[] flight){
        int temp = 0;
        return temp;
    }

    
    public boolean login(){
        return true;
    }
    public boolean logout(){
        // the registered user = current user ( to update any information that is changed )
        // current user = guest 
        String username = currentUser.getUsername();
        String password = currentUser.getPassword();
        //User temp =  users.searchUser(username, password);
        

        return true;
    }

    public User getCurrentUser (){
        return currentUser;
    }

    public void editUser(String username,String password, Object edit) {

    }
      // Overloaded method allows you to add a user by creating a user or by entering an already existing user
    public void addUser(RegisteredUser user){
        users.addUser(user);
            // this version is for when they opt to create an account
    }
    public void addUser (String firstName, String lastName, String username, String password, String email, String address, Date dob){
        users.addUser(new RegisteredUser(firstName, lastName, username, password, email, address, dob));
            // this version is for when they are a guest and want to book
    }

    /**
     * removes users from the database if they decide to delete their accoutn
     * @param - username = account to be deleted username
     * @param - username = account to be deleted password
     */
    public boolean deleteUser(String username, String password) {
        boolean working= true;
        User deleteMe = users.searchUser(username, password);
        if (deleteMe == null) working = false;  
        users.deleteUser(deleteMe);
        return working;
    }



}
    
