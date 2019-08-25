import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class List {
    protected Node[] memory = new Node[100];
    protected int objectcount = 0;

    public void add(String input) {
        memory[objectcount] = new Node(input);
        objectcount++;
    }

    public void addTodo(String input) {
        memory[objectcount] = new Todo(input);
        objectcount++;
    }

    public void addDeadline(String input, String datetime) {
        SimpleDateFormat dateparser = new SimpleDateFormat("dd/MM/yyyy HHmm");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        try {
            date = dateparser.parse(datetime);
            cal.setTime(date);
        } catch (ParseException e) {
            System.out.println("     Error when parsing date");
        }
        memory[objectcount] = new Deadline(input, cal);
        objectcount++;
    }

    public void addEvent(String input, String datetime) {
        SimpleDateFormat dateparser = new SimpleDateFormat("dd/MM/yyyy HHmm");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        try {
            date = dateparser.parse(datetime);
            cal.setTime(date);
        } catch (ParseException e) {
            System.out.println("     Error when parsing date");
        }
        memory[objectcount] = new Deadline(input, cal);
        objectcount++;
    }

    public String nodetext(int input) {
        return memory[input].text();
    }

    public String nodestatus(int input) {
        return memory[input].status();
    }

    public int nodecount() {
        return objectcount;
    }

    public void markdone(int input) {
        memory[input].setdone();
    }
}
