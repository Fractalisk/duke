
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Duketest {
    @Test
    public void Testcommand() {
        Inputparser Inputparser = new Inputparser();
        assertTrue(Inputparser.parse("bye") == 0);
        assertTrue(Inputparser.parse("list \n") == 1);
        assertTrue(Inputparser.parse("todo Hello world") == 3);
        assertTrue(Inputparser.parse("done 1") == 1);
        assertTrue(Inputparser.parse("deadline today /by tomorrow") == 4);
        assertTrue(Inputparser.parse("event today /at tomorrow") == 5);
    }
}