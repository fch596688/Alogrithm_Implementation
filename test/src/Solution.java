import java.util.HashMap;

public class Solution {
    public HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    public Solution(){
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    public int romanToInt(String s) {
        int sum = 0;
        int length = s.length();
        int val1 = 0; int val2 = 0;
        for(int i = 0; i < length; i++ ){
            val1 = map.get(s.charAt(i));
            if(i < length - 1 ){
                val2 = map.get(s.charAt(i+1));
                if(val2 > val1){
                    sum = sum + val2 - val1;
                    i++;
                }else{
                    sum = sum + val1;
                }
            }else{
                sum = sum + val1;
            }

        }
        return sum;
    }

    public static void main(String[] args){
        Solution test = new Solution();
        int result = test.romanToInt("DCXXI");
        System.out.println(result);
    }
}
