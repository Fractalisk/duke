public class Deadline extends Node{

    private char nodetype = 'D';
    private String datetime;

    public Deadline(String description, String datetime) {
        this.text = description;
        this.datetime = datetime;
        this.status = "[\u2718]";
    }

    @Override
    public String text() {
        return this.text + "(by:" + datetime + ")";
    }

    @Override
    public String status() {
        return "[" + nodetype + "]"+ status;
    }

    public char showtype() {
        return nodetype;
    }
}