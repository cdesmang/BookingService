/**
 * an object type Flight that has attributes:
 * departure and arrival time
 * aeparture and arrival location
 * number of tickets
 * type of flight (nonstop, round, etc.)
 */
import java.util.*;

public class Flight {

 private String flightID;
 private String flightNum;
 private String airline;
 private String destinationCity;
 private String destinationState;
 private String departureCity;
 private String departureState;
 private Date departureDate;
 private Date arrivalDate;
 private String flightDuration;
 private String departureTime;
 private String arrivalTime;
 private ArrayList<Seat> seats;
 private ArrayList<Integer> connectionIndex;

    public Flight(String flightID, String flightNum, String airline, String destinationCity, String destinationState, String departureCity, String departureState, Date departureDate, Date arrivalDate, String flightDuration, String departureTime, String arrivalTime, ArrayList<Seat> seats)
    {
        this.flightID = flightID;
        this.flightNum = flightNum;
        this.airline = airline;
        this.destinationCity = destinationCity;
        this.destinationState = destinationState;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightDuration = flightDuration;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seats = seats;
    }
    public String getFlightID()
    {
        return flightID;
    }
    public String getFlightNum()
    {
        return flightNum;
    }
    public String getAirline()
    {
        return airline;
    }
    public String getDestinationCity() 
    {
        return destinationCity;
    }
    public String getDestinationState() 
    {
        return destinationState;
    }
    public String getDepartCity() 
    {
        return departureCity;
    }
    public String getDepartState() 
    {
        return departureState;
    }
    public String getFlightDuration() 
    {
        return flightDuration;
    }
    public String getDepartTime() 
    {
        return departureTime;
    }
    public String getArrivalTime()
    {
        return arrivalTime;
    }
    public Date getDepartDate()
    {
        return departureDate;
    }
    public Date getArrivalDate()
    {
        return arrivalDate;
    }
    public ArrayList<Seat> getSeats()
    {
        return seats;
    }
    public int getConnection(int i){
        return this.connectionIndex.get(i);
    }
    public ArrayList<Integer> getConnectionString(){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i=0; i < connectionIndex.size(); i++){
            temp.add(connectionIndex.get(i)+1);
        }
        return temp;
    }

    public void setConnection(int i){
        this.connectionIndex.add(i);
    }
    public void setFlightID(String flightID)
    {
        this.flightID = flightID;
    }
    public void setFlightNum(String flightNum)
    {
        if (Integer.parseInt(flightNum) > 0)
            this.flightNum = flightNum;
    }
    public void setAirline(String airline)
    {
        this.airline = airline;
    }
    public void setDestinationCity(String city)
    {
        this.destinationCity = city;
    }
    public void setDestinationState(String state)
    {
        this.destinationState = state;
    }
    public void setDepartCity(String city)
    {
        this.departureCity = city;
    }
    public void setDepartState(String state)
    {
        this.departureState = state;
    }
    public void setDepartTime(String departTime)
    {
        this.departureTime = departTime;
    }
    public void setArrivalTime(String arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }
    public void setDepartDate(Date departDate)
    {
        this.departureDate = departDate;
    }
    public void setArrivalDate(Date arrivalDate)
    {
        this.arrivalDate = arrivalDate;
    }
    public void setSeats(ArrayList<Seat> seats)
    {
        this.seats = seats;
    }

    public String toString (){
        String connections=" ";
        if(this.connectionIndex != null){
            for(int i = 0; i< connectionIndex.size(); i++){
                connections += connectionIndex.get(i)+", ";
            }
        } else{
            connections ="NONE";
        }
        return  "\n Airline: "+this.airline+
        "\n Flight Num : "+ this.flightNum+
        "\n Departure Location: "+this.departureCity+", "+ this.departureState+
        "\n Arrival Location: "+this.destinationCity+ ", "+this.destinationState+
        "\n Flight Duration: "+ this.flightDuration+
        "\n Departure Date and Time: "+ this.departureDate.toString()+ " at "+this.departureTime+
        "\n Arrival Date and Time: "+ this.arrivalDate.toString()+ " at "+this.arrivalTime+
        "\n Connecting Flight Result Number(s): "+connections
        +"\n --------------------------------------------------------------------------------------------------------";
    }
}
