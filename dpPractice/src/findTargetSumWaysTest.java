import java.util.Arrays;

public class findTargetSumWaysTest {


    public static void main(String[] args) {

    }


    public int findTargetSumWays(int[] nums, int target) {

        int sum = Arrays.stream(nums).sum();

        if (Math.abs(target) > sum || (target + sum) % 2 != 0) {
            return 0;
        }

        int size = (target + sum) / 2;

        if (size < 0) {
            size = -size;
        }

        int[] dp = new int[size + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[size];

    }


}
