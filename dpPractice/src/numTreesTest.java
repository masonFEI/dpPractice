public class numTreesTest {


    public static void main(String[] args) {
        int res = numTrees(4);
        System.out.println(res);
    }

    public static int numTrees(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        if (n > 2) {
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
        }

        return dp[n];
    }


}
