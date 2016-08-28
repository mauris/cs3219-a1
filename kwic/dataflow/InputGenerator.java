/**
 * @author Yong Shan Xian
 */

package kwic.dataflow;

import java.util.Scanner;

class InputGenerator extends GenericGenerator<String> {
  public InputGenerator(Pipe<String> pipe) {
    super(pipe);
  }

  @Override
  public void run() {
    Scanner sc = new Scanner(System.in);
    // enter the ignore line
    String line = sc.nextLine().trim();
    this.putIntoOutput(line);

    while (sc.hasNextLine()) {
      // read input and add into pipe
      line = sc.nextLine().trim();
      if ("".equals(line)) {
        break;
      }
      this.putIntoOutput(line);
    }
    sc.close();
    this.putIntoOutput(null);
  }
}
