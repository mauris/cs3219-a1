/**
 * @author Tan Chia Kai
 */

package kwic.adt;

import java.util.ArrayList;

public class CircularShift {
  //shifting and ignore
  public static ArrayList<String> shift(String[] line, ArrayList<String> ignores){
    ArrayList<String> results = new ArrayList<String>();

    for (int i=0;i<line.length;i++) {
      String[] result = new String[line.length];
      for (int j=i; j<line.length+i; j++) {
        result[j-i] = line[j%line.length];
      }
      //combine if first word is an ignore word
      if (!ignores.contains(result[0].toLowerCase())){
        results.add(String.join(" ", result));
      }
    }

    return results;
  }
}
