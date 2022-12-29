public class rob2Test {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        int res = rob(nums);

        System.out.println(res);
    }

    public static int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int robStart = getMoneyNum(nums, 0, nums.length - 2);
        int robEnd = getMoneyNum(nums, 1, nums.length - 1);
        return Math.max(robStart, robEnd);

    }


    public static int getMoneyNum(int[] nums, int start, int end) {

        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[end];

    }


}
