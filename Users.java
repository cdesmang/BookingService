import java.util.ArrayList;
public class Users {
    private ArrayList<User> users;

    public User getAllUsers() {
        return users.get(0);
    }

    public boolean login() {
        return true;
    }

    public User searchUser(String keyWord) {
        return users.get(0);
    } 

    public void addUser (User user) {

    }

    public void editUser (User user) {

    }

    public void deleteUser (User user) {

    }


}
