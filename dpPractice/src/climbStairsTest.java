public class climbStairsTest {


    public static void main(String[] args) {
        int res =climbStairs(3);
        System.out.println(res);
    }

    public static int climbStairs(int n) {


        int res = 0;

        int[] dp = new int[n + 1];
        dp[1] = 1;

        if (n >= 2) {
            dp[2] = 2;
        }

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];


    }

}
