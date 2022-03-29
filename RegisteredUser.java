import java.util.ArrayList;
public class RegisteredUser extends User {

    /**
     * the number of seats to book will be one more than the length of this arraylist
     */
    private ArrayList<Friend> friends;
    private String fullName;
    private String email;
    private Date dob;
    private String address;
    private String username;
    private String password;
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

    
    /**
     * a booking has a :
     * full name
     * flight booking (can be null) - where to where, time and date, flight number, seat number
     * hotel booking (can be null) - hotel name, place, date, room number(s)
     * 
    */
}
