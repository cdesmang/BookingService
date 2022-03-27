import java.util.ArrayList;
public class RegisteredUser extends User {

    /**
     * the number of seats to book will be one more than the length of this arraylist
     */
    private ArrayList<Friend> friends;
    private String email;
    private Date dob;
    private String address;
    private String username;
    private String password;

    public int seatsToBook;

    public RegisteredUser(String firstName, String lastName, String username, String password, String email, Date dob, String address){
        super(firstName,lastName);
        fullName = firstName + " " + lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.address = address;
    }

    public void addFriend (Friend friendusername) {
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

    public void logout() {

    }

}
