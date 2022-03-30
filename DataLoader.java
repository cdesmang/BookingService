import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Iterator;

/**
 * @author Tommy Ecker
 */

public class DataLoader extends DataConstants {

    public static ArrayList<Flight> loadFlights() {
        ArrayList<Flight> flights = new ArrayList<Flight>();

        try {
            FileReader reader = new FileReader(FLIGHT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray flightsJSON = (JSONArray)parser.parse(reader);

            for(int i = 0; i < flightsJSON.size(); i++) {
                JSONObject flightJSON = (JSONObject)flightsJSON.get(i);
                String id = (String)flightJSON.get(FLIGHT_ID);
                String flightNumber = (String)flightJSON.get(FLIGHT_NUM);
                String airline = (String)flightJSON.get(AIRLINE);
               
                JSONObject jsonDestination = (JSONObject)flightJSON.get("destination");
                String destinationCity = (String)jsonDestination.get("City");
                String destinationState = (String)jsonDestination.get("State");
                
                JSONObject jsonDeparture = (JSONObject)flightJSON.get("departLocation");
                String departureCity = (String)jsonDeparture.get("City");
                String departureState = (String)jsonDeparture.get("State");

                JSONObject jsonDeptDate = (JSONObject)flightJSON.get("departureDate");
                String deptWeekday = (String)jsonDeptDate.get("day_of_week");
                String deptMonth = (String)jsonDeptDate.get("month");
                String deptDay = (String)jsonDeptDate.get("day");
                String deptYear = (String)jsonDeptDate.get("year");

                Date deptDate = new Date(deptWeekday, deptMonth, deptDay, deptYear);


                JSONObject jsonArrivalDate = (JSONObject)flightJSON.get("arrivalDate");
                String arrWeekday = (String)jsonArrivalDate.get("day_of_week");
                String arrMonth = (String)jsonArrivalDate.get("month");
                String arrDay = (String)jsonArrivalDate.get("day");
                String arrYear = (String)jsonArrivalDate.get("year");

                Date arrDate = new Date(arrWeekday, arrMonth, arrDay, arrYear);
                
                String duration = (String)flightJSON.get(FLIGHT_DURATION);
                String deptTime = (String)flightJSON.get(DEPT_TIME);
                String arrTime = (String)flightJSON.get(ARR_TIME);

                          


               ArrayList<Seat> seatsList = new ArrayList<Seat>();

                JSONArray jsonSeats = (JSONArray)flightJSON.get("seats");
                for (int j = 0; j < jsonSeats.size(); j++) {
                    JSONObject jsonSeat = (JSONObject) jsonSeats.get(j);
                    int jsonSeatRow = ((Long)jsonSeat.get("row")).intValue();
                    String jsonSeatNum = (String)jsonSeat.get("seatNum");
                    Boolean isAvailable = ((Boolean)jsonSeat.get("available")).booleanValue();

                    Seat newSeat = new Seat(jsonSeatRow, jsonSeatNum, isAvailable);
                    seatsList.add(newSeat);

                }

                //Location dest = new Location(destinationCity, destinationState);
                //Location dept = new Location(departureCity, departureState);

               // System.out.println("Destination: " + l.getCity() + ", " + l.getState());
                //Flight f = new Flight(id, flightNumber, airline, l.getCity(), l.getState(), duration, deptTime, arrTime);


                flights.add(new Flight(id, flightNumber, airline, destinationCity, destinationState, departureCity, departureState, deptDate, arrDate, duration, deptTime, arrTime, seatsList));
            }


            return flights;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /*
    public static ArrayList<Users> loadUsers() {

    }
    
    public static ArrayList<Hotels> hotels() {

    } */
}
