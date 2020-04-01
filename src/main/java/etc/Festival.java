package etc;

public class Festival {

  static int[] x = {-1,-1,0,1,1,1,0,-1};
  static int[] y = {0,1,1,1,0,-1,-1,-1};


  public static void main(String[] args) {

    int totalX = 3;
    int totalY = 3;
    String[][] puzzle = new String[totalX][totalY];
    puzzle[0][0] = "w";
    puzzle[1][1] = "a";
    puzzle[2][2] = "r";
    puzzle[0][1] = "w";

    System.out.println(Festival.findWord(0,1,"war", puzzle));
  }


  public static boolean findWord(int x, int y, String word, String[][] puzzle) {

    if(x < 0 || y < 0) {
      System.out.println("index out of length!  x = " + x +"  y = "+ y);
      return false;
    }else if(!(word.substring(0, 1).equalsIgnoreCase(puzzle[x][y]))) {
      System.out.println("cant find! " + word.substring(0, 1)  + "  x = " + x +"  y = "+ y);
      return false;
    } else if(word.length() == 1) {
      System.out.println("find!  " + word.substring(0, 1) + "  x = " + x +"  y = "+ y);
      return true;
    }
    
    System.out.println("find! "+word.substring(0, 1) +  "   x = " + x +"  y = "+ y);

    for(int i=0; i< 8; i++) {
      if(Festival.findWord(x + Festival.x[i], y + Festival.y[i], word.substring(1), puzzle))
        return true;
    }
    return false;
  }
}
