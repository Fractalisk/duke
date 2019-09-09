import java.io.*;

public class SaveUtil {

    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    /**
     * Initialization function for SaveUtil. Attempts to find a valid savefile, and if non-existent, create a new one
     */
    public SaveUtil() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("savedata", true));
            bufferedReader = new BufferedReader(new FileReader("savedata"));
        } catch (IOException e) {
            System.out.println("     Unhandled exception occurred");
        }
    }

    /**
     * This function reads from the save file that was either found or created in the initialization function
     * It then translates the data from the save and stores it in a List object
     * @param jlist List object to store translated data
     * @return 0 when the function finishes execution
     */
    public int readsave(List jlist) {
        try {
            int marker = 0;
            String data = bufferedReader.readLine();
            while(data != null) {
                String[] temp = data.split("\\|");
                switch (temp[0]) {
                    case "T":
                        jlist.addTodo(temp[2]);
                        if (temp[1].equals("1")) {
                            jlist.markdone(marker);
                        }
                        break;
                    case "D":
                        jlist.addDeadline(temp[2], temp[3]);
                        if (temp[1].equals("1")) {
                            jlist.markdone(marker);
                        }
                        break;
                    case "E":
                        jlist.addEvent(temp[2], temp[3]);
                        if (temp[1].equals("1")) {
                            jlist.markdone(marker);
                        }
                        break;
                }
                marker++;
                data = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter("savedata"));
                bufferedReader = new BufferedReader(new FileReader("savedata"));
            } catch (IOException d) {
                System.out.println("     Unhandled exception occurred");
            }
        } catch (IOException e) {
            System.out.println("     Unhandled exception occurred");
        }
        return 0;
    }

    /**
     * This function takes in a List object and translates it into data to be stored in the savefile
     * @param jlist List object to be translated into savefile
     * @return 0 when the function finishes execution
     */
    public int writesave(List jlist) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("savedata"));
            int nodecount = jlist.nodecount();
            int counter = 0;
            String status = "";
            String entry = "";
            while (counter < jlist.nodecount()) {
                status = jlist.nodestatus(counter);
                if (status.contains("T")) {
                    entry += "T|";
                    if (status.contains("[\u2713]")) {
                        entry += "1|";
                    }
                    else {
                        entry += "0|";
                    }
                    entry += jlist.nodetext(counter);
                }
                if (status.contains("D")) {
                    entry += "D|";
                    if (status.contains("[\u2713]")) {
                        entry += "1|";
                    }
                    else {
                        entry += "0|";
                    }
                    String[] temp1 = jlist.nodetext(counter).split("\\(by:");
                    entry += temp1[0] + "|" + temp1[1];
                    entry = entry.substring(0, entry.length() - 1);
                }
                if (status.contains("E")) {
                    entry += "E|";
                    if (status.contains("[\u2713]")) {
                        entry += "1|";
                    }
                    else {
                        entry += "0|";
                    }
                    String[] temp1 = jlist.nodetext(counter).split("\\(at:");
                    entry += temp1[0] + "|" + temp1[1];
                    entry = entry.substring(0, entry.length() - 1);
                }
                bufferedWriter.write(entry + "\n");
                entry = "";
                counter++;
            }
        } catch (FileNotFoundException e) {
            try {
                System.out.println("     exception caught");
                bufferedWriter = new BufferedWriter(new FileWriter("savedata"));
                bufferedReader = new BufferedReader(new FileReader("savedata"));
            } catch (IOException d) {
                System.out.println("     Unhandled exception occurred");
            }
        } catch (IOException e) {
            System.out.println("     Unhandled exception occurred");
        }
        return 0;
    }

    /**
     * This function closes the write buffer to the savefile, completing the write process
     * @return 0 when the function finishes execution
     */
    public int closesave() {
        try {
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("     Unhandled exception occurred: Unable to save to savefile");
        }
        return 0;
    }

}
