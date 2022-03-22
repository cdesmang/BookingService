import java.util.*;
public class RegisteredUser extends User {
    protected Account account;
    private ArrayList <Booking> booking;
    private ArrayList <Account> friends;

    public RegisteredUser(String firstName, 
                          String lastName, 
                          String username, 
                          String password, 
                          String email, 
                          Date dob, 
                          String address){
        super(firstName,lastName);

    }

    public void searchFlights() {

    }

    public void filterResults() {}

    public void addBooking (Booking booked) {

    }

    public void addFriend (Account friend) {

    }

    public void removeFriend(Account friend) {

    }

    // maybe we should have a find account method so the user can just enter the username of their friend???

    
}
