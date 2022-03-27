/**
 * creates an array list of all flights
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
    
}
