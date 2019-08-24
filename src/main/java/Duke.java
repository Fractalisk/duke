import java.util.Scanner;

public class Duke {
    private static Scanner datainput = new Scanner(System.in);
    private static Inputparser interpreter = new Inputparser();

    public static void main(String[] args) {
        String userinput;
        while (true) {
            userinput = datainput.next();
            int handler = interpreter.parse(userinput, datainput);
            if (handler == 0 || handler == -1){
                break;
            }
        }
    }
}
