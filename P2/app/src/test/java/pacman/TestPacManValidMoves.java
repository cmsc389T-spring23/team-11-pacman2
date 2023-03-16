package pacman;
import java.io.*;
import junit.framework.*;

public class TestPacManValidMoves extends TestCase {

  public void testPacManValidMoves() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(9,11));
		assertTrue(pacman.get_valid_moves().size() == 3);
  }
}
