import java.util.*;
/*
    Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).
    Zombies can turn the nearest people(up/down/left/right) into zombies every day,
    but can not through wall. How long will it take to turn all people into zombies?
    Return -1 if can not turn all people into zombies.
    Given a matrix:

    0 1 2 0 0
    1 0 0 2 1
    0 1 0 0 0

    return 2
 */
// keypoint: level_traverse: there are more than one zombies.
// People and Zombie relationship: people  == 0; return days;
public class ZombieInMatrix {
    class Coordinate{
        int x;
        int y;
        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    int WALL = 2;
    int ZOMBIE = 1;
    int PEOPLE = 0;

    public int zombie(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int day = 0;
        int row = grid.length;
        int col = grid[0].length;
        int people = 0;
        int[] xDirection = {-1, 0, 0, 1};
        int[] yDirection = {0, -1, 1, 0};

        Queue<Coordinate> queue = new LinkedList<>();

        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == PEOPLE){
                    people++;
                }
                if(grid[i][j] == ZOMBIE){
                    queue.offer(new Coordinate(i, j));
                }
            }
        }

        if(people == 0){
            return day;
        }

        while(!queue.isEmpty()){
            day++;
            int size = queue.size();
            for(int k = 0; k < size; k++){
                Coordinate coor = queue.poll();
                for(int i = 0; i < 4; i++){
                    int x = coor.x + xDirection[i];
                    int y = coor.y + yDirection[i];
                    Coordinate neighbor  = new Coordinate(x, y);
                    if(!isPeople(grid, neighbor)){
                        continue;
                    }
                    grid[x][y] = ZOMBIE;
                    people--;
                    if(people == 0){
                        return day;
                    }
                    queue.offer(neighbor);
                }
            }
        }
        return -1;
    }

    private boolean isPeople(int[][] grid, Coordinate coor){
        int row = grid.length;
        int col = grid[0].length;
        if(coor.x < 0 || coor.x >= row){
            return false;
        }
        if(coor.y < 0 || coor.y >= col){
            return false;
        }
        return (grid[coor.x][coor.y] == PEOPLE);
    }
}
