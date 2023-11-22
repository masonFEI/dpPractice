import java.util.*;

public class threeSumTest {


    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};


        List<List<Integer>> res = threeSum(nums);

        System.out.println(res);

    }


    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> resSet = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            int twoSum = 0 - nums[i];
            int left = i+1;
            int right = nums.length-1;

            while(left<right){
                    if (nums[left]+nums[right] == twoSum) {
                        List<Integer> resItem= new ArrayList<>();
                        resItem.add(nums[i]);
                        resItem.add(nums[left]);
                        resItem.add(nums[right]);
                        Collections.sort(resItem);
                        resSet.add(resItem);
                        left++;
                        right--;
                    } else if(nums[left]+nums[right] > twoSum){
                        right--;
                    } else if(nums[left]+nums[right] < twoSum){
                        left++;
                    }
            }

        }

        res.addAll(resSet);
        return res;


    }


}
