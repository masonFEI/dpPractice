import java.util.Arrays;

public class canPartitionTest {


    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};

        boolean res = canPartition(nums);

        System.out.println(res);
    }


    public static boolean canPartition(int[] nums) {

        if (Arrays.stream(nums).sum() % 2 != 0) {
            return false;
        }

        int target = Arrays.stream(nums).sum() / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length; i++) {

            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;
    }


}
