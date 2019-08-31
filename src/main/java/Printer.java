import java.util.ArrayList;

public class Printer {
    private static final String MARGIN = "_________________________________________________\n";
    private static final String TAB = "";
    private static final String ADD = "Got it. I've added this task:\n";

    public static String init() {
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
        return ("Hello from\n" + logo);
    }

    public String print(String input) {
        String useroutput = MARGIN
                + TAB + input + "\n"
                + MARGIN;
        return (useroutput);
    }

    public String addTodo(List input) {
        int marker = input.nodecount();
        String useroutput = MARGIN
                + TAB + ADD
                + TAB + input.nodestatus(marker-1) + input.nodetext(marker-1) + "\n"
                + TAB + "Now you have " + (marker) + " task" + (marker > 1 ? "s in the list.": " in the list.") + "\n"
                + MARGIN;
        return (useroutput);
    }

    public String addDeadlineEvent(List input) {
        int marker = input.nodecount();
        String useroutput = MARGIN
                + TAB + ADD
                + TAB + input.nodestatus(marker-1) + input.nodetext(marker-1) + "\n"
                + TAB + "Now you have " + (marker) + " task" + (marker > 1 ? "s in the list.": " in the list.") + "\n"
                + MARGIN;
        return (useroutput);
    }

    public String list(List input) {
        int counter = 0;
        String useroutput = MARGIN +
                            TAB + "Here are the tasks in your list:\n";
        while (counter < input.nodecount()) {
            useroutput += TAB + (counter+1) + "."
                          + input.nodestatus(counter)
                          + input.nodetext(counter) + "\n";
            counter++;
        }
        useroutput += MARGIN;
        return useroutput;
    }

    public String done(List input, int index) {
        String useroutput = MARGIN
                        + TAB + "Nice! I've marked this task as done:\n"
                        + TAB + "[\u2713]" + input.nodetext(index) + "\n"
                        + MARGIN;
        return useroutput;
    }
    public String found(List input, ArrayList<Integer> id) {
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
            return useroutput;
        } else {
            System.out.print(MARGIN);
            System.out.println(TAB + "☹ OOPS!!! It appears there were no relevant results found.");
            System.out.print(MARGIN);
            return null;
        }
    }

    public String remove(List input, int index) {
        int nodecount = input.nodecount();
        String useroutput = MARGIN
                + TAB + "Noted. I've removed this task:\n"
                + TAB + input.nodestatus(index-1) + input.nodetext(index-1) + "\n"
                + TAB + "Now you have " + (nodecount-1) + " task" + (nodecount > 1 ? "s in the list.": " in the list.") + "\n"
                + MARGIN;
        return (useroutput);
    }

}
