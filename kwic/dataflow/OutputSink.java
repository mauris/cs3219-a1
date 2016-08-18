package kwic.dataflow;

class OutputSink extends GenericSink<String> {
  public OutputSink(Pipe<String> pipe) {
    super(pipe);
  }

  @Override
  protected void processInput(String value){
    if (value == null) {
      System.exit(0);
    }
    System.out.println(value);
  }
}
