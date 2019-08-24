public class Event extends Node{

    private char nodetype = 'E';
    private String datetime;

    public Event(String description, String datetime) {
        this.text = description;
        this.datetime = datetime;
        this.status = "[\u2718]";
    }

    @Override
    public String text() {
        return this.text + "(at:" + datetime + ")";
    }

    @Override
    public String status() {
        return "[" + nodetype + "]"+ status;
    }

    public char showtype() {
        return nodetype;
    }
}