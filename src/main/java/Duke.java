import java.util.Scanner;

/**
 * This is the main class, used in absence of GUI
 */

public class Duke {
    private static Scanner datainput = new Scanner(System.in);
    private static Inputparser interpreter = new Inputparser();

    /** This is the main function
     * @param args
     */
    public static void main(String[] args) {
        Printer.init();
        String userinput;
        int handler;
        interpreter.parseSave();
        while (true) {
            userinput = datainput.nextLine();
            handler = interpreter.parse(userinput);
            if (handler == 0) {
                break;
            }
        }
        interpreter.writesave();
        interpreter.closesave();
    }
}
