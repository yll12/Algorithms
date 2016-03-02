package algo.programmingchallenge;

//ref: http://www.geeksforgeeks.org/find-number-of-islands/
public class FindNumberOfIslands_DFS {

    final int rows;
    final int cols;
    boolean[][] visited;
    private static final int DIRECTIONS = 4; //Up, Down, Right, Left
    
    public FindNumberOfIslands_DFS(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public int countIsland(int[][] Map) {
        int count = 0;
        visited = new boolean[rows][cols]; // defaults to false
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Map[i][j] == 1 && !visited[i][j]) { 
                    dfs(Map, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] map, int i, int j) {
        
        //          (-1, 0) 
        // ( 0, -1) x=(0,0) ( 0, +1) 
        //          (+1, 0) 
        int[] rowNbr = {-1, 0, 0, 1};
        int[] colNbr = {0, -1, +1, 0};
        
        visited[i][j] = true;
        
        for (int k = 0; k < DIRECTIONS ; k++) {
            
            // Iterate over the following:
            //          (i-1, j) 
            // (i, j-1)  x=(i,j)  (i, j+1) 
            //          (i+1, j) 
            int adjRow = i + rowNbr[k]; // corresponds to 
            int adjCol = j + colNbr[k]; // how much to shift on the col
            if (withinBoundary(adjRow, adjCol)
                 && !visited[adjRow][adjCol]
                 && isAdjacent(map, adjRow, adjCol)) {
                dfs(map, adjRow, adjCol);
            }
            
        }
    }

    private boolean isAdjacent(int[][] map, int adjRow, int adjCol) {
        return map[adjRow][adjCol] == 1;
    }

    private boolean withinBoundary(int adjRow, int adjCol) {
        return (0 <= adjRow && adjRow < rows) 
                && (0 <= adjCol && adjCol < cols);
    }

}

