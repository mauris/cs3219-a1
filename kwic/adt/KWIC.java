package kwic.adt;

public class KWIC {
  public static void main(String[] args) {
    Storage storage = new Storage();
    Input.retrieveTo(storage);
    CircularShift.process(storage);
    Alphabetize.process(storage);
    Output.print(storage.getFinal());
  }
}