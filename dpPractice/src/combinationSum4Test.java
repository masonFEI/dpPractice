public class combinationSum4Test {


    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
        int[] nums = {9};
        int target = 3;
        int res = combinationSum4(nums, target);
        System.out.println(res);
    }

    public static int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {

            for (int j = 0; j < nums.length; j++) {

                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }

        }

        return dp[target];

    }


}
