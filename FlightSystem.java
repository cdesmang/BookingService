/**
 * Allows interaction between UI and backend classes
 * @author Christina Desmangles
 */
import java.util.ArrayList;

public class FlightSystem {
    private static User currentUser;
    private static Flights flights;
    private static Users users= new Users();

    public FlightSystem(String uType, String username, String password) {
         flights = Flights.getInstance();
         if (uType.toUpperCase()=="GUEST"){
            currentUser = new GuestUser();
         } else{
             currentUser = users.searchUser(username,password);
         }
         /* IF THE CURRENT USER = NULL THEN IN THE UI THERE SHOULD BE A PRINT STATEMENT SAYING THAT THE USERNAME
            OR PASSWORD IS INCORRECT
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
