import java.util.ArrayList;
import java.util.Scanner;

public class Inputparser {

    private Printer jout = new Printer();
    private List jlist = new List();
    private String temp;
    private DukeExceptionHandler dukeException = new DukeExceptionHandler();
    private static SaveUtil savehandler = new SaveUtil();
    private static int MAX = 100;

    public String parse(String COMMAND, Scanner datainput) {
        switch(COMMAND) {
            case "|init|":
                return jout.init();
            case "bye":
                savehandler.writesave(jlist);
                savehandler.closesave();
                return "Bye. Hope to see you again soon!";
            case "list":
                try {
                    datainput.nextLine();
                } catch (Exception e) {
                    //do nothing
                }
                return jout.list(jlist);
            case "done":
                int index = 1;
                try {
                    index = Integer.parseInt(datainput.nextLine());
                    jlist.markdone(index - 1);
                    return jout.done(jlist, index - 1);
                } catch (NumberFormatException e) {
                    return DukeExceptionHandler.doneBound();
                } catch (Exception f) {
                    return DukeExceptionHandler.doneInput();
                }
            case "todo":
                if (jlist.nodecount() == MAX) {
                    return DukeExceptionHandler.memoryfull();
                }
                String userinput;
                try {
                    userinput = datainput.nextLine();
                } catch (Exception e) {
                    return DukeExceptionHandler.fieldempty();
                }
                jlist.addTodo(userinput);
                return jout.addTodo(jlist);
            case "deadline":
                if (jlist.nodecount() == MAX) {
                    return DukeExceptionHandler.memoryfull();
                }
                try {
                    temp = datainput.nextLine();
                    String[] userinput1 = temp.split("/by");
                    if (userinput1[0].trim().length() == 0 || userinput1[1].trim().length() == 0) {
                        return DukeExceptionHandler.fieldempty();
                    }
                    jlist.addDeadline(userinput1[0], userinput1[1]);
                    return jout.addDeadlineEvent(jlist);
                } catch (ArrayIndexOutOfBoundsException e) {
                    return DukeExceptionHandler.deadlineInput();
                }
            case "event":
                if (jlist.nodecount() == MAX) {
                    datainput.nextLine();
                    return DukeExceptionHandler.memoryfull();
                }
                try {
                    temp = datainput.nextLine();
                    String[] userinput2 = temp.split("/at");
                    if (userinput2[0].trim().length() == 0 || userinput2[1].trim().length() == 0) {
                        return DukeExceptionHandler.fieldempty();
                    }
                    jlist.addEvent(userinput2[0], userinput2[1]);
                    return jout.addDeadlineEvent(jlist);
                } catch (ArrayIndexOutOfBoundsException e) {
                    return DukeExceptionHandler.eventInput();
                }
            case "delete" :
                try {
                    index = datainput.nextInt();
                    String temp = jout.remove(jlist, index);
                    jlist.remove(index-1);
                    return temp;
                } catch (NumberFormatException e) {
                    return dukeException.removeoob();
                } catch (Exception f) {
                    return dukeException.removeinput();
                }
            case "find" :
                try {
                    temp = datainput.nextLine().trim();
                    ArrayList<Integer> temp1 = new ArrayList<Integer>();
                    jlist.findNode(temp, temp1);
                    return jout.found(jlist, temp1);
                } catch (Exception e) {
                    return dukeException.removeinput();
                }

        }
        return DukeExceptionHandler.unknown();
    }

    public void parseSave() {
        savehandler.readsave(jlist);
    }
}
