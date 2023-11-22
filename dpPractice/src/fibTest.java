public class fibTest {


    public static void main(String[] args) {

        int res = fib(3);

        System.out.println(res);
    }


    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%1000000007;
        }

        return dp[n];
    }

}
