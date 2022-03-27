import java.lang.reflect.Array;
import java.util.ArrayList;

public class FlightSystem {
    private static User currentUser;
    private static Flights flights;
    private Users users= new Users();

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

    public static ArrayList<Flight> getAllFlights (Location dLoc,Location aLoc, Date dDate, Date aDate) {
        ArrayList<Flight> temp;
        return temp;
    }

   /* public ArrayList<Flight>searchFlights (ArrayList<Flight> broad){
        ArrayList<Flight> temp = new ArrayList<Flight>();
        return temp;
    }*/

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

    public void addUser (){

    }

    public void editUser() {

    }

    public void deleteUser() {
        
    }

    
}
