import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class is used to parse all user inputs from the console
 */
public class Inputparser {

    private static Printer jout = new Printer();
    private static List jlist = new List();
    private static String temp;
    private static DukeExceptionHandler dukeException = new DukeExceptionHandler();
    private static SaveUtil savehandler = new SaveUtil();
    private static int MAX = 100;

    /**
     * This program takes in a string USERINPUT, and parses it into its relevant commands
     * @param USERINPUT
     * @return an integer from 0-7 depending on the command parsed
     */
    public static int parse(String USERINPUT) {
        Scanner datainput = new Scanner(USERINPUT);
        String COMMAND = datainput.next();
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
                    index = Integer.parseInt(datainput.nextLine());
                    jlist.markdone(index - 1);
                    jout.done(jlist, index - 1);
                } catch (NumberFormatException e) {
                    return DukeExceptionHandler.doneBound();
                } catch (Exception f) {
                    return DukeExceptionHandler.doneInput();
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
                } catch (Exception e) {
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
                } catch (Exception e) {
                    return DukeExceptionHandler.eventInput();
                }
            case "delete" :
                try {
                    index = datainput.nextInt();
                    jout.remove(jlist, index);
                    jlist.remove(index-1);
                    return 6;
                } catch (IndexOutOfBoundsException e) {
                    datainput.nextLine();
                    return dukeException.removeoob();
                } catch (Exception f) {
                    datainput.nextLine();
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

    /**
     * this function reads from the savefile found in the project's main directory
     */
    public void parseSave() {
        savehandler.readsave(jlist);
    }

    /**
     * this function writes to the buffer of the savefile found in the project's main directory
     */
    public void writesave () {
        savehandler.writesave(jlist);
    }
    /**
     * this function writes from the buffer to the savefile found in the project's main directory
     */
    public void closesave() {
        savehandler.closesave();
    }
}
