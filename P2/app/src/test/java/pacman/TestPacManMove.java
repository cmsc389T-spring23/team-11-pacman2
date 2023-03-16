package pacman;
import java.io.*;
import junit.framework.*;

public class TestPacManMove extends TestCase {

  public void testPacManMove() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(9,11));
		assertTrue(pacman.move());
  }
}
