//package a1;

public class Grid
{
protected int rows;         // number of grid rows
protected int cols;         // number of grid columns

protected boolean [][] grid;     // the grid containing blobs
private boolean [][] visitedGrid;
// You may define helper variables as needed

public Grid(int rows, int cols, boolean[][] grid)

{
 this.rows = rows;
 this.cols = cols;
 this.grid = grid;

}

public String toString()
{
 String gridString = "";
 for (int i = 0; i < rows; i++)
 {
   for (int j = 0; j < cols; j++)
   {
     if (grid[i][j])
       gridString = gridString + "X";
     else
       gridString = gridString + ".";
    }
   gridString = gridString + "\n";   // end of row
 }
 return gridString;
}

public int blobCount()
// returns the number of blobs in this grid
{
  setNull();
  int count = 0;
  for(int i = 0; i < rows; i++){
    for(int j = 0; j < cols; j++)
      {
        if(grid[i][j] && !visitedGrid[i][j])
          {
            count++;
            System.out.println("Found one at " + i + " and " + j);
            setVisit(i, j);
          }
      }
    }

 return count;
}

private void setVisit(int i, int j)
  {
    visitedGrid[i][j] = true;

        for(int k = i-1; k <= i+1; k++){
          for(int l = j-1; l <= j+1; l++)
          {
            try{
              if(grid[k][l] && !visitedGrid[k][l]){
                System.out.println("found an adjacent x at "+k+" and " + l);
                setVisit(k, l);
              }
            }
            catch (ArrayIndexOutOfBoundsException e) {
              continue;
            }
          }
        }
  }


private void setNull()
{
  visitedGrid = new boolean[rows][cols];
  for(int i = 0; i < rows; i++){
     for(int j = 0; j < cols; j++)
         visitedGrid[i][j] = false;
       }
}
}
