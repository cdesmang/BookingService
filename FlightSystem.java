import java.lang.reflect.Array;
import java.util.ArrayList;

public class FlightSystem {
    private User currentUser;
    private Flights flights;

    public FlightSystem() {
        
    }
    public ArrayList<Flight> getAllFlights (String dLoc, String aLoc, Date dDate, Date aDate) {
        ArrayList<Flight> temp = flights.getInstance();
        return temp;
    }

    public ArrayList<Flight>searchFlights (ArrayList<Flight> broad){
        ArrayList<Flight> temp = new ArrayList<Flight>();
        return temp;
    }

    public User getCurrentUser (){
        return currentUser;
    }


    public boolean login(){
        return true;
    }

    public void addUser (){

    }

    public void editUser() {

    }

    public void deleteUser() {
        
    }

    
}
