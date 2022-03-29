/**
 * Allows interaction between UI and backend classes
 * @author Christina Desmangles
 */
import java.util.ArrayList;

public class FlightSystem {
    private User currentUser;

    public ArrayList<Flight> getAllFlights () {
        ArrayList<Flight> temp = Flights.getInstance();
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
