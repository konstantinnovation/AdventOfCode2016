import java.util.*;
import java.io.*;


public class Runme{

  public static class Screen{
    //50 pixels wide and 6
    public char[][]screen;
    public Screen(){
      screen = new char[6][50];
      for(int col = 0; col < screen[0].length; col++){
          for(int row = 0; row < screen.length; row++){
             screen[row][col]='.';
          }
        }
    }

    public void rotR(int row, int n){
      //System.out.println("Rot r="+row+" n ="+n);
      char[]newRow = new char[screen[0].length];
      for(int i=0;i<newRow.length;i++){
        newRow[i]=screen[row][(i-n+screen[0].length)%screen[0].length];
      }
      screen[row]=newRow;
    }
    public void rotC(int col, int n){
      //System.out.println("Rot c="+col+" n ="+n);
      char[]newCol = new char[screen.length];
      for(int i = 0; i < newCol.length; i++){
        newCol[i]=screen[(i-n+screen.length)%screen.length][col];
      }
      //copy back
      for(int i = 0; i < newCol.length; i++){
        screen[i][col] = newCol[i];
      }

    }
    public void rect(int x, int y){
      for(int col = 0; col < x; col++){
          for(int row = 0; row < y; row++){
            try{
              screen[row][col]='#';
            }catch(ArrayIndexOutOfBoundsException e){}
          }
        }
    }

    public String toString(){
      String ans = "";
      for(char[] row : screen){
        for(char c : row){
          ans+=c;
        }
        ans+="\n";
      }
      return ans;
    }

  }

  public static void part1(Scanner in){
    Screen scr = new Screen();
    while(in.hasNextLine()){
      String line = in.nextLine();
      if(line.startsWith("rect")){
        line=line.substring(5);
        String[]dim = line.split("x");
        int x = Integer.parseInt(dim[0]);
        int y = Integer.parseInt(dim[1]);
        scr.rect(x,y);
        
      }
      if(line.startsWith("rotate co")){
        line=line.substring(16);
        String[]dim = line.split("by");
        int col = Integer.parseInt(dim[0].strip());
        int mag = Integer.parseInt(dim[1].strip());
        scr.rotC(col,mag);

      }
      if(line.startsWith("rotate ro")){
        line=line.substring(13);
        String[]dim = line.split("by");
        int row = Integer.parseInt(dim[0].strip());
        int mag = Integer.parseInt(dim[1].strip());
        scr.rotR(row,mag);
      }
      
    }
    int count = 0;
    for(int col = 0; col < scr.screen[0].length; col++){
      for(int row = 0; row < scr.screen.length; row++){
        if(scr.screen[row][col]=='#'){
          count++;
        }
      }
    }
    System.out.println(count);
    System.out.println(scr);
  }

  public static void part2(Scanner in){
  }

  public static void main(String[]args){
    File f =  null;    
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
