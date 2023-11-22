public class sumNumsTest {


    public static void main(String[] args) {

        int n = 2;
        int res = sumNums(n);
        System.out.println(res);
    }

    public static int res ;
    public static int sumNums(int n) {

        res = 0;
        res = loopSum(n);


        System.out.println(res);


        return res;
    }


    public static int loopSum(int n){

        if (n > 1) {
            res = loopSum(n-1) + n;
        } else {
            res+=1;
        }

        return res;

    }



}
