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
 private Location destination;
 private Location departLoc;
 private String flightDuration;
 private String departTime;
 private String arrivalTime;
 private Date departDate;
 private Date arrivalDate;
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
    public Location getDestination() 
    {
        return destination;
    }
    public Location getDepartLocation() 
    {
        return departLoc;
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
    public void setDestination(Location destination)
    {
        this.destination.city = destination.city;
        this.destination.state = destination.state;
    }
    public void setDepartLocation(Location departLoc)
    {
        this.departLoc.city = departLoc.city;
        this.departLoc.state = departLoc.state;
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
