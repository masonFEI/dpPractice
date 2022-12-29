public class maxProfit4Test {


    public static void main(String[] args) {

    }


    public int maxProfit(int k, int[] prices) {

        int[][] dp = new int[prices.length][2 * k + 1];

        for (int i = 1; i < 2 * k + 1; i++) {

            if (i % 2 == 1) {
                dp[0][i] = -prices[0];
            }
        }


        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {

                if (j % 2 == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }

        return dp[prices.length - 1][2 * k];

    }


}
