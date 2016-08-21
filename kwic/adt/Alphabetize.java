package kwic.adt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Alphabetize {
  public static void process (Storage storage){
    ArrayList<String> sorted = storage.getResults();
    Collections.sort(sorted, new Comparator<String>() {
      }});
    storage.setFinal(sorted);
  }
}
