import java.util.*;
/*
    Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island.
    If two 1 is adjacent, we consider them in the same island.
    We only consider up/down/left/right adjacent.
    Find the number of islands.
 */

//Key point: Coordinate, inBound()
public class NumberOfIslands {
    public class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(boolean[][] grid) {
        if (grid.length == 0 || grid[0].length == 0 || grid == null){
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int islands = 0;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if(grid[i][j]){
                    markedByBFS(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void markedByBFS(boolean[][] grid, int row, int col){
        int[] xDirection = {-1, 0, 1, 0};
        int[] yDirection = {0, -1, 0, 1};

        Queue<Coordinate> queue = new LinkedList<>();
        grid[row][col] = false;
        Coordinate coor = new Coordinate(row, col);
        queue.offer(coor);

        while (!queue.isEmpty()) {
            Coordinate head = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = head.x + xDirection[i];
                int y = head.y + yDirection[i];
                Coordinate neighbor = new Coordinate(x, y);
                if (!inBound(grid, neighbor)) {
                    continue;
                }
                if (grid[x][y]) {
                    queue.offer(neighbor);
                    grid[x][y] = false;
                }
            }
        }
    }

    private boolean inBound (boolean[][] grid, Coordinate coor){
        int row = grid.length;
        int col = grid[0].length;

        return(coor.x < row && coor.y < col && coor.x >= 0 && coor.y >= 0);
    }
}
