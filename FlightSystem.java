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
    public String[] getAllFlights (String[] dLoc,String[] aLoc, Date dDate, Date aDate) {
        String dCity = dLoc[0];
        String dState = dLoc[1];
        String aCity = aLoc[0];
        String aState = aLoc[1];
        ArrayList<Flight> temp = flights.searchFlight(dCity, dState, aCity, aState, dDate, aDate);
        String[]print = toString(temp);
        return print;
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
        //User temp =  users.searchUser(username, password);
        

        return true;
    }

    public void addUser (String firstName, String lastName, String username, String password, String email,Date dob, String address){
        users.addUser(new RegisteredUser(firstName, lastName, username, password, email, dob, address));
    }

    public void editUser(String username,String password, Object edit) {

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

    /**
     * Converts flight results to an array that allows user to see all important booking information as well as ability to select the flight(s) they want
     * @param x- the flight results arraylist
     * @return - Flight results in a string array so that the user can enter which flight(s) they want
     */
    private String[] toString(ArrayList<Flight> x){
        String[] temp = new String[x.size()];
        for(int i = 0; i< x.size();i++){
            if (x.get(i).getConnectionString() != null){
                temp[i]= "Result: "+(i+1)+  "\n Airline: "+x.get(i).getAirline()+
                                        "\n Flight Num : "+x.get(i).getFlightNum()+
                                        "\n Departure Location: "+x.get(i).getDepartCity()+", "+x.get(i).getDepartState()+
                                        "\n Arrival Location: "+x.get(i).getDestinationCity()+ ", "+x.get(i).getDestinationS()+
                                        "\n Flight Duration: "+ x.get(i).getFlightDuration()+
                                        "\n Departure Date and Time: "+ x.get(i).getDepartDate().toString()+ " at "+x.get(i).getDepartTime()+
                                        "\n Arrival Date and Time: "+ x.get(i).getArrivalDate().toString()+ " at "+x.get(i).getArrivalTime()+
                                        "\n Connecting Flight(s) : Result number(s) "+x.get(i).getConnectionString()
                                        +"\n --------------------------------------------------------------------------------------------------------";

            } else{
                temp[i]= "Result: "+(i+1)+  "\n Airline: "+x.get(i).getAirline()+
                                        "\n Flight Num : "+x.get(i).getFlightNum()+
                                        "\n Departure Location: "+x.get(i).getDepartCity()+", "+x.get(i).getDepartState()+
                                        "\n Arrival Location: "+x.get(i).getDestinationCity()+ ", "+x.get(i).getDestinationS()+
                                        "\n Flight Duration: "+ x.get(i).getFlightDuration()+
                                        "\n Departure Date and Time: "+ x.get(i).getDepartDate().toString()+ " at "+x.get(i).getDepartTime()+
                                        "\n Arrival Date and Time: "+ x.get(i).getArrivalDate().toString()+ " at "+x.get(i).getArrivalTime()+
                                        "\n Connecting Flight : NONE"+
                                        "\n ---------------------------------------------------------------------------------------------------------";
            }   
        }
        return temp;
    }
 
    public int seatingSelction(String[] flight){

    }

    
}
    
