/**
 * Does stuff involving all users
 * @author Christina Desmangles
 * @author Some one else but im not sure who
 */

import java.util.ArrayList;
public class Users {


    private ArrayList<User> users;
    private static DataLoader DL = new DataLoader();

    public Users(){
        users= DL.getAllUsers();
    

    public boolean login() {
        return true;
    }

    public User searchUser(String username, String password) {
        User search = null;
        int i = 0;
        boolean run = true;
        while(run){
            if(users.get(i).getUsername().equalsIgnoreCase(username)&& users.get(i).getPassword().equals(password)){
                search = users.get(i);
                run = false;
            }else if (users.get(i).equals(null)){
                run = false;
            }else{
                i++;
            }
        }
        return search;
    } 

    /**
     * adds a new user to the user database
     * @param- user to be added to the arraylist
     */
    public void addUser(RegisteredUser user) {
        users.add(user);
    }

    /**
     * edits a given user by setting that user = to another user (parameter)
     *                  temp = user
     * adds temp back to the array list at the same index
     * used to logout
     * @param- the rhs user 
     */
    public void editUser(User user) {
        int i = users.indexOf(user);
        User temp = users.get(i);
        temp = user;
        users.add(i, temp); 
    }

    public void deleteUser(User user) {
        users.remove(user);
    }


    public Boolean checkIfRegisterd(User user){
        if (user.getType().toLowerCase().equalsIgnoreCase("guest"))
            return false;
        return true;
    }

    /*public void addBooking(){
        users.
    }*/

}
