import java.util.ArrayList;

public class Printer {
    private static final String MARGIN = "    ____________________________________________________________\n";
    private static final String TAB = "     ";
    private static final String ADD = "Got it. I've added this task:\n";

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

    public void print(String input) {
        String useroutput = MARGIN
                + TAB + input + "\n"
                + MARGIN;
        System.out.print(useroutput);
    }

    public void addTodo(List input) {
        int marker = input.nodecount();
        String useroutput = MARGIN
                + TAB + ADD
                + TAB + input.nodestatus(marker-1) + input.nodetext(marker-1) + "\n"
                + TAB + "Now you have " + (marker) + " task" + (marker > 1 ? "s in the list.": " in the list.") + "\n"
                + MARGIN;
        System.out.print(useroutput);
    }

    public void addDeadlineEvent(List input) {
        int marker = input.nodecount();
        String useroutput = MARGIN
                + TAB + ADD
                + TAB + input.nodestatus(marker-1) + input.nodetext(marker-1) + "\n"
                + TAB + "Now you have " + (marker) + " task" + (marker > 1 ? "s in the list.": " in the list.") + "\n"
                + MARGIN;
        System.out.print(useroutput);
    }

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

    public void done(List input, int index) {
        System.out.print(MARGIN);
        System.out.println(TAB + "Nice! I've marked this task as done:");
        System.out.println(TAB + "[\u2713]" + input.nodetext(index));
        System.out.print(MARGIN);
    }
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
