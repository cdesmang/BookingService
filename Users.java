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
    }


    public User searchUser(String username, String password) {
        User search = null;
        int i = 0;
        boolean run = true;
        while(run){
            if(i>= users.size())run=false;
            else if(users.get(i).getUsername().equals(username)&& users.get(i).getPassword().equals(password)){
                search = users.get(i);
                run = false;
            }else i++;
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
        String username = user.getUsername();
        String password = user.getPassword();
        User search=  searchUser(username, password);
        int index= users.indexOf(search);
        search = user;
        users.remove(index);
        users.add(index, search);
    }

    public void deleteUser(User user) {
        users.remove(user);
    }


    public Boolean checkIfRegisterd(User user){
        return user.getType().equalsIgnoreCase("registered");
    }

    /*public void addBooking(){
        users.
    }*/

}
