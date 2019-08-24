
public class List {
    protected Node[] memory = new Node[100];
    protected int objectcount = 0;

    public void add(String input) {
        memory[objectcount] = new Node(input);
        objectcount++;
    }

    public void addTodo(String input) {
        memory[objectcount] = new Todo(input);
        objectcount++;
    }
    public void addDeadline(String input, String datetime) {
        memory[objectcount] = new Deadline(input, datetime);
        objectcount++;
    }
    public void addEvent(String input, String datetime) {
        memory[objectcount] = new Event(input, datetime);
        objectcount++;
    }

    public String nodetext(int input) {
        return memory[input].text();
    }

    public String nodestatus(int input) {
        return memory[input].status();
    }

    public int nodecount() {
        return objectcount;
    }

    public void markdone(int input) {
        memory[input].setdone();
    }
}
