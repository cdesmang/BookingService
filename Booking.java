import java.util.ArrayList;
import java.util.UUID;


public class Booking {
    public String booker_username; // this booking goes into this user's bookings list
    public String customer_username; // this booking is for this customer
    public ArrayList<Flight> journey;
    public ArrayList<Room> reservations;
    public Seat seat;

    private UUID flightID; // used for JSON file
    private String seat; // used for JSON file


    public Booking(String booker_username, String customer_username) {
        this.booker_username = booker_username;
        this.customer_username = customer_username;
<<<<<<< HEAD
=======
        this.journey = journey;
        this.reservations = reservations;
    }

    /**
     * @param flightID the UUID associated with the flight
     * @param seat the seat on the flight associated with the user
     * 
     * 
     * This constructor is used for reading and writing to/from the JSON file
     * 
     * 
     */
    public Booking(UUID flightID, String seat) {
        this.flightID = flightID;
        this.seat = seat;
    }
    
    /**
     * Prints out the booking (a ticket)
     */
    public void printBooking(){

>>>>>>> 697f9a4e477c80f5ef2fbc03f4ba441a6d844378
    }

    public void addFlight(Flight flight) {
        journey.add(flight);
    }

    public void removeFlight(Flight flight) {
        journey.remove(flight);
    }

    public void addReservation(Room room) {
        reservations.add(room);
    }

    public void removeReservation(Room room) {
        reservations.remove(room);
    }

    public UUID getFlightID() {
        return this.flightID;
    }

    public String getSeat() {
        return seat;

    }
}
