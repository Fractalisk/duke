import java.util.Scanner;

public class Duke {
    private static Scanner datainput = new Scanner(System.in);
    private static Inputparser interpreter = new Inputparser();

    public static void main(String[] args) {
        Printer.init();
        String userinput;
        int handler;
        while (true) {
            userinput = datainput.next();
            handler = interpreter.parse(userinput, datainput);
            if (handler == 0) {
                break;
            }
        }
    }
}
