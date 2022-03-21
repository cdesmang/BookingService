

/**
 * Creates a date
 * @author David Eta
 * 
 */
import java.util.HashMap;

public class Date {
    
    private String month;
    private int day;
    private int year;
    private HashMap<String, String> months  = new HashMap<String, String>() {{
        put("January",   "01");
        put("February",  "02");
        put("March",     "03");
        put("April",     "04");
        put("May",       "05");
        put("June",      "06");
        put("July",      "07");
        put("August",    "08");
        put("September", "09");
        put("October",   "10");
        put("November",  "11");
        put("December",  "12");
    }};


    /**
     * initialises Date type.
     * @param month the full month in string format.
     * @param date the day of the month.
     * @param year
     */
    public Date(String month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * @return the date in mm/dd/yyyy format.
     */
    public String toString() {

        if (day < 11)
            return months.get(month) + "/0" + day + "/" + year;
            return months.get(month) + "/" + day + "/" + year;
    }
}
