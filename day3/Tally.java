import java.util.*;
public class Tally{
  private int[] tally;
  public Tally(){
    tally = new int[26];
  }
  public char getMax(){
    int maxi = 0;
    for(int i = 0; i < tally.length; i++){
      if(tally[i] > tally[maxi]){
        maxi = i;
      }
    }
    return (char)(maxi+'a');
  }

  public char getMin(){
    int maxi = 0;
    for(int i = 0; i < tally.length; i++){
      if(tally[i] < tally[maxi]){
        maxi = i;
      }
    }
    return (char)(maxi+'a');
  }

  public void add(char c){
    //System.out.print(c);
    tally[c-'a']++;
  }
  public String toString(){
    return Arrays.toString(tally);
  }
}
