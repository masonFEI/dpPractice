public class numSquaresTest {


    public static void main(String[] args) {



        int res = numSquares(1);
        System.out.println(res);

    }


    public static int numSquares(int n) {

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i <= n; i++) {

            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }

        return dp[n];
    }


}
