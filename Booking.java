import java.util.ArrayList;


public class Booking {
    public String booker_username; // this booking goes into this user's bookings list
    public String customer_username; // this booking is for this customer
    public ArrayList<Flight> journey;
    public ArrayList<Room> reservations;
    public Seat seat;


    public Booking(String booker_username, String customer_username) {
        this.booker_username = booker_username;
        this.customer_username = customer_username;
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
}
