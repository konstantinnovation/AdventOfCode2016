import java.util.*;
import java.io.*;


public class Runme{

  public static void part1(Scanner in, Pad p){
    while(in.hasNextLine()){
      String line = in.nextLine();
      for(int i = 0; i < line.length(); i++){
        char c = line.charAt(i);
        if(c == 'U')p.U();
        if(c == 'D')p.D();
        if(c == 'L')p.L();
        if(c == 'R')p.R();
      }
      System.out.print(p.get());
      }
      System.out.println();
  }


  public static void main(String[]args){
    File f=  null;
    Scanner in = null;
    try{
      f = new File("input.txt");
      in = new Scanner(f);
      part1(in, new Pad());
      f = new File("input.txt");
      in = new Scanner(f);
      part1(in, new Pad2());
    }catch(FileNotFoundException e){
      e.printStackTrace();
      System.exit(1);
    }
  }




}
