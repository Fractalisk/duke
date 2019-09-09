import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Locale;

import static java.time.format.TextStyle.FULL;

/**
 * This class extends the Node class, adding additional data required in a Deadline type entry
 */
public class Deadline extends Node{

    private Calendar datetime = null;
    private char nodetype = 'D';
    private int day;
    private Month month;
    private int year;
    private String info;

    /**
     * This is the initialization function for a Deadline class
     * @param description The description associated with a Deadline class
     * @param info This is the raw string data associated with datatime
     * @param datetime This is the parsed Calendar data associated with datetime
     */
    public Deadline(String description, String info, Calendar datetime) {
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
            return this.text + "(by: " + day + " " + month.getDisplayName(FULL, Locale.ENGLISH)
                    + " " + year + " " + dateFormat.format(datetime.getTime()) + ")";
        }
        else {
            return this.text + "(by:" + info + ")";
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