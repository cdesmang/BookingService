import java.util.ArrayList;
import java.util.UUID;


public class Booking {
    private String booker_username; // this booking goes into this user's bookings list
    private String customer_username; // this booking is for this customer
    private ArrayList<Flight> journey;
    private ArrayList<Hotel> reservations;

    private UUID flightID; // used for JSON file
    private String seat; // used for JSON file


    public Booking(String booker_username, String customer_username, ArrayList<Flight> journey, ArrayList<Hotel> reservations) {
        this.booker_username = booker_username;
        this.customer_username = customer_username;
        this.journey = journey;
        this.reservations = reservations;
    }

    public Booking(UUID flightID, String seat) {
        this.flightID = flightID;
        this.seat = seat;
    }
    
    /**
     * Prints out the booking (a ticket)
     */
    public void printBooking(){

    }

    public void addFlight(Flight flight) {
        journey.add(flight);
    }

    public void removeFlight(Flight flight) {
        journey.remove(flight);
    }

    public void addReservation(Hotel hotel) {
        reservations.add(hotel);
    }

    public void removeReservation(Hotel hotel) {
        reservations.remove(hotel);
    }

    public UUID getFlightID() {
        return this.flightID;
    }

    public String getSeat() {
        return seat;

    }
}
