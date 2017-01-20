//package a1;

public class Grid{
protected int rows;         // number of grid rows
protected int cols;         // number of grid columns

protected boolean [][] grid;     // the grid containing blobs
private boolean [][] visitedGrid;
// You may define helper variables as needed

  public Grid(int rows, int cols, boolean[][] grid){
   this.rows = rows;
   this.cols = cols;
   this.grid = grid;
  }

  public String toString(){
   String gridString = "";
   for (int i = 0; i < rows; i++){
     for (int j = 0; j < cols; j++){
       if (grid[i][j])
         gridString = gridString + "X";
       else
         gridString = gridString + ".";
      }
     gridString = gridString + "\n";   // end of row
   }
   return gridString;
  }

// returns the number of blobs in this grid
  public int blobCount(){
    setFalse();
    int count = 0;
    for(int i = 0; i < rows; i++){
      for(int j = 0; j < cols; j++){
          if(grid[i][j] && !visitedGrid[i][j]){
              count++;
              setVisit(i, j);
          }
      }
    }
   return count;
  }

// Finds all x's in a blob
  private void setVisit(int i, int j){
    visitedGrid[i][j] = true;
    for(int k = i-1; k <= i+1; k++){
      for(int l = j-1; l <= j+1; l++){
        try{
          if(grid[k][l] && !visitedGrid[k][l]){
            setVisit(k, l);
          }
        }
        catch (ArrayIndexOutOfBoundsException e) {
          continue;
        }
      }
    }
  }

// Initially sets all values in visitedGrid to false
  private void setFalse(){
    visitedGrid = new boolean[rows][cols];
    for(int i = 0; i < rows; i++){
       for(int j = 0; j < cols; j++)
           visitedGrid[i][j] = false;
    }
  }
}
