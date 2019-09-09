/**
 * This class extends the Node class, adding additional data required for a Todo type entry
 */
public class Todo extends Node{

    private char nodetype = 'T';

    /**
     * This is the initialization function for a Todo class
     * @param description the description text associated with a todo class
     */
    public Todo(String description) {
        this.text = description;
        this.status = "[\u2718]";
    }
    /**
     * This function returns a String containing status information
     * @return A string containing status information
     */
    @Override
    public String status() {
        return "[" + nodetype + "]"+ status;
    }
}
