public class coinChangeTest {


    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;

        int res = coinChange(coins, amount);
        System.out.println(res);
    }


    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }


        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {

                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE?-1:dp[amount];

    }

}
