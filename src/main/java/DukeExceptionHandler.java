public class DukeExceptionHandler {

    private static Printer jout = new Printer();

    public static String doneInput() {
        return jout.print("☹ OOPS!!! It appears the command was entered wrongly.\n      Try \"done *insert index here*\"");
    }
    public static String doneBound() {
        return jout.print("☹ OOPS!!! It appears an invalid index was entered.\n     Please try again.");
    }
    public static String unknown() {
        return jout.print("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
    public static String deadlineInput() {
        return jout.print("☹ OOPS!!! It appears the command was entered wrongly.\n      Try \"deadline *insert info here* /by *deadline*\"");
    }
    public static String eventInput() {
        return jout.print("☹ OOPS!!! It appears the command was entered wrongly.\n      Try \"event *insert info here* /at *venue*\"");
    }
    public static String memoryfull() {
        return jout.print("☹ OOPS!!! It appears you have reached the maximum memory allocated to duke.\n     It is now impossible to add more entries");
    }
    public static String fieldempty() {
        return jout.print("☹ OOPS!!! It appears your command has a few missing fields\n" +
                "     please try again.");
    }
    public static String removeoob() {
        return jout.print("☹ OOPS!!! It appears you are trying to delete a nonexistent entry\n" +
                "     Please try again.");
    }
    public static String removeinput() {
        return jout.print("☹ OOPS!!! It appears your command has a few input errors.\n" +
                "     Please try again.");
    }

}
