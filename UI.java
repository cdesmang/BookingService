
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
            if (login.equalsIgnoreCase("guest")) {
                run = guestSearch();
            }
            else if (login.equalsIgnoreCase("log in")){
                System.out.println("Please enter your username");
                String name = key.nextLine();
                System.out.println("Please enter your password");
                String pass = key.nextLine();
                registeredSearch(name, pass);
            }
            else if (login.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                run = false;
            } else if (login.equalsIgnoreCase("sign up")){
                run =createUser();
                
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
	    flightSystem= new FlightSystem();
	    String[]flights= getFlights();
	    System.out.println(flights.toString()+ "\n"+"\nPlease enter the result number of the flight(s) you would like to book."+
	                                         "\n Please use a comma to separate choice(s), or enter \"none\" if you would not like to book a flight.");


	    if (error == false) System.out.println("Error in guestSearch()");
	    return error;

    }

    /**
     * runs program if user selects that they are registered or would like to register
     */
    private static boolean registeredSearch(String username, String password){
        boolean error = true;
        flightSystem = new FlightSystem(username, password);
        if(flightSystem.getCurrentUser()== null){
            int count = 0;
            while(count < 3){
                System.out.println("Invalid username or password!\n"+(count+1)+" / 3 failed attempts");
                count++;
                System.out.println("Please re-enter your username:");
                String x = key.nextLine().replace('\n',' ').trim();
                System.out.println("Please re-enter your password:");
                String y = key.nextLine().replace('\n', ' ').trim();
                flightSystem= new FlightSystem(x,y);
                if (flightSystem.getCurrentUser() != null) {
                    System.out.println("Welcome, "+flightSystem.getCurrentUser().getUsername());
                    count = 3;
                }else {
                    if (count == 2){
                        System.out.println("To create a new account enter \"Create\" to exit the program enter \"exit\".");
                        String choice = key.nextLine().replace('n', ' ').trim();
                        if (choice.equalsIgnoreCase("exit")){
                            System.out.println("Exiting system... Goodbye!");
                            error = false;
                            count = 3;
                        } else if (choice.equalsIgnoreCase("create")){
                            String[] info = InfoNoBDay();
                            System.out.println("Please enter your date of birth");
                            Date bday = getDate();
                            flightSystem = new FlightSystem(info[0], info[1], info[2], info[3], info[4], info[5],bday);
                            count++;
                        }
                    }
                    
                }
                count++;
            }
        }
        String[] flights = getFlights();
        System.out.println(flights+"\n"+"\n Please enter the result number of the flight(s) you would like to book."+
                                        "\n Please use a comma to separate choice(s), or enter \"none\" if you would not like to book a flight.");
    
        if (error == false)System.out.println("Error in registeredUser()");
        return error;
    }
    /**
     * runs program if user initally decides to create an account
     * @return - false if there is an error(to end program);
     */
    private static boolean createUser( ){
        boolean error = true;
        String [] info = InfoNoBDay();
        System.out.println("Please enter your date of birth.");
        Date bday= getDate();
        flightSystem = new FlightSystem(info[0], info[1], info[2], info[3], info[4], info[5],bday);

        return error;
    }

    /**
     * Connects to flights class to find all flights that fit the given parameters
     * @return an string[] with all flights 
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
        String[]flights = flightSystem.getAllFlights(dLoc, aLoc, dDate, aDate);
        return flights;
    }

    /**
	 * Collects information from user about creatiing an account(except birthday)
	 * @return an array with all necessary information to create an new registered user except for the birthdate
	 */
	private static String[] InfoNoBDay(){
	    String[] temp = new String[6];
	    System.out.println("Please enter your first name that would appear on any legal documentation: ");
	    temp[0] = key.nextLine().replace('\n',' ').trim();
	    System.out.println("Please enter your last name that would appear on any legal documentation: ");
	    temp[1] = key.nextLine().replace('\n', ' ').trim();
	    System.out.println("Please enter a username: ");
	    temp[2] = key.nextLine().replace('\n',' ').trim();
	    System.out.println("Please enter a password: ");
	    temp[3] = key.nextLine().replace('\n',' ').trim();
	    System.out.println("Please enter an email: ");
	    temp[4] = key.nextLine().replace('\n',' ').trim();
	    System.out.println("Please enter your Street address ie. \"100 President St. City, State 11111\"");
	    temp[5]= key.nextLine().replace('\n',' ').trim();
	    return temp;
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
        tempS= new String[3];
        for (int i = 0; i< tempI.length; i++){
            tempS[i]= String.valueOf(tempI[i]);
        }
        Date created= new Date (tempS[0], tempS[1], tempS[2]);
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
