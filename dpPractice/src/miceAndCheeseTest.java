import java.util.Arrays;

public class miceAndCheeseTest {


    public static void main(String[] args) {
        int[] reward1 = {1, 1, 3, 4};
        int[] reward2 = {4, 4, 1, 1};
        int k = 2;

        int res = miceAndCheese(reward1, reward2, k);

        System.out.println(res);
    }


    public static int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int sum = 0;
        int[] r1cha = new int[reward2.length];

        for (int i = 0; i < reward2.length; i++) {
            sum += reward2[i];
            r1cha[i] = reward1[i] - reward2[i];
        }

        Arrays.sort(r1cha);
        for (int i = n - k; i < n; i++) {
            sum+=r1cha[i];
        }

        return sum;

    }

}
