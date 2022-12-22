public class BagProblemTest {


    public static void main(String[] args) {


        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        int res = testWeightBagProblem(weight, value, bagSize);

        System.out.println(res);

    }


    public static int testWeightBagProblem(int[] weight, int[] value, int bagSize) {

        int[][] dp = new int[weight.length][bagSize + 1];

        for (int j = 0; j <= bagSize; j++) {
            if (j >= weight[0]) {
                dp[0][j] = value[0];
            }
        }

        for (int i = 1; i < weight.length; i++) {

            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }

        }

        return dp[weight.length - 1][bagSize];


    }


}
