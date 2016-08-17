package kwic.dataflow;

public class KWIC {
  public static void main(String[] args) {
    Pipe<Integer> pipeGenToFilter1 = new Pipe<Integer>();
    Pipe<Integer> pipeFilter1ToFilter2 = new Pipe<Integer>();
    Pipe<String> pipeFilter2ToSink = new Pipe<String>();

    SampleGenerator generator = new SampleGenerator(pipeGenToFilter1);
    SampleSink sink = new SampleSink(pipeFilter2ToSink);
    MultiplierFilter filter1 = new MultiplierFilter(pipeGenToFilter1, pipeFilter1ToFilter2);
    ConvertFilter filter2 = new ConvertFilter(pipeFilter1ToFilter2, pipeFilter2ToSink);

    (new Thread(sink)).start();
    (new Thread(filter2)).start();
    (new Thread(filter1)).start();
    (new Thread(generator)).start();
  }
}
