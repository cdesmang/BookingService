import java.util.ArrayList;

import java.util.*;
public class Hotel {
    private int rating;
    public String name;
    private String location;
    private int roomsAvail; // do we need this?
    private ArrayList <Room> hotelRooms;

    public Hotel(int rating, String name, String location, int roomsAvail) {

    }
    
    public ArrayList<Room> checkRooms (ArrayList<Room> hotelRooms) {
        // wth is this supposed to do?? why does it return an arraylist
        ArrayList<Room> temp = new ArrayList<Room>();
        return temp;
    }
}
