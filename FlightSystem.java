import java.lang.reflect.Array;
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

    public void addUser (){

    }

    public void editUser() {

    }

    public void deleteUser() {
        
    }

    
}
