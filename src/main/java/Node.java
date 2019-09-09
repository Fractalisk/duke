/**
 * this public class is used to store information in the program
 */
public class Node {
    protected String text;
    protected String status;

    /**
     * This function is used to access the text string variable
     * @return text Returns a string containing the text data stored in the node
     */
    public String text() {
        return text;
    }

    /**
     * This function is used to access the status string variable
     * @return status Returns a string containing the text data stored in the node
     */
    public String status() {
        return status;
    }

    /**
     * This is the initialization function for a Node object
     * @param description This is the text associated with each Node object at its instantiation
     */
    public Node(String description) {
        this.text = description;
        this.status = "[\u2718]";
    }
    /**
     * This is the initialization function for a Node object
     */
    public Node() {
        this.text = "";
        this.status = "[\u2718]";
    }

    /**
     * This changes the status of the node to mark it as done
     */
    public void setdone() {
        this.status = "[\u2713]";
    }
}
