import java.util.ArrayList;

public class GuestUser extends User {

    public GuestUser() {
       userType = "guest";
    }

    @Override
    public String getUsername() {
        return "none";
    }

    @Override
    public String getPassword() {
        return "none";
    }

    @Override
    public ArrayList<Friend> getFriends() {
        return null;
    }

    @Override
    public void addFriends(Friend x) {}
        
    

    



    
}
