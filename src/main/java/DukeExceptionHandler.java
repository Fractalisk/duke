import java.util.Scanner;

public class DukeExceptionHandler {

    private static Printer jout = new Printer();

    public static int doneInput() {
        jout.print("☹ OOPS!!! It appears the command was entered wrongly.\n      Try \"done *insert index here*\"");
        return 1;
    }
    public static int doneBound() {
        jout.print("☹ OOPS!!! It appears an invalid index was entered.\n     Please try again.");
        return 1;
    }
    public static int unknown() {
        jout.print("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        return -1;
    }
    public static int deadlineInput() {
        jout.print("☹ OOPS!!! It appears the command was entered wrongly.\n      Try \"deadline *insert info here* /by *deadline*\"");
        return 1;
    }
    public static int eventInput() {
        jout.print("☹ OOPS!!! It appears the command was entered wrongly.\n      Try \"event *insert info here* /at *venue*\"");
        return 1;
    }
    public static int memoryfull() {
        jout.print("☹ OOPS!!! It appears you have reached the maximum memory allocated to duke.\n     It is now impossible to add more entries");
        return 1;
    }
    public static int fieldempty() {
        jout.print("☹ OOPS!!! It appears your command has a few missing fields\n" +
                "     please try again.");
        return 1;
    }
    public static int removeinput() {
        jout.print("☹ OOPS!!! It appears your command has a few input errors.\n" +
                "     Please try again.");
        return 1;
    }

}
