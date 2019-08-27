import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Locale;

import static java.time.format.TextStyle.FULL;

public class Event extends Node{

    private Calendar datetime;
    private char nodetype = 'E';
    private int day;
    private Month month;
    private int year;
    private String info;

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

    @Override
    public String status() {
        return "[" + nodetype + "]"+ status;
    }

    public char showtype() {
        return nodetype;
    }
}