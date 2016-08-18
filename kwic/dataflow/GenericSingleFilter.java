package kwic.dataflow;

abstract class GenericSingleFilter<I, O> extends GenericFilter<I, O> {
  @Override
  public void transformPipes(Pipe<I> input, Pipe<I> output) {
    while (true) {
      I next = input.nextOrWait();
      O result = this.transform(next);
      output.put(result);
    }
  }

  protected abstract O transform(I inputValue);
}
