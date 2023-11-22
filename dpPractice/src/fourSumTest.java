import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSumTest {


    public static void main(String[] args) {

    }




    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums.length < 4) {
            return res;
        }

        if (nums.length == 4 && Arrays.stream(nums).sum() != target ) {
            return res;
        } else if(nums.length == 4 && Arrays.stream(nums).sum() == target){
            List<Integer> item = new ArrayList<>();
            for (int i =0;i < nums.length;i++){
                item.add(nums[i]);
            }
            res.add(item);
            return  res;
        }

        Arrays.sort(nums);
        int a = 0;
        int b = a+1;
        int c = b+1;
        int d = nums.length-1;

        while (a<b){
            while (b<c){

            }


        }








        return res;


    }


}
