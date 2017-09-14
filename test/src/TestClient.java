import java.util.Arrays;

/**
 * Created by fch59 on 9/12/2017.
 */
public class TestClient {
    public static void main(String[] args){
        int count = 0;
        int count2 = 0;
//       int[][] matrix = new int[10][2];
//        System.out.println(matrix[0].length);
//        System.out.println(matrix.length);
//        System.out.println(Arrays.deepToString(matrix));
        for (int i = 0; i < 10; i++){
            count++;
            System.out.println(count);
        }
        System.out.println(count);
        int k = 10;
        while(k > 0){
            count2++;
            System.out.println(count2);
            k--;
        }
        System.out.println(count2);
}
}
