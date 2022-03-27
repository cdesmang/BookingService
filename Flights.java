/**
 * Everything having to do with flights
 * @author Christina Desmangles
 */
import java.util.ArrayList;
public class Flights {

    private static ArrayList<Flight> flights;
    private static DataLoader DL = new DataLoader();

    private Flights(){}
    /**
     * accesses Data loader to get ALL of the flights 
     * @return an array list holding all flights
     */
    public static ArrayList<Flight> getInstance()
    {
        if(flights == null)
        {
            flights = DL.getAllFlights();
        }
        return flights;
    }

    public static ArrayList<Flight> searchFlight(String dCity, String dState, String aCity, String aState, Date dDate, Date aDate){
        int i = 0;
        ArrayList<Flight> temp = new ArrayList<Flight>();
        while(flights.get(i) != null){
            if (checkDL(dCity,dState,i) && checkAL(aCity, aState, i) && checkDD(dDate, i) && checkAD(aDate, i)){
                temp.add(flights.get(i));
                i++;
            }
        }
        return temp;
    }

    private static boolean checkDL(String city, String state,int i){
        return flights.get(i).getDepartCity().toUpperCase() == city.toUpperCase() && flights.get(i).getDepartState().toUpperCase() == state.toUpperCase();
    }

    private static boolean checkAL(String city, String state,int i){
        return flights.get(i).getDestinationCity().toUpperCase() == city.toUpperCase() && flights.get(i).getDestinationS().toUpperCase() == state.toUpperCase();
    }

    private static boolean checkDD(Date date, int i){
        return flights.get(i).getDepartDate() == date;
    }

    private static boolean checkAD(Date date, int i){
        return flights.get(i).getArrivalDate() == date;
    }
    
}
