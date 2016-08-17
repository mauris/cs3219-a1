package kwic.dataflow;

class SampleSink extends GenericSink<String> {
  public SampleSink(Pipe<String> pipe) {
    super(pipe);
  }

  @Override
  protected void processInput(String value) {
    System.out.println(value);
  }
}
