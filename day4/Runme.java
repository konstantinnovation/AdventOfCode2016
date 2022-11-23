import java.util.*;
import java.io.*;



public class Runme{
  public static class Tally{
    int[]tally;

    public Tally(){
      tally = new int[26];

    }
    public String toString(){
      return Arrays.toString(tally);
    }

    public String solve(){
      char[] solution = new char[5];

      for(int toFind = 0;toFind < solution.length;toFind++){
        int maxi = -1;
        for(int i = 0; i < tally.length; i++){
          if(maxi == -1 || tally[i]>tally[maxi]){
            maxi=i;
          }
        }
        tally[maxi]=-1;
        solution[toFind]=(char)(maxi+'a');
      }
      String ans ="";
      for(char c : solution){
        ans+=c;
      }
      return ans;
    }

    public void add(char c){
      tally[c-'a']++;
    }

  }
  public static String rotx(String s, int r){
    String ans = "";
    for(int i = 0 ; i < s.length(); i++){
      char c = s.charAt(i);
      if(c == '-'){
        ans+=" ";
      }else{
        c-='a';
        c+=r;
        c%=26;
        c+='a';
        ans+=c;
      }
    }
    return ans;
  }

  public static int validate(String pass,boolean print){
    String[] pair = pass.split("\\[");
    pair[1]=pair[1].substring(0,pair[1].length()-1).strip();
    String checksum = pair[1];
    String[]chunks = pair[0].split("-");
    int id = Integer.parseInt(chunks[chunks.length-1]);
    chunks[chunks.length-1]="";
    String realpass = "";
    for(String s : chunks){
      realpass+=s;
    }
    //System.out.println(realpass+"/"+checksum+"/"+id);

    Tally t = new Tally();
    for(int i = 0; i < realpass.length();i++){
        t.add(realpass.charAt(i));
    }
    if(t.solve().equals(checksum)){
      if(print){
        String dec= rotx(pair[0],id);
        if(dec.startsWith("northpole")){
          System.out.println(dec+ " " +id);
        }
      }
      return id;
    }else{
      return 0;
    }

  }

  public static void part1(Scanner in){
    int sum = 0;
    while(in.hasNextLine()){
      String pass = in.nextLine();
      sum+=validate(pass,false);
    }
    System.out.println(sum);
  }


  public static void part2(Scanner in){
    int sum = 0;
    while(in.hasNextLine()){
      String pass = in.nextLine();
      validate(pass,true);


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
