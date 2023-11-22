public class printNumbersTest {


    public static void main(String[] args) {

    }


    public int[] printNumbers(int n) {

        int target = (int) (Math.pow(n+1, 10) - 1);
        int[] res = new int[target];

        for (int i=1;i<target;i++){
            res[i-1]=i;
        }

        return res;
    }



}
