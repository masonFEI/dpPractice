import java.util.Arrays;

public class lastStoneWeightIITest {


    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        int res = lastStoneWeightII(stones);
        System.out.println(res);
    }


    public static int lastStoneWeightII(int[] stones) {

        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return (sum - dp[target]) - dp[target];


    }


}
