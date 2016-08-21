/**
 * @author Tan Chia Kai
 */

package kwic.adt;

import java.util.ArrayList;

public class Storage{
  private ArrayList<String> ignoreWords = new ArrayList<String>();
  private ArrayList<String[]> lines = new ArrayList<String[]>();

  public void addIgnore(String[] words){
    for (String word : words) {
      ignoreWords.add(word.toLowerCase());
    }
  }

  public void addLine(String[] line){
    lines.add(line);
  }

  public ArrayList<String[]> getLines() {
    return lines;
  }

  public ArrayList<String> getIgnores(){
    return ignoreWords;
  }
}
