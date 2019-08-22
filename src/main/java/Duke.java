import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Printer jout = new Printer();
        List jlist = new List();
        jout.init();
        Scanner inputparser = new Scanner(System.in);
        String userinput;
        while (true) {
            userinput = inputparser.nextLine();
            if (userinput.equals("bye")) {
                jout.print("Bye. Hope to see you again soon!");
            }
            else if (userinput.equals("list")) {
                jout.list(jlist);
            }
            else {
                jout.add(userinput);
                jlist.add(userinput);
            }
        }
    }
}
