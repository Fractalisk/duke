public class Node {
    protected String text;
    protected String status;

    public String text() {
        return text;
    }
    public String status() {
        return status;
    }

    public Node(String description) {
        this.text = description;
        this.status = "[\u2718]";
    }
    public Node() {
        this.text = "";
        this.status = "[\u2718]";
    }

    public void setdone() {
        this.status = "[\u2713]";
    }
}
