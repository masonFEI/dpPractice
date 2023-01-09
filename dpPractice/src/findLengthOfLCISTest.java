import java.util.Arrays;

public class findLengthOfLCISTest {


    public static void main(String[] args) {

    }

    public int findLengthOfLCIS(int[] nums) {

        if (nums.length <= 1) {
            return 1;
        }
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }

            if (dp[i] > res) {
                res = dp[i];
            }
        }

        return res;

    }


}
