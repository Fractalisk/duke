interface listcommands {
    public void add(String input1);
    public String list(int input1);
    public int stored();
}

public class List implements listcommands{
    private String[] memory = new String[100];
    private int objectcount = 0;
    private boolean[] checklist = new boolean[100];

    public void add(String input) {
        memory[objectcount] = input;
        checklist[objectcount] = false;
        objectcount++;
    }

    public String list(int input) {
        return memory[input];
    }

    public int stored() {
        return objectcount;
    }

    public boolean isdone(int input) {
        return checklist[input];
    }

    public void markdone(int input) {
        checklist[input] = true;
    }
}
