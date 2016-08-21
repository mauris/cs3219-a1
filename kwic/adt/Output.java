package kwic.adt;

import java.util.ArrayList;
import java.util.Collections;

public class Output {
  public static void print(ArrayList<String> results){
    for (int i=0;i<results.size();i++){
      System.out.println(results.get(i));
    }
  }
}