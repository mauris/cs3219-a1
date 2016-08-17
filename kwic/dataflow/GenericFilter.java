package kwic.dataflow;

abstract class GenericFilter<I, O> implements Runnable {
  protected Pipe<I> inputPipe;

  protected Pipe<O> outputPipe;

  public GenericFilter(Pipe<I> inputPipe, Pipe<O> outputPipe) {
    this.inputPipe = inputPipe;
    this.outputPipe = outputPipe;
  }

  @Override
  public void run() {
    while (true) {
      I next = inputPipe.nextOrWait();
      O result = this.transform(next);
      outputPipe.put(result);
    }
  }

  protected abstract O transform(I inputValue);
}
