package kwic.dataflow;

class MultiplierFilter extends GenericFilter<Integer, Integer> {
  public MultiplierFilter(Pipe<Integer> input, Pipe<Integer> output) {
    super(input, output);
  }

  @Override
  protected Integer transform(Integer inputValue) {
    return inputValue * 5;
  }
}
