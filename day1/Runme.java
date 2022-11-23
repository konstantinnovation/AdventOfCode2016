import java.util.*;
import java.io.*;
public class Runme{
  public static void part1(Scanner in){

    int dir = 0;
    int x = 0;
    int y = 0;
    while(in.hasNext()){
      String next = in.next();
      if(next.charAt(next.length()-1) ==','){
        next = next.substring(0,next.length()-1);
      }
      if(next.charAt(0)=='L'){
        dir--;
        if(dir<0)dir=3;
      }else{
        dir++;
        dir%=4;
      }
      ArrayList<String>coords=new ArrayList<String>();
      int dist = Integer.parseInt(next.substring(1));
      switch(dir){
        case 0:
          y-=dist;
        break;
        case 1:
          x+=dist;
          break;
        case 2:
          y+=dist;
          break;
        case 3:
          x-=dist;
          break;
      }
    }
    System.out.println(Math.abs(x)+Math.abs(y));
  }


  public static void part2(Scanner in){

    int dir = 0;
    int x = 0;
    int y = 0;
    ArrayList<String>coords=new ArrayList<String>();
    
    while(in.hasNext()){
      String next = in.next();
      if(next.charAt(next.length()-1) ==','){
        next = next.substring(0,next.length()-1);
      }
      if(next.charAt(0)=='L'){
        dir--;
        if(dir<0)dir=3;
      }else{
        dir++;
        dir%=4;
      }
      int dist = Integer.parseInt(next.substring(1));
      switch(dir){
        case 0:
          while(dist>0){
            y--;
            dist--;
            if(coords.indexOf(x+","+y)!=-1){
                System.out.println(Math.abs(x)+Math.abs(y));
                System.exit(0);
            }else{
              coords.add(x+","+y);
            }
          }
        break;
        case 1:
        while(dist>0){
          x++;
          dist--;
          if(coords.indexOf(x+","+y)!=-1){
              System.out.println(Math.abs(x)+Math.abs(y));
              System.exit(0);
          }else{
            coords.add(x+","+y);
          }
        }
        break;
        case 2:
        while(dist>0){
          y++;
          dist--;
          if(coords.indexOf(x+","+y)!=-1){
              System.out.println(Math.abs(x)+Math.abs(y));
              System.exit(0);
          }else{
            coords.add(x+","+y);
          }
        }
        break;
        case 3:
        while(dist>0){
          x--;
          dist--;
          if(coords.indexOf(x+","+y)!=-1){
              System.out.println(Math.abs(x)+Math.abs(y));
              System.exit(0);
          }else{
            coords.add(x+","+y);
          }
        }
        break;
      }

    }
    System.out.println(coords);

  }
  public static void main(String[]args){
    File f=  null;
    Scanner in = null;
    try{
      f=new File("input.txt");
      in = new Scanner(f);
      part1(in);
      f=new File("input.txt");
      in = new Scanner(f);
      part2(in);
    }catch(FileNotFoundException e){
      e.printStackTrace();
      System.exit(1);
    }
  }

}
