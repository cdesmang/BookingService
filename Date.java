/**
 * Creates a date
 * @author David Eta
 * 
 */

public class Date {
    
    private String weekday;
    private String month;
    private int day;
    private int year;


   

    /**
     * initialises Date type.
     * @param month the full month in string format.
     * @param date the day of the month.
     * @param year
     */
    public Date (String month,int day ,int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }
    
     /**
      * @param weekday a string value indicating the day of the week the flight will be on
      * @param month a string value indicating the month
      * @param day the day of the month
      * @param year the year
      * 
      *
      * This constructor is used for reading and writing to/from the JSON file
      *
      *
      */
    public Date(String weekday, String month, int day, int year) {
        this.weekday = weekday;
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * @return the date in mm/dd/yyyy format.
     */
    public String toString() {
        if (day < 10) {
            return month + "/0" + day + "/" + year;
        }
        return month + "/" + day + "/" + year;
    }
    
    public boolean dateMatch(Date x){
        return (this.month == x.month) && (this.day == x.day) && (this.year == x.year);
    }
}
