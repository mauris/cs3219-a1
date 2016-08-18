package kwic.dataflow;

import java.util.Scanner;

class InputGenerator extends GenericGenerator<String> {
  public InputGenerator(Pipe<String> pipe) {
    super(pipe);
  }

  @Override
  public void run() {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      // read input and add into pipe
      String line = sc.nextLine().trim();
      if ("".equals(line)) {
        break;
      }
      this.putIntoOutput(line);
    }
    sc.close();
    this.putIntoOutput(null);
  }
}
