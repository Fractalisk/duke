import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Locale;

import static java.time.format.TextStyle.FULL;

public class Deadline extends Node{

    private Calendar datetime;
    private char nodetype = 'D';
    private int day;
    private Month month;
    private int year;
    private String info;

    public Deadline(String description, String info, Calendar datetime) {
        this.info = info;
        if (datetime != null) {
            this.datetime = datetime;
            this.text = description;
            this.day = datetime.get(Calendar.DAY_OF_MONTH);
            this.month = Month.of(datetime.get(Calendar.MONTH) + 1);
            this.year = datetime.get(Calendar.YEAR);
        }
        this.status = "[\u2718]";
    }

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

    @Override
    public String status() {
        return "[" + nodetype + "]"+ status;
    }

    public char showtype() {
        return nodetype;
    }
}