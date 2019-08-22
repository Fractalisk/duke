interface listcommands {
    public void add(String input1);
    public String[] list();
    public int stored();
}

public class List implements listcommands{
    private String[] memory = new String[100];
    private int objectcount = 0;
    public void add(String input) {
        memory[objectcount] = String.valueOf(objectcount+1) + "." + input;
        objectcount++;
    }
    public String[] list() {
        return memory;
    }
    public int stored() {
        return objectcount;
    }
}
