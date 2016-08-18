package kwic.dataflow;

class OutputSink extends GenericSink<String> {
  public OutputSink(Pipe<String> pipe) {
    super(pipe);
  }

  @Override
  protected void processInput(String value){
    System.out.println(value);
  }
}
