import java.lang.reflect.Array;
import java.util.ArrayList;

public class FlightSystem {
    private User currentUser;
    private static FlightSystem flightSystem;;

    public FlightSystem() {}

    /**
     * checks if an instance of Flight system exists, if not create a new one
     * @return an instance (the only one in existance) of FlightSystem
     */
    public static FlightSystem getInstance(){
        if (flightSystem == null)
            flightSystem= new FlightSystem();
        return flightSystem;
    }

    public static ArrayList<Flight> getAllFlights (Location dLoc,Location aLoc, Date dDate, Date aDate) {
        ArrayList<Flight> temp = new ArrayList<Flight>();
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
