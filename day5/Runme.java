import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.security.*;


public class Runme{
  public static String md5(String input){
    try{
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] messageDigest = md.digest(input.getBytes());
      BigInteger no = new BigInteger(1, messageDigest);
      String hashtext = no.toString(16);
      while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    }

    catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

public static boolean noNull(char[]letters){
  for(char c : letters){
    if(c==0)return false;
  }
  return true;
}
public static void part1(Scanner in){
  try{
    String plaintext = in.nextLine();
    //plaintext= "abc";
    String ans = "";
    String test = "";
    int inc = 0;
    int count = 0;
    while(count < 8){
      inc++;
      test = md5(plaintext+inc);
      if(test.startsWith("00000")){
        count++;
        System.out.println(test);
        ans+=test.charAt(5);
      }
    }
    System.out.println(ans);
  }catch(Exception e){
    e.printStackTrace();
  }
}

  public static void part2(Scanner in){
    try{
      String plaintext = in.nextLine();
      //plaintext= "abc";
      String ans = "";
      char[]ansArr=new char[8];
      int inc = 0;
      String test = "";
      int count = 0;
      while(!noNull(ansArr)){
        inc++;
        test = md5(plaintext+inc);
        if(test.startsWith("00000")){
          System.out.println(test);
          int index = test.charAt(5)-'0';
          if(index >=0 && index <8 && ansArr[index] == 0){
            ansArr[index]=test.charAt(6);
            count++;
          }
        }
      }
      for(char c:ansArr){
        ans+=c;
      }
      System.out.println(ans);
    }catch(Exception e){
      e.printStackTrace();
    }
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
