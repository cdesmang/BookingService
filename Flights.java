public class Flights {

    private static ArrayList<Flight> flights;

    private Flights()
    {
        this.flights = new ArrayList<Flight>();

    }
    public static Flights getInstance()
    {
        if(flights == null)
        {
            flights = new Flight();
        }
        return flights;
    }
    
}
