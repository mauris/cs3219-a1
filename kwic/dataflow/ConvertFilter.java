package kwic.dataflow;

class ConvertFilter extends GenericFilter<Integer, String> {
  public ConvertFilter(Pipe<Integer> input, Pipe<String> output) {
    super(input, output);
  }

  @Override
  protected String transform(Integer inputValue) {
    return "No: " + inputValue.toString();
  }
}
