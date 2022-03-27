/**
 * an object type Flight that has attributes:
 * departure and arrival time
 * aeparture and arrival location
 * number of tickets
 * type of flight (nonstop, round, etc.)
 */
import java.util.*;

public class Flight {

 private UUID flightID;
 private int flightNum;
 private String airline;
 private String arrCity;
 private String arrState;
 public String depCity;
 public String depState;
 private String flightDuration;
 private String departTime;
 private String arrivalTime;
 public Date departDate;
 public Date arrivalDate;
 private Seat[][] seats;

    public Flight(UUID flightID, int flightNum, String airline, Location destination, Location departLoc, String flightDuration, String departTime, String arrivalTime, Date departDate, Date arrivalDate, Seat[][] seats)
    {

    }
    public UUID getFlightID()
    {
        return flightID;
    }
    public int getFlightNum()
    {
        return flightNum;
    }
    public String getAirline()
    {
        return airline;
    }
    public String getDestinationCity() 
    {
        return arrCity;
    }
    public String getDestinationS() 
    {
        return arrState;
    }
    public String getDepartCity() 
    {
        return depCity;
    }
    public String getDepartState() 
    {
        return depState;
    }
    public String getFlightDuration() 
    {
        return flightDuration;
    }
    public String getDepartTime() 
    {
        return departTime;
    }
    public String getArrivalTime()
    {
        return arrivalTime;
    }
    public Date getDepartDate()
    {
        return departDate;
    }
    public Date getArrivalDate()
    {
        return arrivalDate;
    }
    public Seat[][] getSeats()
    {
        return seats;
    }
    public void setFlightID(UUID flightID)
    {
        this.flightID = flightID;
    }
    public void setFlightNum(int flightNum)
    {
        if (flightNum > 0)
            this.flightNum = flightNum;
    }
    public void setAirline(String airline)
    {
        this.airline = airline;
    }
    public void setDestinationC(String city)
    {
        this.arrCity = city;
    }
    public void setDestinationS(String state)
    {
        this.arrState = state;
    }
    public void setDepartC(String city)
    {
        this.depCity = city;
    }
    public void setDepartS(String state)
    {
        this.depState = state;
    }
    public void setDepartTime(String departTime)
    {
        this.departTime = departTime;
    }
    public void setArrivalTime(String arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }
    public void setDepartDate(Date departDate)
    {
        this.departDate = departDate;
    }
    public void setArrivalDate(Date arrivalDate)
    {
        this.arrivalDate = arrivalDate;
    }
    public void setSeats(Seat[][] seats)
    {
        this.seats = seats;
    }
}
