/**
 * Loads information from JSON files
 */

//This is only a tester.
import java.util.Scanner;	//used for inputting the JSON file
import java.io.FileReader;	//used to read files
import java.util.ArrayList; //used for arraylists
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader {
	public static void main(String[] args)
	{
		//These lines of code try to read the entire file.
		try 
		{
			FileReader fileReader = new FileReader("src\\\\flights.json"); //needs filepath
			JSONParser fileParser = new JSONParser();
			JSONArray myJSONArray = (JSONArray) new JSONParser().parse(fileReader);
			
			//
			for(int i = 0; i < myJSONArray.size(); i++)
			{
				JSONObject tempJSONObject = (JSONObject) myJSONArray.get(i);
				String id = (String)tempJSONObject.get("id");
				long flightNumber = (long)tempJSONObject.get("flightNumber");
				String airline = (String)tempJSONObject.get("airline");
				String departureTime = (String)tempJSONObject.get("departureTime");
				String arrivalTime = (String)tempJSONObject.get("arrivalTime");
				String flightTime = (String)tempJSONObject.get("flightDuration");
				
				//This thing doesn't always exist, but you can't get a seat which doesn't exist.
				boolean SixJ = false;
				if(tempJSONObject.get("6J") != null)
					SixJ = (boolean)tempJSONObject.get("6J");
				
				System.out.println("Welcome to flight " + flightNumber + " with airline " + airline + " and flight id " + id + ".");
				System.out.println("This flight leaves at " + departureTime + " and arrives at " + arrivalTime + " , for a total flight time of " + flightTime + ".");
				System.out.println("Seat 6J is available: " + SixJ);
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return;
	}
}

/*
 * This is version 1.0, uploaded on 2022 Mar 22.
 * This merely runs some tests using standard output; it is not made to supplant the final code.
 * Future updates will be concern with separating this code into methods.
*/

/*
 * This is commented out temporarily while the tester is being ran.
import java.util.*;
public class DataLoader {

    public ArrayList <Flight> getAllFlights(){
        ArrayList <Flight> temp = new ArrayList<Flight>();
        return temp;
    }

    public ArrayList <User> getAllUsers() {
        ArrayList <User> temp = new ArrayList<User>();
        return temp;
    }

    // should we also have one for hotel ???
} 
*/
