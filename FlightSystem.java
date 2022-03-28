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
     * Constructs a new instance of Flightsystem and intializes the current user based on user type
     * @param uType- user type(guest or registered)
     * @param username- for registered users (username)
     * @param password- for registered users (password)
     */
    public FlightSystem(String uType, String username, String password) {
         flights = Flights.getInstance();
         if (uType.toUpperCase()=="GUEST"){
            currentUser = new GuestUser();
         } else{
             currentUser = users.searchUser(username,password);
         }
         /*
          * if the current user is null this means to the UI that the username or password is incorrect
          */
    }

    /**
     * Searches for all relevant flights using data given from user
     * @param dLoc departure location given by user
     * @param aLoc arrival location given by user
     * @param dDate departure date given by user
     * @param aDate arrival date given by user
     * @return  an arraylist showing all possible flights that fit requirements
     */
    public ArrayList<Flight> getAllFlights (String[] dLoc,String[] aLoc, Date dDate, Date aDate) {
        String dCity = dLoc[0];
        String dState = dLoc[1];
        String aCity = aLoc[0];
        String aState = aLoc[1];
        ArrayList<Flight> temp = flights.searchFlight(dCity, dState, aCity, aState, dDate, aDate);
        return temp;
    }

    public User getCurrentUser (){
        return currentUser;
    }


    public boolean login(){
        return true;
    }
    public boolean logout(){
        // the registered user = current user ( to update any information that is changed )
        // current user = guest 
        String username = currentUser.getUsername();
        String password = currentUser.getPassword();
        User temp =  users.searchUser(username, password);

        return true;
    }

    public void addUser (String firstName, String lastName, String username, String password, String email,Date dob, String address){
        users.addUser(new RegisteredUser(firstName, lastName, username, password, email, dob, address));
    }

    public void editUser(String username,String password, Object edit) {

    }

    public void deleteUser(String username, String password) {
        User deleteMe = users.searchUser(username, password);
        users.deleteUser(deleteMe);
    }

    
}
