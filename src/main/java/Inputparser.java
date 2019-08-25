import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputparser {

    private Printer jout = new Printer();
    private List jlist = new List();
    private String temp;
    private DukeExceptionHandler dukeException = new DukeExceptionHandler();
    private static SaveUtil savehandler = new SaveUtil();


    public int parse(String COMMAND, Scanner datainput) {
        switch(COMMAND) {
            case "bye":
                jout.print("Bye. Hope to see you again soon!");
                return 0;
            case "list":
                jout.list(jlist);
                return 1;
            case "done":
                int index = 1;
                try {
                    index = datainput.nextInt();
                    jlist.markdone(index - 1);
                    jout.done(jlist, index - 1);
                } catch (ArrayIndexOutOfBoundsException e) {
                    datainput.nextLine();
                    return DukeExceptionHandler.doneBound();
                } catch (NullPointerException e) {
                    datainput.nextLine();
                    return DukeExceptionHandler.doneBound();
                } catch(InputMismatchException e) {
                    datainput.nextLine();
                    return DukeExceptionHandler.doneInput();
                }
                return 2;
            case "todo":
                String userinput = datainput.nextLine();
                jlist.addTodo(userinput);
                jout.addTodo(jlist);
                return 3;
            case "deadline":
                try {
                    temp = datainput.nextLine();
                    String[] userinput1 = temp.split("/by");
                    jlist.addDeadline(userinput1[0], userinput1[1]);
                    jout.addDeadlineEvent(jlist);
                    return 4;
                } catch (ArrayIndexOutOfBoundsException e) {
                    return DukeExceptionHandler.deadlineInput();
                }
            case "event":
                try {
                    temp = datainput.nextLine();
                    String[] userinput2 = temp.split("/at");
                    jlist.addEvent(userinput2[0], userinput2[1]);
                    jout.addDeadlineEvent(jlist);
                    return 5;
                } catch (ArrayIndexOutOfBoundsException e) {
                    return DukeExceptionHandler.eventInput();
                }
        }
        datainput.nextLine();;
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
