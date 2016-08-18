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
    transformPipes(this.inputPipe, this.outputPipe);
  }

  protected abstract void transformPipes(Pipe<I> input, Pipe<O> output);
}
