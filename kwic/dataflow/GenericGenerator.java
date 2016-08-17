package kwic.dataflow;

abstract class GenericGenerator<T> implements Runnable {
  protected Pipe<T> outputPipe;

  public GenericGenerator(Pipe<T> outputPipe) {
    this.outputPipe = outputPipe;
  }

  public void putIntoOutput(T value) {
    this.outputPipe.put(value);
  }
}
