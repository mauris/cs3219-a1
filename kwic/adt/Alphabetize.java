/**
 * @author Tan Chia Kai
 */

package kwic.adt;

import java.util.ArrayList;
import java.util.Collections;
import kwic.utility.AlphabetizeComparator;

public class Alphabetize {
  public static ArrayList<String> process (ArrayList<String> lines){
    Collections.sort(lines, new AlphabetizeComparator());
    return lines;
  }
}
