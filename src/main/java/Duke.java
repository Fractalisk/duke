import javafx.fxml.FXML;

import java.util.Scanner;

public class Duke {

    private static Inputparser interpreter = new Inputparser();
    private static String userinput;
    private static String handler;

    public static void main(String[] args) {
    }

    @FXML
    public static void load() {
        interpreter.parseSave();
    }

    @FXML
    public String getResponse(String userinput) {
        Scanner datainput = new Scanner(userinput);
        String usercommand = datainput.next();
        handler = interpreter.parse(usercommand, datainput);
        return handler;
    }

}
