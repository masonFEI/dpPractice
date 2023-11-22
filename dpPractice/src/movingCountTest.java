public class movingCountTest {



    public static int res;

    public static void main(String[] args) {

//        int m = 11;
//        int n = 8;
//        int k = 16;

//        int m = 16;
//        int n = 8;
//        int k = 4;
//
        int m = 38;
        int n = 15;
        int k = 9;

        int res = movingCount(m, n, k);

        System.out.println(res);

    }


    public static int movingCount(int m, int n, int k) {

        res = 0;

        int[][] masks = new int[m][n];

        findWay(0,0,masks,m,n, k);

        return res;


    }


    public static void findWay(int i, int j, int[][] masks, int m, int n, int k) {
        int xSum = 0;
        int tmpNum = 0;
        if (i >= 10) {
            tmpNum = i;
            while (tmpNum >= 10) {
                xSum += tmpNum % 10;
                tmpNum = tmpNum / 10;
            }

            xSum += tmpNum;

        } else {
            xSum = i;
        }

        if (xSum > k) {
            return ;
        } else {
            int ySum = 0;
            if (j >= 10) {
                tmpNum = j;
                while (tmpNum >= 10) {
                    ySum += tmpNum % 10;
                    tmpNum = tmpNum / 10;
                }

                ySum += tmpNum;

            } else {
                ySum = j;
            }

            if (ySum + xSum <= k) {
                masks[i][j] = 1;
                res++;

                if (j + 1 < n && masks[i][j+1] == 0 ) {

                    findWay(i, j + 1, masks, m, n, k);
                }

                if (i + 1 < m && masks[i+1][j] == 0) {
                     findWay(i+1, j, masks, m, n, k);
                }

                if ( j - 1 >= 0 && masks[i][j-1] == 0) {
                     findWay(i, j-1, masks, m, n, k);
                }

                if (i - 1 >= 0 && masks[i-1][j] == 0) {
                     findWay(i-1, j, masks, m, n, k);
                }
            } else {
                return ;
            }
        }
    }


}
