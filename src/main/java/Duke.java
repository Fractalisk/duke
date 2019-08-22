import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n"
                +"\n"
                + "    ____________________________________________________________\n"
                + "     Hello! I'm Duke\n"
                + "     What can I do for you?\n"
                + "    ____________________________________________________________\n";
        System.out.println("Hello from\n" + logo);
        Scanner inputparser = new Scanner(System.in);
        String userinput = "init";
        while (true) {
            userinput = inputparser.nextLine();
            if (userinput.equals("bye")) {
                String endlogo = "    ____________________________________________________________\n"
                          + "     Bye. Hope to see you again soon!\n"
                          + "    ____________________________________________________________\n";
                System.out.println(endlogo);
                break;
            }
            else {
                String echo = "    ____________________________________________________________\n"
                          + "     " + userinput + "\n"
                          + "    ____________________________________________________________\n";
                System.out.println(echo);
            }
        }
    }
}
