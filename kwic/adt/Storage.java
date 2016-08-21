/**
 * @author Tan Chia Kai
 */

package kwic.adt;

import java.util.LinkedList;
import java.util.ArrayList;

public class Storage{
  private ArrayList<String> ignoreWords = new ArrayList<String>();
  private LinkedList<String[]> lines = new LinkedList<String[]>();
  private ArrayList<String> results = new ArrayList<String>();
  private ArrayList<String> finalResults = new ArrayList<String>();

  public void addIgnore(String[] words){
    for (String word : words) {
      ignoreWords.add(word.toLowerCase());
    }
  }

  public void addLine(String[] line){
    lines.add(line);
  }

  public String[] getNextLine() {
    return lines.pop();
  }

  public Boolean hasNextLine() {
    return !lines.isEmpty();
  }

  public void addResult(ArrayList<String> result) {
    results.addAll(result);
  }

  public ArrayList<String> getResults(){
    return results;
  }

  public void setFinal(ArrayList<String> result){
    finalResults.addAll(result);
  }

  public ArrayList<String> getFinal(){
    return finalResults;
  }

  public ArrayList<String> getIgnores(){
    return ignoreWords;
  }
}
