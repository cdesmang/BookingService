/**
 * Does stuff involving all users
 * @author Christina Desmangles
 * @author Some one else but im not sure who
 */

import java.util.ArrayList;
public class Users {


    private ArrayList<RegisteredUser> users;

    public User getAllUsers() {
        return users.get(0);
    }

    public boolean login() {
        return true;
    }

<<<<<<< HEAD
    public User searchUser(String keyWord) {
        
=======
    public User searchUser(String username, String password) {
        User search = null;
        int i = 0;
        boolean run = true;
        while(run){
            if(username == users.get(i-1).getUsername() && password == users.get(i-1).getPassword()){
                search = users.get(i);
                run = false;
            }else if (users.get(i) != null){
                run = false;
            }else{
                i++;
            }
        }
        return search;
>>>>>>> c95c199c4c4c31b47d43db7d5f51c2fa6c5993e5
    } 

    public void addUser(RegisteredUser user) {
        users.add(user);
    }

    public void editUser(User user) {

    }

    public void deleteUser(User user) {
        users.remove(user);
    }


    public Boolean checkIfRegisterd(User user){
        if (user.getType().toLowerCase() == "guest")
            return false;
        return true;
    }

}
