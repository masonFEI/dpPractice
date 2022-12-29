public class maxProfitTest {


    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);

            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);

        }

        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);

    }


}
