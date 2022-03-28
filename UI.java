
/**
 * User Interface 
 * @author Christina Desmangles
 */

import java.util.Scanner;
import java.util.ArrayList;
public class UI {

    private static final Scanner key = new Scanner(System.in);
    private static FlightSystem flightSystem;

    /**
     * main method- interacts with user and runs code
     * @param args
     */
    public static void main(String[] args) {

        boolean run = true;
        while (run) {
            String login= Welcome();
            if (login == "GUEST") {
                run = guestSearch();
            }
            else if (login == "LOG IN"){
                System.out.println("Please enter your username");
                String name = key.nextLine();
                System.out.println("Please enter your password");
                String pass = key.nextLine();
                run = registeredSearch(name, pass);
                
            }
            else if (login == "EXIT") {
                System.out.println("Goodbye!");
                run = false;
            } else if (login == "SIGN UP"){
                run = createUser();
                
            }else{
                System.out.println("Invalid input!");
                run = true;
            }
        }
    }

    /**
     * Prints out a welcome statment to the user that allows us to know how they will be searching.
     * Also gives the user the option to exit the program
     * @return the user response of what they wanna do
     */
    public static String Welcome(){ 
        System.out.println("Welcome to the Flight Booking System!"+
        "\nTo continue as a guest please enter \"guest\" ,to log in to an existing account please enter \"log in\", to create a new account please enter \"sign up\", or to exit please enter \"exit\"");
        String login = key.nextLine().toUpperCase();
        return login;
    }

    /**
     * runs program if user selects that they are a guess
     * will eventually force them to switch to registered user if they want to book
     */
    public static boolean guestSearch(){
        boolean error = true;
        flightSystem= new FlightSystem("guest", "none" ,"none");
        String[] flights= getFlights();
        System.out.println(flights+ "\n"+"\nPlease enter the result number of the flight(s) you would like to book.");



        return error;
    }

    /**
     * runs program if user selects that they are registered
     *  - tries to login ( if username or password is incorrect 3 times then closes program)------ return 1
     */
    public static boolean registeredSearch(String username, String password){
        boolean error = true;
        flightSystem = new FlightSystem("registered", username, password);
        if(flightSystem.getCurrentUser()== null){
            int count = 0;
            while(count < 3){
                System.out.println("Invalid username or password!");
                System.out.println("Please re-enter your username:");
                String x = key.nextLine();
                System.out.println("Please re-enter your password:");
                String y = key.nextLine();
                flightSystem= new FlightSystem("registered", x, y);
                if (flightSystem.getCurrentUser() != null) {
                    System.out.println("Welcome, "+flightSystem.getCurrentUser().getUsername());
                    count = 3;
                }else {
                    System.out.println((count+1)+" / 3 failed attempts!");
                    if (count == 2){
                        System.out.println("Exiting system... Goodbye!");
                        error = false;
                        count = 3;
                    }
                    
                }
                count++;
            }
        }
        String[] flights = getFlights();
        System.out.println(flights+"\n"+"\n Please enter the result number of the flight(s) you would like to book.");

        return error;
    }

    public static boolean createUser(){
        boolean error = true;
        return error;
    }


    /**
     * Connects to flights class to find all flights that fit the given parameters
     * @return an arraylist with all flights 
     */
    private static String[] getFlights(){

        System.out.println("Please enter your departure location in the format \"city, State\"");
        String dLString = key.nextLine();
        String[] dLoc = parseLoc(dLString);
        System.out.println("Getting departure date information:");
        Date dDate= getDate();
        System.out.println("Please enter your arrival location in the format \"city, State\"");
        String aLString= key.nextLine();
        String[] aLoc = parseLoc(aLString);
        System.out.println("Getting arrival date information:");
        Date aDate = getDate();
        String []flights = flightSystem.getAllFlights(dLoc, aLoc, dDate, aDate);
        return flights;
    }

    /**
     * Converts a string entered by user to a location type
     * @param location User input of location(string)
     * @return Location type version of user input
     */
    private static String[] parseLoc(String location){
        String[] splitLoc= location.split(",");
        return splitLoc;
    }

    /**
     * Converts a string entered by the user to a date type
     * @return Date type of user input
     */
    private static Date getDate(){
        String[] tempS;
        int [] tempI = new int[3];
        while (tempI[0]==0|| tempI[1]==0){
            System.out.println("Enter a date: MM/DD/YYYY");
            String x = key.nextLine();
            tempS= x.split("/");
            for (int i = 0; i<3; i++){
                tempI[i] = Integer.parseInt(tempS[i]);
            }
            if(tempI[0] >= 13) //invalid month
                System.out.println("Invalid Month");
                tempI[0] = 0;
            if(tempI[1] >= 32) //invalid day
                System.out.println("Invalid Day");
                tempI[1] = 0;
        }
        Date created= new Date (tempI[0], tempI[1], tempI[2]);
        return created;
    }
}
