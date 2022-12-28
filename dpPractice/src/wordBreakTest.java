import java.util.ArrayList;
import java.util.List;

public class wordBreakTest {


    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList() {
            {
                add("leet");
                add("code");
            }
        };
        boolean res = wordBreak(s, wordDict);
        System.out.println(res);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                String item = s.substring(j, i);

                if (wordDict.contains(item) && dp[j]) {
                    dp[i] = true;
                }

            }

        }

        return dp[s.length()];

    }


}
