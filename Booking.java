import java.util.ArrayList;


public class Booking {
    private String booker_username; // this booking goes into this user's bookings list
    private String customer_username; // this booking is for this customer
    private ArrayList<Flight> journey;
    private ArrayList<Hotel> reservations;


    public Booking(String booker_username, String customer_username, ArrayList<Flight> journey, ArrayList<Hotel> reservations) {
        this.booker_username = booker_username;
        this.customer_username = customer_username;
        this.journey = journey;
        this.reservations = reservations;
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
}
