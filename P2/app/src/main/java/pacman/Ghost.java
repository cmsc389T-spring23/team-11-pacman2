package pacman;

import java.util.ArrayList;
import java.util.HashSet;

public class Ghost {
  String myName;
  Location myLoc;
  Map myMap;

  public Ghost(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
    int x = myLoc.x;
    int y = myLoc.y;
    ArrayList<Location> validLocations = new ArrayList<Location>();

    if (!myMap.getLoc(new Location(x - 1, y)).contains(Map.Type.WALL)) {
      validLocations.add(new Location(x - 1, y));
    }
    if (!myMap.getLoc(new Location(x + 1, y)).contains(Map.Type.WALL)) {
      validLocations.add(new Location(x + 1, y));
    }
    if (!myMap.getLoc(new Location(x, y - 1)).contains(Map.Type.WALL)) {
      validLocations.add(new Location(x, y - 1));
    }
    if (!myMap.getLoc(new Location(x, y + 1)).contains(Map.Type.WALL)) {
      validLocations.add(new Location(x, y + 1));
    }

    return validLocations;
  }

  public boolean move() {
    // ArrayList<Location> validMoves = get_valid_moves();
    // int choice = (int) (Math.random() * validMoves.size());

    // if (validMoves.size() == 0 ||
    //     myMap.move(myName, validMoves.get(choice), Map.Type.PACMAN))
    //   return false;

    // this.myLoc = validMoves.get(choice);
    // return false;
    ArrayList<Location> locs = get_valid_moves();
    if(!locs.isEmpty()){
      if (myMap.move(myName, locs.get(0), Map.Type.GHOST)){
        return true;
      }
    }
    return false;
  }
  
  public boolean is_pacman_in_range() {
    for (int dx = -1; dx <= 1; dx++) {
      for (int dy = -1; dy <= 1; dy++) {
        Location newLocation = myLoc.shift(dx, dy);

        if (myMap.getLoc(newLocation).contains(Map.Type.PACMAN))
          return true;
      }
    }

    return false;
  }

  public boolean attack() {
    return is_pacman_in_range() && myMap.attack(myName);
  }
}
