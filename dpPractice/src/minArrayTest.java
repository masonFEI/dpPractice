public class minArrayTest {


    public static void main(String[] args) {

    }


    public int minArray(int[] numbers) {
        int res = numbers[0];
        if (numbers.length == 1) {
            return res;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i+1]<numbers[i]) {
                res = numbers[i+1];
                break;
            }
        }

        return res;

    }


}
