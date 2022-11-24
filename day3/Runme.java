import java.util.*;
import java.io.*;
public class Runme{
  public static void main(String[]args){
    try{
      File f = new File("input.txt");
      Scanner in = new Scanner(f);
      ArrayList<String>words = new ArrayList<String>();
      while(in.hasNextLine()){
        words.add(in.nextLine());
      }


      int len = words.get(0).length();
      for(int i = 0; i<len; i++){
        Tally t = new Tally();
        for(String word : words){
          t.add(word.charAt(i));
        }
        System.out.print(t.getMin());
      }
      System.out.println();
    }catch(Exception e){
      System.out.println("exeption.");
    }
  }
}
