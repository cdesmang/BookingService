import java.util.ArrayList;

import java.util.UUID;

public class RegisteredUsers {
    private static RegisteredUsers users = null;
    private static ArrayList<RegisteredUser> usersList = new ArrayList<>();

    private RegisteredUsers() {
        usersList = DataLoader.getAllUsers();
    }

    public static RegisteredUsers getInstance() {
        if (users == null) {
            users = new RegisteredUsers();
        }

        return users;
    }

    public ArrayList<RegisteredUser> getRegisteredUsers() {
        return usersList;
    }

    public ArrayList<RegisteredUser> getRegisteredUsersFriends() {
        return users.getRegisteredUsersFriends();
    }

    public void addUser(UUID id, String firstName, String lastName, String username, String password, String email, String dob, String streetAddress, String addressCity, String addressState, int addressZip, ArrayList<Booking> bookings, ArrayList<Friend> friends) {
        usersList.add(new RegisteredUser(id, firstName, lastName, username, password, email, dob, streetAddress, addressCity, addressState, addressZip, bookings, friends));
    }

    public void addUser(UUID id, String firstName, String lastName, String username, String password, String email, String dob, String streetAddress, String addressCity, String addressState, int addressZip) {
        usersList.add(new RegisteredUser(id, firstName, lastName, username, password, email, dob, streetAddress, addressCity, addressState, addressZip,null, null));
    }

    public void addUser(UUID id, String firstName, String lastName, String username, String password, String email, String dob, String streetAddress, String addressCity, String addressState, int addressZip, ArrayList<Booking> bookings) {
        usersList.add(new RegisteredUser(id, firstName, lastName, username, password, email, dob, streetAddress, addressCity, addressState, addressZip, bookings,null));
    }

    public void logout() {
        DataWriter.saveUsers();
    }
    
}
