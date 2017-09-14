/**
 * Created by fch59 on 9/13/2017.
 * Time Complexity: O(mn)
 * Space Complexity: O(1)
 */
public class MatrixZero {
    public void setZeros(int[][] matrix){
        boolean rowHasZero = false;
        boolean columnHasZero = false;
        int rowNum = matrix.length;
        int columnNum = matrix[0].length;
        //loop through the first row
        for(int i = 0; i < columnNum; i++){
            if(matrix[0][i] == 0){
                rowHasZero = true;
                break;
            }
        }
        //loop trough the first column
        for(int j = 0; j < rowNum; j++){
            if(matrix[j][0] == 0){
                columnHasZero = true;
                break;
            }
        }
        //if there is the value of element that equals 0 in the rest of matrix, set 0 in column and row
        for(int i = 1; i < rowNum; i++){
            for(int j = 1; j < columnNum ; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < rowNum; i++){
            for(int j = 1; j < columnNum ; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowHasZero){
            for(int i = 0; i < columnNum; i++){
                matrix[0][i] = 0;
            }
        }
        if(columnHasZero){
            for(int i = 0; i < rowNum; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
