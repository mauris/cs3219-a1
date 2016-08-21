/**
 * @author Yong Shan Xian
 */

package kwic.dataflow;

public class KWIC {
  public static void main(String[] args) {
    Pipe<String> pipe1 = new Pipe<String>();
    Pipe<String> pipe2 = new Pipe<String>();
    Pipe<String> pipe3 = new Pipe<String>();

    InputGenerator input = new InputGenerator(pipe1);
    CircularShiftFilter circularShift = new CircularShiftFilter(pipe1, pipe2);
    AlphabetizeFilter alphabetize = new AlphabetizeFilter(pipe2, pipe3);
    OutputSink output = new OutputSink(pipe3);

    (new Thread(output)).start();
    (new Thread(input)).start();
    (new Thread(circularShift)).start();
    (new Thread(alphabetize)).start();
  }
}
