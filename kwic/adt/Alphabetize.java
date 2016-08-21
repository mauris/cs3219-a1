package kwic.adt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Alphabetize {
  public static void process (Storage storage){
    ArrayList<String> sorted = storage.getResults();
    Collections.sort(sorted, new Comparator<String>() {
      public int compare(String entry1, String entry2) {
        return entry1.compareToIgnoreCase(entry2);
      }});
    storage.setFinal(sorted);
  }
}