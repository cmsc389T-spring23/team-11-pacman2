package pacman;
import java.io.*;
import junit.framework.*;

public class TestPacManConsume extends TestCase {

  public void testPacManConsume() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    PacMan pacman = frame.addPacMan(new Location(9, 11));
    assertTrue(pacman.consume() == null);
  }
}
