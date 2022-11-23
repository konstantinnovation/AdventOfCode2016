public class Pad2 extends Pad{
  public static char[][]data={
    { 0 , 0 ,'1', 0 , 0},
    { 0 ,'2','3','4', 0},
    {'5','6','7','8','9'},
    { 0 ,'A','B','C', 0},
    { 0 , 0 ,'D', 0 , 0}
  };

  public char get(){
    return data[y][x];
  }

  public Pad2(){
    //super class starts at 1,1 which is '2'
    D();
    L();
  }

  public void U(){
    if(y>0 && data[y-1][x]!=0){
      y--;
    }
  }
  public void D(){
    if(y<4 && data[y+1][x]!=0){
      y++;
    }
  }
  public void L(){
    if(x>0 && data[y][x-1]!=0){
      x--;
    }
  }
  public void R(){
    if(x<4 && data[y][x+1]!=0){
      x++;
    }
  }
}
