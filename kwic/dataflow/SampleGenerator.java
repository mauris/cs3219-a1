package kwic.dataflow;

class SampleGenerator extends GenericGenerator<Integer> {
  public SampleGenerator(Pipe<Integer> pipe) {
    super(pipe);
  }

  @Override
  public void run() {
    for(int i = 0; i < 1000; ++i) {
      this.putIntoOutput(i);
    }
  }
}
