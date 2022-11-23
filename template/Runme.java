import java.util.*;
import java.io.*;



public class Runme{
  public static void part1(Scanner in){
  }

  public static void part2(Scanner in){
  }

  public static void main(String[]args){
    File f=  null;
    Scanner in = null;
    try{
      f = new File("input.txt");
      in = new Scanner(f);
      //part1(in);
      f = new File("input.txt");
      in = new Scanner(f);
      part2(in);
    }catch(FileNotFoundException e){
      e.printStackTrace();
      System.exit(1);
    }
  }




}
