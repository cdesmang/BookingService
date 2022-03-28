
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
    



    
}
