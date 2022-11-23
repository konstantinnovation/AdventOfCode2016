public class Pad{
  public static char[][]data={
    {'1','2','3'},
    {'4','5','6'},
    {'7','8','9'}
  };
  public int x,y;
  public Pad(){
    x=1;
    y=1;
  }
  public char get(){
    return data[y][x];
  }

  public void U(){
    if(y>0){
      y--;
    }
  }
  public void D(){
    if(y<2){
      y++;
    }
  }
  public void L(){
    if(x>0){
      x--;
    }
  }
  public void R(){
    if(x<2){
      x++;
    }
  }
}
