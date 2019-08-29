import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class List {
    protected ArrayList<Node> memory = new ArrayList<Node>();
    protected int objectcount = 0;

    public void addTodo(String input) {
        memory.add(new Todo(input));
        objectcount = memory.size();
    }

    public void addDeadline(String input, String datetime) {
        SimpleDateFormat dateparser = new SimpleDateFormat("dd/MM/yyyy HHmm");
        Calendar cal = Calendar.getInstance();
        Date date;
        try {
            date = dateparser.parse(datetime);
            cal.setTime(date);
        } catch (ParseException e) {
            SimpleDateFormat altparser = new SimpleDateFormat("dd MMMM yyyy hh.mm a");
            try {
                date = altparser.parse(datetime);
                cal.setTime(date);
            } catch (ParseException f) {
                cal = null;
            }
        }
        memory.add(new Deadline(input, datetime, cal));
        objectcount = memory.size();
    }

    public void addEvent(String input, String datetime) {
        SimpleDateFormat dateparser = new SimpleDateFormat("dd/MM/yyyy HHmm");
        Date date;
        Calendar cal = Calendar.getInstance();
        try {
            date = dateparser.parse(datetime);
            cal.setTime(date);
        } catch (ParseException e) {
            SimpleDateFormat altparser = new SimpleDateFormat("dd MMMM yyyy hh.mm a");
            try {
                date = altparser.parse(datetime);
                cal.setTime(date);
            } catch (ParseException f) {
                cal = null;
            }
        }
        memory.add(new Event(input, datetime, cal));
        objectcount = memory.size();
    }
    public void findNode(String input, ArrayList<Integer> templist1) {
        for (int i = 0; i < memory.size(); i++) {
            if (memory.get(i).text().contains(input)) {
                templist1.add(i+1);
            }
        }
    }

    public String nodetext(int input) {
        return memory.get(input).text();
    }

    public String nodestatus(int input) {
        return memory.get(input).status();
    }

    public int nodecount() {
        return objectcount;
    }

    public void markdone(int input) {
        Node temp = memory.get(input);
        temp.setdone();
        memory.set(input, temp);
    }

    public void remove(int input) {
        memory.remove(input);
        objectcount = memory.size();
    }
}
