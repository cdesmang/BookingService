/**
 * Creates a date
 * @author David Eta
 * 
 */

public class Date {
    
    private String weekday;
    private String month;
    private String day;
    private String year;

    public Date(String month, String day, String year){
        this.month= month;
        this.year = year;
        this.day = day;
       // this.weekday = 
    }

    /**
     * initialises Date type.
     * @param month the full month in string format.
     * @param date the day of the month.
     * @param year
     */
    public Date(String weekday, String month, String day, String year) {
        this.weekday = weekday;
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * @return the date in mm/dd/yyyy format.
     */
    public String toString() {
        if (Integer.parseInt(day) < 11) {
            if (Integer.parseInt(month) < 11)
                return "0" + month + "/0" + day + "/" + year;
            return month + "/0" + day + "/" + year;
        }
        return month + "/" + day + "/" + year;
    }
    
    public boolean dateMatch(Date x){
        return this.month.equalsIgnoreCase(x.month) && this.day.equalsIgnoreCase(x.day) && this.year.equalsIgnoreCase(x.year);
    }
}
