public class Todo extends Node{

    private char nodetype = 'T';

    public Todo(String description) {
        this.text = description;
        this.status = "[\u2718]";
    }

    @Override
    public String status() {
        return "[" + nodetype + "]"+ status;
    }

    public char showtype() {
        return nodetype;
    }
}
