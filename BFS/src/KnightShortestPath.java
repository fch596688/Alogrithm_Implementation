import java.util.*;
public class KnightShortestPath {

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }

        int step = 0;

        int[] xDirection = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] yDirection = {2, -2, 1, -1, 2, -2, 1, -1};


        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);

        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point point = queue.poll();
                if(point.x == destination.x && point.y == destination.y){
                    return step;
                }
                for(int j = 0; j < 8; j++){
                    int x = point.x + xDirection[j];
                    int y = point.y + yDirection[j];
                    System.out.println("Point: (" + x + ", " + y + ")");
                    Point neighbor = new Point(x,y);
                    if(!inBound(grid, neighbor)){
                        continue;
                    }

                    queue.offer(neighbor);
                    grid[point.x][point.y] = true;
                }
            }
            step++;
        }
        return -1;
    }

//    int n, m; // size of the chessboard
//    int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
//    int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};
//public int shortestPath(boolean[][] grid, Point source, Point destination) {
//    if (grid == null || grid.length == 0 || grid[0].length == 0) {
//        return -1;
//    }
//
//    n = grid.length;
//    m = grid[0].length;
//
//    Queue<Point> queue = new LinkedList<>();
//    queue.offer(source);
//
//    int steps = 0;
//    while (!queue.isEmpty()) {
//        int size = queue.size();
//        for (int i = 0; i < size; i++) {
//            Point point = queue.poll();
//            if (point.x == destination.x && point.y == destination.y) {
//                return steps;
//            }
//
//            for (int direction = 0; direction < 8; direction++) {
//                Point nextPoint = new Point(
//                        point.x + deltaX[direction],
//                        point.y + deltaY[direction]
//                );
//
//                if (!inBound(nextPoint, grid)) {
//                    continue;
//                }
//
//                queue.offer(nextPoint);
//                // mark the point not accessible
//                grid[nextPoint.x][nextPoint.y] = true;
//            }
//        }
//        steps++;
//    }
//
//    return -1;
//}
    private boolean inBound(boolean[][] grid, Point point){
        int row = grid.length;
        int col = grid[0].length;
        if(point.x < 0 || point.x >= row){
            return false;
        }
        if(point.y < 0 || point.y >= col){
            return false;
        }

        return (grid[point.x][point.y] == false);
    }

    public static void main(String[] args){
        KnightShortestPath obj = new KnightShortestPath();
        boolean[][] grid = {{false,true,false},{false,false,false},{false,false,false}};
        Point source = new Point(2, 0);
        Point destination = new Point(2, 2);
        int step = obj.shortestPath(grid, source, destination);
        System.out.println(step);
    }
}
