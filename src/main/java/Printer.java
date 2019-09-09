import java.util.ArrayList;

/**
 * This public class is used to handle almost all of the program's needs in printing text to user in console
 */
public class Printer {
    private static final String MARGIN = "    ____________________________________________________________\n";
    private static final String TAB = "     ";
    private static final String ADD = "Got it. I've added this task:\n";

    /**
     * this function is called once at the start of the program to print the welcome message
     */
    public static void init() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n"
                +"\n"
                + MARGIN
                + TAB + "Hello! I'm Duke\n"
                + TAB + "What can I do for you?\n"
                + MARGIN;
        System.out.print("Hello from\n" + logo);
    }

    /**
     * This function is a generic function to add formatting to a input string before it is printed out to the user
     * @param input the input string to be printed
     */
    public void print(String input) {
        String useroutput = MARGIN
                + TAB + input + "\n"
                + MARGIN;
        System.out.print(useroutput);
    }

    /**
     * This function is called to print to the user a message acknowledging a todo task has been added to the List
     * @param input a descriptor of the todo task added to the list
     */
    public void addTodo(List input) {
        int marker = input.nodecount();
        String useroutput = MARGIN
                + TAB + ADD
                + TAB + input.nodestatus(marker-1) + input.nodetext(marker-1) + "\n"
                + TAB + "Now you have " + (marker) + " task" + (marker > 1 ? "s in the list.": " in the list.") + "\n"
                + MARGIN;
        System.out.print(useroutput);
    }
    /**
     * This function is called to print to the user a message acknowledging a
     * deadline or event task has been added to the List
     * @param input a descriptor of the deadline or event task added to the list
     */
    public void addDeadlineEvent(List input) {
        int marker = input.nodecount();
        String useroutput = MARGIN
                + TAB + ADD
                + TAB + input.nodestatus(marker-1) + input.nodetext(marker-1) + "\n"
                + TAB + "Now you have " + (marker) + " task" + (marker > 1 ? "s in the list.": " in the list.") + "\n"
                + MARGIN;
        System.out.print(useroutput);
    }

    /**
     * this function is used to print out the contents in a List to the user
     * @param input The List object to be printed
     */
    public void list(List input) {
        int counter = 0;
        System.out.print(MARGIN);
        System.out.println(TAB + "Here are the tasks in your list:");
        while (counter < input.nodecount()) {
            System.out.print(TAB + (counter+1) + "." );
            System.out.print(input.nodestatus(counter));
            System.out.println(input.nodetext(counter));
            counter++;
        }
        System.out.println(MARGIN);
    }

    /**
     * this function is called to print a message acknowledging a certain numbered task in the List
     * object has been marked as done
     * @param input The list from which a object has been marked as done
     * @param index The index of the object in the list to be marked done
     */
    public void done(List input, int index) {
        System.out.print(MARGIN);
        System.out.println(TAB + "Nice! I've marked this task as done:");
        System.out.println(TAB + "[\u2713]" + input.nodetext(index));
        System.out.print(MARGIN);
    }

    /**
     * This function is called to find a entry in a given List
     * @param input This is the List object to be searched
     * @param id This is the list of indexes corresponding to entries that match the search parameters in the List
     */
    public void found(List input, ArrayList<Integer> id) {
        int limit = id.size();
        int marker = 0;
        if (limit > 0) {
            String useroutput = MARGIN
                    + TAB + "Here are the matching tasks in your list:\n";
            while (marker < limit) {
                int temp = id.get(marker) - 1;
                useroutput += TAB + id.get(marker) + ". " + input.nodestatus(temp) + input.nodetext(temp) + "\n";
                marker++;
            }
            useroutput += MARGIN;
            System.out.print(useroutput);
        } else {
            System.out.print(MARGIN);
            System.out.println(TAB + "☹ OOPS!!! It appears there were no relevant results found.");
            System.out.print(MARGIN);
        }
    }

    /**
     * this function prints a message to the user acknowledging that an entry has been deleted from the List object
     * @param input The List object from which an entry is deleted
     * @param index The index of the entry to be deleted
     */
    public void remove(List input, int index) {
        int nodecount = input.nodecount();
        String useroutput = MARGIN
                + TAB + "Noted. I've removed this task:\n"
                + TAB + input.nodestatus(index-1) + input.nodetext(index-1) + "\n"
                + TAB + "Now you have " + (nodecount-1) + " task" + (nodecount > 1 ? "s in the list.": " in the list.") + "\n"
                + MARGIN;
        System.out.print(useroutput);
    }

}
