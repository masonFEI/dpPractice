public class minCostClimbingStairsTest {


    public static void main(String[] args) {
        int[] cost = {10,15,20};

        int res = minCostClimbingStairs(cost);

        System.out.println(res);
    }


    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[cost.length];
    }


}
