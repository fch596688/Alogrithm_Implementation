import java.util.Arrays;



/**
 * Created by fch59 on 9/12/2017.
 */
public class TestClient {
    private int carry = 0;
    public void scope(){

        printNum();
        System.out.println(carry);
    }
    private void printNum (){
        carry = carry + 1;
        System.out.println("interal carry: " + carry);
    }
    public int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
    public static void main(String[] args){
        TestClient test = new TestClient();
        int[] nums = {1, 2, 1, 3, 2, 5};

        int i = Integer.MAX_VALUE;
        int x = i << 1;
        if(false)
        System.out.println(i);
        System.out.println(x);
    }
}
