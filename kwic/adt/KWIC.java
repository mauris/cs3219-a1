/**
 * @author Tan Chia Kai
 */

package kwic.adt;

import java.util.ArrayList;

public class KWIC {
  public static void main(String[] args) {
    Storage storage = new Storage();
    
    Input.retrieveTo(storage);
    
    ArrayList<String[]> lines = storage.getLines();
    ArrayList<String> ignores = storage.getIgnores();
    ArrayList<String> allProcessedLines = new ArrayList<String>();
    ArrayList<String> processedLines;
    
    for (int i=0;i<lines.size();i++){
      String[] line = lines.get(i);
      processedLines = CircularShift.shift(line, ignores);
      allProcessedLines.addAll(processedLines);
    }
    
    allProcessedLines = Alphabetize.process(allProcessedLines);
    Output.print(allProcessedLines);
  }
}
