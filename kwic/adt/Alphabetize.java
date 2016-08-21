package kwic.adt;

import java.util.ArrayList;
import java.util.Collections;
import kwic.utility.AlphabetizeComparator;

public class Alphabetize {
  public static void process (Storage storage){
    ArrayList<String> sorted = storage.getResults();
    Collections.sort(sorted, new AlphabetizeComparator());
    storage.setFinal(sorted);
  }
}
