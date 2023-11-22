public class maximumSumTest {


    public static void main(String[] args) {
//        int[] arr = new int[]{1,-2,-2,3};
//        int[] arr = new int[]{2, 1, -2, -5, -2};
        int[] arr = new int[]{-1,-1,-1,-1};
//        int[] arr = new int[]{1,-2,0,3};

        int res = maximumSum(arr);
        System.out.println(res);
    }


    public static int maximumSum(int[] arr) {
        int[][] dp = new int[arr.length][2];
        int maxValue = arr[0];
        // 0 未删除1个
        // 1 已删除1个
        dp[0][0] = arr[0];
//        dp[0][1] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp[i][0] =  Math.max(arr[i], dp[i - 1][0] + arr[i]);
            dp[i][1] =  Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);

            if (dp[i][0]>maxValue){
                maxValue = dp[i][0];
            }
            if (dp[i][1]>maxValue){
                maxValue = dp[i][1];
            }
        }
        return maxValue;
    }


}
