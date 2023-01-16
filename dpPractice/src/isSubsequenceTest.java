public class isSubsequenceTest {


    public static void main(String[] args) {

    }


    public boolean isSubsequence(String s, String t) {

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 1; j <= t.length(); j++) {

                if (s.substring(i - 1, i).equals(t.substring(j - 1, j))) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[s.length()][t.length()] == s.length();

    }


}
