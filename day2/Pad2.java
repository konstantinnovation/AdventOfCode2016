public class Pad2 extends Pad{
  public Pad2(){
    //super class starts at 1,1 which is '2'
    data = new char[][]{
      { 0 , 0 ,'1', 0 , 0},
      { 0 ,'2','3','4', 0},
      {'5','6','7','8','9'},
      { 0 ,'A','B','C', 0},
      { 0 , 0 ,'D', 0 , 0}
    };
    D();
    L();
  }
}
