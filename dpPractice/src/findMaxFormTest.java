public class findMaxFormTest {

    public static void main(String[] args) {
        String[] strs ={"10","0001","111001","1","0"};
        int m = 3;
        int n = 3;
        int res = findMaxForm(strs,m,n);
        System.out.println(res);
    }


    public static int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (int strsi = 0; strsi < strs.length; strsi++) {
            int oneNum = 0, zeroNum = 0;
            String itemString = strs[strsi];
            for (int stri = 0; stri < itemString.length(); stri++) {
                if (itemString.substring(stri, stri + 1).equals("0")) {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }

        }

        return dp[m][n];


    }

}
