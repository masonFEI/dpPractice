public class uniquePathsWithObstaclesTest {


    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        int[][] obstacleGrid = {{1, 0}};

        int res = uniquePathsWithObstacles(obstacleGrid);

        System.out.println(res);

    }


    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean xflag = false;
        boolean yflag = false;

        for (int i = 0; i < obstacleGrid.length; i++) {

            if (obstacleGrid[i][0] == 1) {
                xflag = true;
            }

            if (!xflag) {
                dp[i][0] = 1;
            }
        }


        for (int i = 0; i < obstacleGrid[0].length; i++) {

            if (obstacleGrid[0][i] == 1) {
                yflag = true;
            }


            if (!yflag) {
                dp[0][i] = 1;
            }

        }


        for (int i = 1; i < obstacleGrid.length; i++) {
            int[] item = obstacleGrid[i];

            for (int j = 1; j < item.length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];


    }

}
