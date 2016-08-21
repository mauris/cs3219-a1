/**
 * @author Tan Chia Kai
 */

package kwic.utility;

import java.util.Comparator;

public class AlphabetizeComparator implements Comparator<String> {
  public int compare(String alpha, String bravo) {
    return alpha.compareToIgnoreCase(bravo);
  }
}
