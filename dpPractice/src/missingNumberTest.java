import java.util.Arrays;

public class missingNumberTest {


    public static void main(String[] args) {

    }



    public int missingNumber(int[] nums) {

        int n = nums.length+1;
        int target = (n-1)*(n)/2;
        return target -Arrays.stream(nums).sum();


    }




}
