import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.time.format.TextStyle.FULL;

public class Deadline extends Node{

    private char nodetype = 'D';
    private int day;
    private Month month;
    private int year;
    private int hour;
    private int mins;

    public Deadline(String description, Calendar datetime) {
        this.text = description;
        this.day = datetime.get(Calendar.DAY_OF_MONTH);
        this.month = Month.of(datetime.get(Calendar.MONTH) + 1);
        this.year = datetime.get(Calendar.YEAR);
        this.hour = datetime.get(Calendar.HOUR_OF_DAY);
        this.mins = datetime.get(Calendar.MINUTE);
        this.status = "[\u2718]";
    }

    @Override
    public String text() {
        return this.text + "(by: " + day + " " + month.getDisplayName(FULL, Locale.ENGLISH)
                         + " " + year + " " + hour + (mins > 9 ? mins : "0" + mins) + ")";
    }

    @Override
    public String status() {
        return "[" + nodetype + "]"+ status;
    }

    public char showtype() {
        return nodetype;
    }
}