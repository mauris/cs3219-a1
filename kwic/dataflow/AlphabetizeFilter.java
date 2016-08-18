package kwic.dataflow;

import java.util.PriorityQueue;

class AlphabetizeFilter extends GenericFilter<String, String> {
  public AlphabetizeFilter(Pipe<String> input, Pipe<String> output) {
    super(input, output);
  }

  @Override
  protected void transformPipes(Pipe<String> input, Pipe<String> output){
    PriorityQueue<String> list = new PriorityQueue<String>();
    while (true) {
      String value = input.nextOrWait();
      if (value == null) {
        break;
      }
      list.add(value);
    }
    for (String line : list) {
      output.put(line);
    }
    output.put(null);
  }
}
