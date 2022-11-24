import java.util.*;
import java.io.*;



public class Runme{
  public static void part1(Scanner in){
    while(in.hasNextLine()){
      String line = in.nextLine();
      String ans = "";
      for(int i = 0; i < line.length(); i++){
        if(line.charAt(i)!='('){
          ans+=line.charAt(i);
        }else{
          int width = line.substring(i).indexOf(")");
          String[]split = line.substring(i+1,i+width).split("x");
          int letters = Integer.parseInt(split[0]);
          int times = Integer.parseInt(split[1]);
          //System.out.println(letters+","+times);
          int start = i+width+1;
          int end = i+1+width+letters;
          String substring = line.substring(start,end);
          for(int r = 0; r<times; r++){
            ans+=substring;
          }
          i=i+width+letters;
          //System.out.println("Rest:"+line.substring(i-1));
        }
      }
      System.out.println(ans.length());
    }
  }

  public static long len(String line){
      long count = 0;
      for(int i = 0; i < line.length(); i++){
        if(line.charAt(i)!='('){
          count++;
        }else{

          int width = line.substring(i).indexOf(")");
          String[]split = line.substring(i+1,i+width).split("x");
          int letters = Integer.parseInt(split[0]);
          int times = Integer.parseInt(split[1]);
          
          int start = i+width+1;
          int end = i+1+width+letters;
          String substring = line.substring(start,end);
          
          long len = times*len(substring);
          //System.out.println("Processing "+substring+" "+len);
          count+=len;
          
          i=end-1;
          
        }
      }
      return count;
  }

  public static void part2(Scanner in){
    while(in.hasNextLine()){
      String line = in.nextLine();
      
      System.out.println(len(line));
    }
  }

  public static void main(String[]args){
    File f=  null;
    Scanner in = null;
    try{
      f = new File("input.txt");
      in = new Scanner(f);
      part1(in);
      f = new File("input.txt");
      in = new Scanner(f);
      part2(in);
    }catch(FileNotFoundException e){
      e.printStackTrace();
      System.exit(1);
    }
  }




}
