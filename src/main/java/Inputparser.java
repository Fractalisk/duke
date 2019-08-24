import java.util.Scanner;

public class Inputparser {

    Printer jout = new Printer();
    List jlist = new List();
    String temp;

    public int parse(String COMMAND, Scanner datainput) {
        switch(COMMAND) {
            case "bye":
                jout.print("Bye. Hope to see you again soon!");
                return 0;
            case "list":
                jout.list(jlist);
                return 1;
            case "done":
                int index = datainput.nextInt();
                jlist.markdone(index-1);
                jout.done(jlist, index-1);
                return 2;
            case "todo":
                String userinput = datainput.nextLine();
                jlist.addTodo(userinput);
                jout.addTodo(jlist);
                return 3;
            case "deadline":
                temp = datainput.nextLine();
                String[] userinput1 = temp.split("/by");
                jlist.addDeadline(userinput1[0], userinput1[1]);
                jout.addDeadlineEvent(jlist);
                return 4;
            case "event":
                temp = datainput.nextLine();
                String[] userinput2 = temp.split("/at");
                jlist.addEvent(userinput2[0], userinput2[1]);
                jout.addDeadlineEvent(jlist);
                return 5;
        }
        return -1;
    }
}
