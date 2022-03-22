public class Plane {
    private int planeID;
    private int nSeatsAvail;
    private int numBag;
    private int numRows;
    private int seatNum;
    private Seat [][] seats;

    public Plane (int planeID, int nSeatsAvail) {

    }

    public Seat getSeat(Seat[][] seats) {
        Seat selected = seats[0][0];
        return selected;
    }


}
