import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputparser {

    private Printer jout = new Printer();
    private List jlist = new List();
    private String temp;
    private DukeExceptionHandler dukeException = new DukeExceptionHandler();
    private static SaveUtil savehandler = new SaveUtil();
    private static int MAX = 100;

    public int parse(String COMMAND, Scanner datainput) {
        switch(COMMAND) {
            case "bye":
                jout.print("Bye. Hope to see you again soon!");
                return 0;
            case "list":
                jout.list(jlist);
                datainput.nextLine();
                return 1;
            case "done":
                int index = 1;
                try {
                    index = datainput.nextInt();
                    jlist.markdone(index - 1);
                    jout.done(jlist, index - 1);
                } catch(InputMismatchException e) {
                    datainput.nextLine();
                    return DukeExceptionHandler.doneInput();
                } catch (Exception e) {
                    datainput.nextLine();
                    return DukeExceptionHandler.doneBound();
                }
                return 2;
            case "todo":
                if (jlist.nodecount() == MAX) {
                    datainput.nextLine();
                    return DukeExceptionHandler.memoryfull();
                }
                String userinput = datainput.nextLine();
                if (userinput.trim().length() == 0) {
                    return DukeExceptionHandler.fieldempty();
                }
                jlist.addTodo(userinput);
                jout.addTodo(jlist);
                return 3;
            case "deadline":
                if (jlist.nodecount() == MAX) {
                    datainput.nextLine();
                    return DukeExceptionHandler.memoryfull();
                }
                try {
                    temp = datainput.nextLine();
                    String[] userinput1 = temp.split("/by");
                    if (userinput1[0].trim().length() == 0 || userinput1[1].trim().length() == 0) {
                        return DukeExceptionHandler.fieldempty();
                    }
                    jlist.addDeadline(userinput1[0], userinput1[1]);
                    jout.addDeadlineEvent(jlist);
                    return 4;
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
                    jout.addDeadlineEvent(jlist);
                    return 5;
                } catch (ArrayIndexOutOfBoundsException e) {
                    return DukeExceptionHandler.eventInput();
                }
            case "delete" :
                try {
                    index = datainput.nextInt();
                    jout.remove(jlist, index);
                    jlist.remove(index-1);
                    return 6;
                } catch (IndexOutOfBoundsException e) {
                    return dukeException.removeoob();
                } catch (Exception e) {
                    return dukeException.removeinput();
                }
            case "find" :
                try {
                    temp = datainput.nextLine().trim();
                    ArrayList<Integer> temp1 = new ArrayList<Integer>();
                    jlist.findNode(temp, temp1);
                    jout.found(jlist, temp1);
                    return 7;
                } catch (Exception e) {
                    return dukeException.removeinput();
                }

        }
        datainput.nextLine();
        return DukeExceptionHandler.unknown();
    }

    public void parseSave() {
        savehandler.readsave(jlist);
    }

    public void writesave () {
        savehandler.writesave(jlist);
    }

    public void closesave() {
        savehandler.closesave();
    }
}
