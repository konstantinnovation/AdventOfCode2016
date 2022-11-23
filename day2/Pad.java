public class Pad{
  public char[][]data;
  public int x,y;
  public Pad(){
    data=new char[][]{
      {'1','2','3'},
      {'4','5','6'},
      {'7','8','9'}
    };
    x=1;
    y=1;
  }
  public char get(){
    return data[y][x];
  }
  public void U(){
    if(y>0 && data[y-1][x]!=0){
      y--;
    }
  }
  public void D(){
    if(y < data.length - 1 && data[y+1][x]!=0){
      y++;
    }
  }
  public void L(){
    if(x>0 && data[y][x-1]!=0){
      x--;
    }
  }
  public void R(){
    if(x<data[0].length - 1 && data[y][x+1]!=0){
      x++;
    }
  }
}
