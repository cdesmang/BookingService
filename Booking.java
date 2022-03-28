import java.util.ArrayList;


public class Booking {
    private ArrayList<Flight> flights;
    private ArrayList<Hotel> reservations;


    public Booking(ArrayList<Flight> flights, ArrayList<Hotel> reservations) {
        this.flights = flights;
        this.reservations = reservations;
    }
    
    /**
     * Prints out the booking (a ticket)
     */
    public void printBooking(){

    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void removeFlight(Flight flight) {
        flights.remove(flight);
    }

    public void addReservation(Hotel hotel) {
        reservations.add(hotel);
    }

    public void removeReservation(Hotel hotel) {
        reservations.remove(hotel);
    }
}
