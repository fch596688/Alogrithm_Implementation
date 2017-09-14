import java.util.Arrays;

/**
 * Created by fch59 on 9/13/2017.
 */
public class MatrixRotate {
    public boolean rotate(int[][] matrix){
        if(matrix.length == 0 || matrix.length != matrix[0].length ) return false;
        int n = matrix.length;
        int layerNum = matrix.length/2;
        for (int i = 0; i < layerNum; i++){
            for(int j = i; j < n - 1 - i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return true;
    }

    public static void main(String[] args){
        MatrixRotate rotateInstance = new MatrixRotate();
        int [][] matrix = new int[][]{
                {1, 5, 9, 13},
                {2, 6, 10, 14},
                {3, 7, 11, 15},
                {4, 8, 12, 16}
        };
        rotateInstance.rotate(matrix);
    }
}
