import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Tommy Ecker
 */

public class DataWriter extends DataConstants {

    public static void saveFlights() {
        Flights flights = Flights.getInstance();
        ArrayList<Flight> planes = flights.getFlights();
        JSONArray jsonPlanes = new JSONArray();

        // Creates all of the JSON files
        for (int i = 0; i < planes.size(); i++) {
            jsonPlanes.add(getFlightJSON(planes.get(i)));
        }

        // Writes to the JSON file
        try (FileWriter file = new FileWriter(FLIGHT_FILE_NAME)) {

            file.append(jsonPlanes.toJSONString());
            file.flush();
            file.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getFlightJSON(Flight flight) {

        Flights flights = Flights.getInstance();

        ArrayList<Flight> planes = flights.getFlights();

        JSONObject flightDetails = new JSONObject();

        flightDetails.put(FLIGHT_ID, flight.getFlightID());
        flightDetails.put(FLIGHT_NUM, flight.getFlightNum());
        flightDetails.put(AIRLINE, flight.getAirline());
        flightDetails.put(FLIGHT_DURATION, flight.getFlightDuration());
        flightDetails.put(DEPT_TIME, flight.getDepartTime());
        flightDetails.put(ARR_TIME, flight.getArrivalTime());

        JSONObject destinationObject = new JSONObject();
        destinationObject.put(DEST_CITY, flight.getDestinationCity());
        destinationObject.put(DEST_STATE, flight.getDestinationState());

        flightDetails.put(DESTINATION, destinationObject);

        JSONObject departureObject = new JSONObject();
        departureObject.put(DEPT_CITY, flight.getDepartCity());
        departureObject.put(DEPT_STATE, flight.getDepartState());

        flightDetails.put(DEPT_LOC, departureObject);

        JSONArray list = new JSONArray();

        for (int i = 0; i < flight.getSeats().size(); i++) {
            JSONObject seatObject = new JSONObject();
            int seatRow = flight.getSeats().get(i).getRow();
            String seatNum = flight.getSeats().get(i).getSeatNumber();
            Boolean available = flight.getSeats().get(i).getAvailable();

            seatObject.put(SEAT_ROW, seatRow);
            seatObject.put(SEAT_NUM, seatNum);
            seatObject.put(IS_AVAILABLE, available);

            list.add(seatObject);
        }

        flightDetails.put(SEATS, list);

        return flightDetails;
    }
}
