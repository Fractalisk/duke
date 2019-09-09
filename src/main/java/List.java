import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * This class is used to store an array of Node type data structures, and perform functions related to them
 */
public class List {
    protected ArrayList<Node> memory = new ArrayList<Node>();
    protected int objectcount = 0;

    /**
     * Adds a Todo type entry to the array of Node
     * @param input The text associated with the Todo entry
     */
    public void addTodo(String input) {
        memory.add(new Todo(input));
        objectcount = memory.size();
    }

    /**
     * Adds a Deadline type entry to the array of Node
     * @param input The text associated with the Deadline entry
     * @param datetime The datetime associated with the Deadline entry
     */
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

    /**
     * Adds a Event type entry to the array of Node
     * @param input The text associated with the Event entry
     * @param datetime The datetime associated with the Event entry
     */
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

    /**
     * Given a keyword, find all the indexes associated with the keyword in the List
     * @param input The keyword to be used
     * @param templist1 The array used to store the indexes associated with the keyword
     */
    public void findNode(String input, ArrayList<Integer> templist1) {
        for (int i = 0; i < memory.size(); i++) {
            if (memory.get(i).text().contains(input)) {
                templist1.add(i+1);
            }
        }
    }

    /**
     * This function returns the text associated with an entry given its index number
     * @param input the index of the entry
     * @return A string associated with the entry at the given index number
     */
    public String nodetext(int input) {
        return memory.get(input).text();
    }
    /**
     * This function returns the status associated with an entry given its index number
     * @param input the index of the entry
     * @return A string associated with the status at the given index number
     */
    public String nodestatus(int input) {
        return memory.get(input).status();
    }

    /**
     * This function returns the total number of objects present in the List object
     * @return An integer representing the total number of objects present in the List
     */
    public int nodecount() {
        return objectcount;
    }

    /**
     * Given a index, sets the entry at the index as done in the List
     * @param input The index of the entry to be marked as done
     */
    public void markdone(int input) {
        Node temp = memory.get(input);
        temp.setdone();
        memory.set(input, temp);
    }

    /**
     * Given a index, removes the entry at the index in the List
     * @param input The index of the entry to be removed
     */
    public void remove(int input) {
        memory.remove(input);
        objectcount = memory.size();
    }
}
