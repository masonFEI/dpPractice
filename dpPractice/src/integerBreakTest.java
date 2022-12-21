public class integerBreakTest {

    public static void main(String[] args) {

        int res = integerBreak(10);

        System.out.println(res);
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        if (n > 2) {
            for (int i = 3; i <= n; i++) {
                for (int j = 0; j <= i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
                }
            }
        }

        return dp[n];

    }


}
