import java.util.ArrayList;
import java.util.List;

public class maximumEvenSplitTest {


    public static void main(String[] args) {
//        long finalSum =8;
//        long finalSum =12;
        long finalSum =28;

        List<Long> res = maximumEvenSplit(finalSum);

        System.out.println(res);
    }

    public static List<Long> maximumEvenSplit(long finalSum) {

        List<Long> ans = new ArrayList<Long>();

        if (finalSum % 2 > 0) return ans;

        for (long i = 2; i <= finalSum; i += 2) {
            ans.add(i);
            finalSum -= i;
        }
        int back = ans.size() - 1;
        ans.set(back, ans.get(back) + finalSum);
        return ans;
    }




}
