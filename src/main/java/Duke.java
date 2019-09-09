import java.util.Scanner;

public class Duke {
    private static Scanner datainput = new Scanner(System.in);
    private static Inputparser interpreter = new Inputparser();

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
