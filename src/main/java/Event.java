import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Locale;

import static java.time.format.TextStyle.FULL;

/**
 * This class extends the Node class, adding additional data required in a Event type entry
 */
public class Event extends Node{

    private Calendar datetime = null;
    private char nodetype = 'E';
    private int day;
    private Month month;
    private int year;
    private String info;

    /**
     * This is the initialization function for a Event class
     * @param description The description associated with a Event class
     * @param info This is the raw string data associated with datatime
     * @param datetime This is the parsed Calendar data associated with datetime
     */
    public Event(String description, String info, Calendar datetime) {
        this.info = info;
        this.text = description;
        if (datetime != null) {
            this.datetime = datetime;
            this.day = datetime.get(Calendar.DAY_OF_MONTH);
            this.month = Month.of(datetime.get(Calendar.MONTH) + 1);
            this.year = datetime.get(Calendar.YEAR);
        }
        this.status = "[\u2718]";
    }
    /**
     * This function returns a String containing all the data to be printed out to the user
     * @return A string containing all the data to be printed
     */
    @Override
    public String text() {
        DateFormat dateFormat = new SimpleDateFormat("hh.mm a");
        if (datetime != null) {
            return this.text + "(at: " + day + " " + month.getDisplayName(FULL, Locale.ENGLISH)
                    + " " + year + " " + dateFormat.format(datetime.getTime()) + ")";
        }
        else {
            return this.text + "(at:" + info + ")";
        }
    }
    /**
     * This function returns a String containing status information
     * @return A string containing status information
     */
    @Override
    public String status() {
        return "[" + nodetype + "]"+ status;
    }
}