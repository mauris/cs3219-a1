package kwic.dataflow;

import kwic.utility.WordTokenizer;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

class CircularShiftFilter extends GenericFilter<String, String> {
  private List<String> ignoreWordList;

  public CircularShiftFilter(Pipe<String> input, Pipe<String> output) {
    super(input, output);
    this.ignoreWordList = new LinkedList<String>();
  }

  public void setIgnoreWordList(List<String> list) {
    this.ignoreWordList = list;
  }

  protected boolean isWordIgnored(String word) {
    for (String ignoredWord : this.ignoreWordList) {
      if (ignoredWord.equalsIgnoreCase(word)) {
        return true;
      }
    }
    return false;
  }

  protected static String buildShift(int index, String[] words) {
    String[] result = new String[words.length];
    for (int j = index; j < words.length + index; ++j) {
      result[j - index] = words[j % words.length];
    }
    return String.join(" ", result);
  }

  protected void processIgnoreWordsLine(Pipe<String> input) {
    String ignoreWordsLine = input.nextOrWait();
    List<String> list = Arrays.asList(ignoreWordsLine.split("\\W+"));
    this.setIgnoreWordList(list);
  }

  @Override
  protected void transformPipes(Pipe<String> input, Pipe<String> output){
    this.processIgnoreWordsLine(input);
    while (true) {
      String value = input.nextOrWait();
      if (value == null) {
        break;
      }
      processInput(value, output);
    }
    output.put(null);
  }

  private void processInput(String line, Pipe<String> output) {
    String[] words = WordTokenizer.tokenize(line);
    for (int i = 0; i < words.length; ++i) {
      if (this.isWordIgnored(words[i])) {
        continue;
      }
      output.put(this.buildShift(i, words));
    }
  }
}
