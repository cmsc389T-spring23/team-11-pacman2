package pacman;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JComponent;

public class PacMan {
  String myName;
  Location myLoc;
  Map myMap;

  public PacMan(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
    ArrayList<Location> validMoves = new ArrayList<Location>();

    for (int dx = -1; dx <= 1; dx++) {
      for (int dy = -1; dy <= 1; dy++) {
        Location newLocation = myLoc.shift(dx, dy);

        HashSet<Map.Type> types = myMap.getLoc(newLocation);
        if (types.contains(Map.Type.EMPTY) ||
            (types.size() == 1 && types.contains(Map.Type.COOKIE)))
          validMoves.add(newLocation);
      }
    }

    return validMoves;
  }

  public boolean move() {
    ArrayList<Location> locs = this.get_valid_moves();
    if (locs.size() <= 0) {
      return (false);
    }
    boolean result = myMap.move("pacman", locs.get(0), Map.Type.PACMAN);
    if (result) {
      this.myLoc = locs.get(0);
      return (true);
    } else {
      return (false);
    }

    
  }

  public boolean is_ghost_in_range() {
    for (int dx = -1; dx <= 1; dx++) {
      for (int dy = -1; dy <= 1; dy++) {
        Location newLocation = myLoc.shift(dy, dx);

        if (myMap.getLoc(newLocation).contains(Map.Type.PACMAN))
          return true;
      }
    }

    return false;
  }

  public JComponent consume() {
    if (myMap.getLoc(myLoc).contains(Map.Type.COOKIE))
      return myMap.eatCookie(myName);

    return null;
    
  }
}
