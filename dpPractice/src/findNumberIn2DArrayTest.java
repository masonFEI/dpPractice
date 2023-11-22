public class findNumberIn2DArrayTest {


    public static void main(String[] args) {
//        int[][] matrix = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
//        int[][] matrix = {{}};
//        int[][] matrix = {{-5}};
//        int[][] matrix = {{-1,3}};
        int[][] matrix = {{5,8,11,11,12,12,14,14,19},{20,21,22,29,30,32,34,36,43}};
        int target = 22;
        boolean res = findNumberIn2DArray(matrix, target);

        System.out.println(res);
    }



    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int i = 0;i<matrix.length;i++){

            if (matrix[i][0] <= target && matrix[i][matrix[i].length-1] >= target ) {
                int left = 0;
                int right = matrix[i].length - 1;



                while (left < right) {
                    if (matrix[i][left] == target || matrix[i][right] == target) {
                        return true;
                    }
                    int mid = (left+right-1) / 2;

                    if (matrix[i][mid] == target) {
                        return true;
                    } else if(matrix[i][mid] > target){
                        right = mid - 1;
                    } else if (matrix[i][mid] < target) {
                        left = mid + 1;
                    }
                }
            }
        }

        return false;
    }



}
