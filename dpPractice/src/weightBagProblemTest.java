public class weightBagProblemTest {


    public static void main(String[] args) {


        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;
        int res = testWeightBagProblem(weight, value, bagWight);
        System.out.println(res);

    }


    public static int testWeightBagProblem(int[] weight, int[] value, int bagWight) {

        int[] dp = new int[bagWight + 1];

        for (int i = 0; i < weight.length; i++) {

            for (int j = bagWight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        return dp[bagWight];


    }


}
