import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class semiOrderedPermutationTest {

    public static void main(String[] args) {
//        int[] nums = {2,1,4,3};
        int[] nums = {1,3,4,2,5};

        int res = semiOrderedPermutation(nums);

        System.out.println(res);
    }


    public static int semiOrderedPermutation(int[] nums) {


        int minNum = Arrays.stream(nums).min().getAsInt();
        int maxNum = Arrays.stream(nums).max().getAsInt();
        Map<Integer, Integer> indexMapping = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            indexMapping.put(nums[i], i);
        }
        int minIndex = indexMapping.get(minNum);
        int maxIndex = indexMapping.get(maxNum);
        int res = 0;
        if (maxIndex < minIndex) {
            res = minIndex + (nums.length - 1 - maxIndex) - 1;
        } else {
            res = minIndex + (nums.length - 1 - maxIndex);
        }

        return res;
    }

}
