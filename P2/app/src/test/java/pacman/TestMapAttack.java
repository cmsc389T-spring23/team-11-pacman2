package pacman;
import junit.framework.*;
import java.io.*;
import java.awt.Color;

public class TestMapAttack extends TestCase {

  public void testMapAttack() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Ghost ghost = frame.addGhost(new Location(9, 11), "blinky", Color.red);
    PacMan pacman = frame.addPacMan(new Location(9, 12));
    assertTrue(frame.getMap().attack("blinky"));
  }
}
