
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
                guestSearch();
            }
            else if (login == "LOG IN"){
                System.out.println("Please enter your username");
                String name = key.nextLine();
                System.out.println("Please enter your password");
                String pass = key.nextLine();
                registeredSearch(name, pass);
            }
            else if (login == "EXIT") {
                System.out.println("Goodbye!");
                run = false;
            } else if (login == "SIGN UP"){
                
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
    public static void guestSearch(){
        flightSystem= new FlightSystem("guest", "none" ,"none");
         getFlights();

    }

    /**
     * runs program if user selects that they are registered or would like to register
     */
    public static void registeredSearch(String username, String password){
        flightSystem = new FlightSystem("registered", username, password);
        int count = 0;

        while(count < 3){
            System.out.println("Invalid username or password!");
            System.out.println("Please re-enter your username:");
            String x = key.nextLine();
            System.out.println("Please re-enter your password:");
            String y = key.nextLine();
            flightSystem= new FlightSystem("registered", x, y);

        }


    }

    /**
     * Connects to flights class to find all flights that fit the given parameters
     * @return an arraylist with all flights 
     */
    private static ArrayList<Flight> getFlights(){

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
        ArrayList<Flight>flights = flightSystem.getAllFlights(dLoc, aLoc, dDate, aDate);
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


    











   /* public static void main(String[] args) {
        //Setting up the scanner...
        Scanner inputReader = new Scanner(System.in);   //This initializes a Scanner object.
        String input = "";  //This string will be updated to reflect user input.

        System.out.println("Welcome to Flight Booking Service!");
        System.out.println("What are you looking for today?");
        System.out.println("Are you looking for flights, hotels, or to login?");
        input = inputReader.nextLine();
        input = input.toLowerCase();
        if(input == "flights" || input == "f")
        {
            //do the flights stuff
            System.out.println("Doing the flights stuff...");
            return;
        }
        else if(input == "hotels" || input == "h")
        {
            //do the hotels stuff
            System.out.println("Doing the hotels stuff...");
            return;
        }
        else if(input == "login" || input == "l")
        {
            //do the login stuff
            System.out.println("Doing the login stuff...");
            return;
        }
        else
        {
            //Invalid input.
            System.out.println("Invalid input. Terminating program...");
            return;
        }

        

    }

    private ArrayList<Flights> getFlights){
        return flightSystem.getAllFlights();
    }

   // private static */

    
}

