package kwic.dataflow;

import java.util.Comparator;
import java.util.PriorityQueue;

class AlphabetizeFilter extends GenericFilter<String, String> {
  public AlphabetizeFilter(Pipe<String> input, Pipe<String> output) {
    super(input, output);
  }

  private static Comparator<String> createComparator() {
    return new Comparator<String>() {
      public int compare(String alpha, String bravo) {
        return alpha.compareToIgnoreCase(bravo);
      }
    };
  }

  @Override
  protected void transformPipes(Pipe<String> input, Pipe<String> output){
    PriorityQueue<String> list = new PriorityQueue<String>(this.createComparator());
    while (true) {
      String value = input.nextOrWait();
      if (value == null) {
        break;
      }
      list.offer(value);
    }
    while (list.peek() != null) {
      output.put(list.poll());
    }
    output.put(null);
  }
}
