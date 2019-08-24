interface printcommands {
    public void init();
    public void print(String input1);
    public void add(String input1);
    public void list(List input1);
}

public class Printer implements printcommands {
    public void init() {
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
    }

    public void print(String input) {
        String useroutput = "    ____________________________________________________________\n"
                + "     " + input + "\n"
                + "    ____________________________________________________________\n";
        System.out.println(useroutput);
    }

    public void add(String input) {
        String useroutput = "    ____________________________________________________________\n"
                + "     " + "added: " + input + "\n"
                + "    ____________________________________________________________\n";
        System.out.println(useroutput);
    }

    public void list(List input) {
        int counter = 0;
        System.out.println("    ____________________________________________________________");
        System.out.println("    " + "Here are the tasks in your list:");
        while (counter < input.stored()) {
            System.out.print("     " + String.valueOf(counter+1) + "." );
            if (input.isdone(counter) == true) {
                System.out.print("[\u2713]");
            }
            else {
                System.out.print("[\u2718]");
            }
            System.out.println(input.list(counter));

            counter++;
        }
        System.out.println("    ____________________________________________________________");
    }

    public void done(List input, int index) {
        System.out.println("    ____________________________________________________________");
        System.out.println("    " + "Nice! I've marked this task as done:");
        System.out.println("     [\u2713]" + input.list(index));
        System.out.println("    ____________________________________________________________");
    }

}
