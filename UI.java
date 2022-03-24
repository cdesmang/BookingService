
/**
 * User Interface 
 * @author Christina Desmangles
 */

import java.util.Scanner;
import java.util.ArrayList;
public class UI {

    private static final Scanner key = new Scanner(System.in);
    private static FlightSystem flightSystem = new FlightSystem();

    public static void main(String[] args) {

        boolean run = true;
        while (run) {
            String login= Welcome();
            if (login == "GUEST") {
                guestSearch();
            }
            else if (login == "SIGN IN"){
                registeredSearch();
            }
            else{
                System.out.println("Invalid input!");
                run = true;
            }
        }
    }

    public static String Welcome(){ 
        System.out.println("Welcome to the Flight Booking System!"+
        "\nWould you like to continue searching as a guest, or would you like to sign in?"+
        "\nTo continue as a guest please enter \"guest\" or to sign in please enter \"sign in\"");
        String login = key.nextLine().toUpperCase();
        return login;
    }

    public static void guestSearch(){
         getFlights();

    }

    public static void registeredSearch(){

    }

   /* DO THIS INSIDE OF FLIGHT SYSTEM
    private static Date getDate(String date){
        String temp = date;
        String[] sections = temp.split("/");
        int month = Integer.parseInt(sections[0]);
        int day = Integer.parseInt(sections[1]);
        int year = Integer.parseInt(sections[2]);
        Date created = new Date(month,day,year);
    }*/

    private static Location getLocation(String loc) {

    }

    private static ArrayList<Flights> getFlights(){
        System.out.println("Pleae enter your departure location in the format \"city, State\"");
        String dLoc= key.nextLine();
        System.out.println("Please enter your departure date in the format\"MM/DD/YYYY\"");
        String dDate= key.nextLine();
        System.out.println("Pleae enter your arrival location in the format \"city, State\"");
        String aLoc= key.nextLine();
        System.out.println("Please enter your arrival date in the format\"MM/DD/YYYY\"");
        String aDate= key.nextLine();
        flightSystem.getAllFlights(dLoc, aLoc, dDate, aDate);
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

