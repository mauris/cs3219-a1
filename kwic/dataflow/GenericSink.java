package kwic.dataflow;

abstract class GenericSink<T> implements Runnable {
  protected Pipe<T> inputPipe;

  public GenericSink(Pipe<T> inputPipe) {
    this.inputPipe = inputPipe;
  }

  @Override
  public void run() {
    while (true) {
      T value = this.inputPipe.nextOrWait();
      this.processInput(value);
    }
  }

  protected abstract void processInput(T value);
}
