package kwic.utility;

class WordTokenizer {
  public static String[] tokenize(String line) {
    return line.split("\\W+");
  }
}
