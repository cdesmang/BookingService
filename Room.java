public class Room {

    private int floor;
    private int roomNum;
    private int numBeds;
    private BedTypes bedtype;
    private boolean hasPullout;
    private boolean Available;

    public Room (int floor, int roomNum, boolean hasPullout) {

    }

    //getters
    public int getFloor (Room room) {
        return room.floor;
    }

    public int getRoomNum (Room room) {
        return room.roomNum;
    }

    public int getNumBeds (Room room) {
        return room.numBeds;
    }

    public boolean getHasPullout (Room room) {
        return hasPullout;
    }

    public BedTypes getBed (Room room){
        return room.bedtype;
    }

    public boolean getAvailibilty (Room room) {
        return room.Available;
    }
    
    //setters
    public void setFloor (Room room, int floor) {

    }

    public void setRoomNum(Room room, int num) {

    }

    public void setNumBeds (Room Room, int num) {

    }

    public void setPullout (Room room, boolean pullout) {

    }
}
