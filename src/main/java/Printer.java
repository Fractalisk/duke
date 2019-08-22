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
        while (counter < input.stored()) {
            System.out.println("     " + input.list()[counter]);
            counter++;
        }
        System.out.println("    ____________________________________________________________");
    }
}
