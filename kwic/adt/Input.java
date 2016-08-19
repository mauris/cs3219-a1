package kwic.adt;

import java.util.Scanner;
import kwic.utility.WordTokenizer;

public class Input {
  public static void retrieveTo(Storage storage){
    Scanner sc = new Scanner(System.in);
    // read ignore words
    String line = sc.nextLine();
    storage.addIgnore(WordTokenizer.tokenize(line));
    
    // read the lines of texts
    while (sc.hasNextLine()) {
      line = sc.nextLine();
      if (line.equals("")) {
        break;
      }
      storage.addLine(WordTokenizer.tokenize(line));
    }
    sc.close();
  }
}