import java.util.*;
import java.io.*;

public class Runme{
  public static boolean isValid(String s){
    boolean isInside = false;
    boolean ans = false;
    for(int i = 0; i < s.length()-3;i++){
      char c = s.charAt(i);
      if( c == '['){
          isInside=true;
      }
      String slice = s.substring(i,i+4);
      if(!isInside){
        if(slice.charAt(0)!=slice.charAt(1)&&
           slice.charAt(0)==slice.charAt(3)&&
           slice.charAt(1)==slice.charAt(2)){
             ans = true;
           }
      }else{
        if(slice.charAt(0)!=slice.charAt(1)&&
           slice.charAt(0)==slice.charAt(3)&&
           slice.charAt(1)==slice.charAt(2)){
             return false;
           }
        }


      if(s.charAt(i)==']'){
        isInside=false;
      }
    }
    return ans;
  }

  public static boolean isValid2(String s){
    boolean isInside = false;
    String inside="";
    String outside="";
    for(int i = 0; i < s.length();i++){
      char c = s.charAt(i);
      if( c == '['){
          isInside=true;
      }else if(s.charAt(i)==']'){
        outside+="-";
        isInside=false;
      }else if(isInside){
        inside+=c;
      }else{
        outside+=c;
      }
    }
    for(int i = 0; i < inside.length()-2;i++){
      String sub = inside.substring(i,i+3);
      if(sub.charAt(0)!=sub.charAt(1) && sub.charAt(0)==sub.charAt(2)){
        String findme = ""+sub.charAt(1)+sub.charAt(0)+sub.charAt(1);
        if(outside.contains(findme)){
          return true;
        }
      }

    }
    return false;
  }
  public static void part1(Scanner in){
    int count = 0;
    while(in.hasNextLine()){
      String ip = in.nextLine();
      if(isValid(ip)){
        //System.out.println(ip);
        count++;
      }
    }
    System.out.println(count);
  }

  public static void part2(Scanner in){
    int count = 0;
    while(in.hasNextLine()){
      String ip = in.nextLine();
      if(isValid2(ip)){
        //System.out.println(ip);
        count++;
      }
    }
    System.out.println(count);
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
