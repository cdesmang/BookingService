/**
 * Creates a date
 * @author David Eta
 * 
 */

public class Date {
    
    private int month;
    private int day;
    private int year;


    /**
     * initialises Date type.
     * @param month the full month in string format.
     * @param date the day of the month.
     * @param year
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * @return the date in mm/dd/yyyy format.
     */
    public String toString() {
        if (day < 11) {
            if (month < 11)
                return "0" + month + "/0" + day + "/" + year;
            return month + "/0" + day + "/" + year;
        }
        return month + "/" + day + "/" + year;
    }
}
