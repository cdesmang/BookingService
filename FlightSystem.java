import java.lang.reflect.Array;
import java.util.ArrayList;

public class FlightSystem {
    private User currentUser;
    private Flights flights = new FlightSystem();

    public FlightSystem() {
        
    }
    public static ArrayList<Flight> getAllFlights (Location dLoc,Location aLoc, Date dDate, Date aDate) {
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
