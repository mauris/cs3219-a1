package kwic.dataflow;

import kwic.utility.WordTokenizer;

class CircularShiftFilter extends GenericFilter<String, String> {
  public CircularShiftFilter(Pipe<String> input, Pipe<String> output) {
    super(input, output);
  }

  @Override
  protected void transformPipes(Pipe<String> input, Pipe<String> output){
    while (true) {
      String value = input.nextOrWait();
      processInput(value, output);
    }
  }

  private void processInput(String line, Pipe<String> output) {
    String[] words = WordTokenizer.tokenize(line);
    for (int i = 0; i < words.length; ++i) {
      String[] result = new String[words.length];
      for (int j = i; j < words.length + i; ++j) {
        result[j - i] = words[j % words.length];
      }
      output.put(String.join(" ", result));
    }
  }
}
