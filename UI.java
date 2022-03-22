<<<<<<< HEAD
=======

>>>>>>> d5b94ba4d88e74d6aea750b93cb4146e67b01dbd
/**
 * User Interface 
 * @author Christina Desmangles
 */
import java.util.Scanner; //This is necessary for user input.

import javax.lang.model.util.ElementScanner6;

 public class UI {

    public static void main(String[] args) {
        //Setting up the scanner...
        Scanner inputReader = new Scanner(System.in);   //This initializes a Scanner object.
        String input = "";  //This string will be updated to reflect user input.

        System.out.println("Welcome to Flight Booking Service!");
        System.out.println("What are you looking for today?");
        System.out.println("Are you looking for flights, hotels, or logins?");
        input = inputReader.nextLine();
        input = input.toLowerCase();
        if(input == flights || input == f)
        {
            //do the flights stuff
            System.out.println("Doing the flights stuff...");
            return;
        }
        else if(input == hotels || input == h)
        {
            //do the hotels stuff
            System.out.println("Doing the hotels stuff...");
            return;
        }
        else if(input == logins || input == l)
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
    
}

