import java.util.ArrayList;
import java.util.UUID;

public class RegisteredUser extends User {

    /**
     * the number of seats to book will be one more than the length of this arraylist
     */
    private ArrayList<Friend> friends = new ArrayList<Friend>();
    private UUID userID;
    private String firstName;
    private String lastName;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String dateOfBirth;
    private String streetAddress;
    private String addressCity;
    private String addressState;
    private int addressZip;
    private Date dob;
    private String address;
    public ArrayList<Booking> bookings;
    public int seatsToBook;

    

    public RegisteredUser(String firstName, String lastName, String username, String password, String email, String address, Date dob){
        fullName = firstName + " " + lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.userType = "registered";
    }

    public RegisteredUser(UUID userID, String firstName, String lastName, String username, String password, String email, String dateOfBirth, String streetAddress, String addressCity, String addressState, int addressZip, ArrayList<Booking> bookings, ArrayList<Friend> friends) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.streetAddress = streetAddress;
        this.addressCity = addressCity;
        this.addressState = addressState;
        this.addressZip = addressZip;
        this.bookings = bookings;
        this.friends = friends;
    }

    public void addFriends (Friend friendusername) {
        friends.add(friendusername);
        seatsToBook++;
    }

    public void removeFriend(Friend friendusername) {
        friends.remove(friendusername);
        seatsToBook--;
    }

    public ArrayList<Friend> getFriends() {
        return friends;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public String getAddressCity() {
        return this.addressCity;
    }

    public String getAddressState() {
        return this.addressState;
    }

    public int getAddressZip() {
        return this.addressZip;
    }

    public String getEmail() {
        return this.email;
    }

    public ArrayList<Booking> getBookings() {
        return this.bookings;
    }

    
    /**
     * a booking has a :
     * full name
     * flight booking (can be null) - where to where, time and date, flight number, seat number
     * hotel booking (can be null) - hotel name, place, date, room number(s)
     * 
    */
}
